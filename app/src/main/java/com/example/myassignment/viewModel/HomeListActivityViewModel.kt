package com.example.myassignment.viewModel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myassignment.BR
import com.example.myassignment.R
import com.example.myassignment.RetrofitModule
import com.example.myassignment.dataModel.ListEntity
import com.example.myassignment.dataModel.WeatherApiResponeData
import com.example.myassignment.interfaces.OnToDoItemClickListner
import kotlinx.coroutines.*
import me.tatarka.bindingcollectionadapter2.ItemBinding
import okhttp3.internal.notify
import okhttp3.internal.notifyAll
import retrofit2.HttpException
import kotlin.coroutines.CoroutineContext

class HomeListActivityViewModel(private val service: RetrofitModule) : ViewModel() {

    private val parentJob = Job()


    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    var toDoItemClickListner = MutableLiveData<Void>()
    var progressBarLodingStatus = ObservableField<Boolean>(false)

    var weatherApiResponeDataFromServer = ObservableField<WeatherApiResponeData>()


    var weatherApiResponeDataForUI = ObservableField<List<ListEntity>>()


    val toDoItemBinding = ItemBinding.of<ListEntity> { itemBinding, _, _ ->
        itemBinding.set(BR.itemViewModel, R.layout.recycle_view_item)

        itemBinding.bindExtra(BR.itemClickListener, object : OnToDoItemClickListner {
            override fun termsAndConditionsOnItemClick(item: ListEntity) {
                toDoItemClickListner.postValue(null)
            }

        })
    }
    // function to fetch to do List from server
    @ExperimentalCoroutinesApi
    fun fetchToDoListFromServer() {
        progressBarLodingStatus.set(true)
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getApiService().getWeatherData(/*122007,"in","a864a9946bb06d4163ab0c95bf01e465"*/)
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {

                        weatherApiResponeDataFromServer.set(response.body())
                        showDataOnUI()
                        progressBarLodingStatus.set(false)
                    } else {
                        progressBarLodingStatus.set(false)
                    }

                } catch (e: HttpException) {
                    progressBarLodingStatus.set(false)
                    Log.d("error1", e.message ?: "Something went wrong")
                } catch (e: Throwable) {
                    progressBarLodingStatus.set(false)
                    Log.d("error1", e.message ?: "Something went wrong")
                }
            }
        }
    }

    private fun showDataOnUI() {
        weatherApiResponeDataForUI.set(listOf(weatherApiResponeDataFromServer.get()?.list?.first()) as List<ListEntity>?)
        }

    @ExperimentalCoroutinesApi
    fun onReloadClick() {

        fetchToDoListFromServer()
    }

    fun cancelAllRequests() = coroutineContext.cancel()

    fun todayButtonClicked(){
        progressBarLodingStatus.set(true)
        weatherApiResponeDataForUI.set(ArrayList())
        weatherApiResponeDataForUI.set(listOf(weatherApiResponeDataFromServer.get()?.list?.first()) as List<ListEntity>?)
        toDoItemClickListner.postValue(null)
        progressBarLodingStatus.set(false)
    }

    fun thisWeekButtonClicked(){
        progressBarLodingStatus.set(true)
        weatherApiResponeDataForUI.set(ArrayList())
        weatherApiResponeDataForUI.set(weatherApiResponeDataFromServer.get()?.list?.subList(0,7))
        toDoItemClickListner.postValue(null)
        progressBarLodingStatus.set(false)
    }

    fun thisMonthButtonClicked(){
        progressBarLodingStatus.set(true)
        weatherApiResponeDataForUI.set(ArrayList())
        weatherApiResponeDataForUI.set(weatherApiResponeDataFromServer.get()?.list)
        toDoItemClickListner.postValue(null)
        progressBarLodingStatus.set(false)
    }
}