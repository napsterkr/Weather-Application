package com.example.myassignment.utility

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.myassignment.dataModel.WeatherEntity

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("visibleGoneBoolean")
    fun showHideBoolean(view: View, show: Boolean?) {
        view.visibility = if (show != null && show) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter("visibleGoneList")
    fun showHideList(view: View, size: Int?) {
        view.visibility = if (size != null && size > 0) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter( value = ["goneVisibleList", "goneVisibleLoaderVisible"],requireAll = true)
    fun goneVisibleList(view: View, size: Int?, goneVisibleLoaderVisible: Boolean?) {
        view.visibility = if ((size != null && size > 0) || goneVisibleLoaderVisible!!) View.GONE else View.VISIBLE
    }

    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter( value = ["cityName", "countryName"],requireAll = true)
    fun concatCityAndCountry(view: TextView, cityName: String?, countryName: String?) {
        view.text=cityName + ", " +countryName
    }

    @JvmStatic
    @BindingAdapter("parseTime")
    fun parseTime(view: TextView, millis: Long) {
        view.text=Utils.parseMilliseconds(millis)

    }


    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter("weatherData")
    fun weatherData(view: TextView, weather: WeatherEntity) {
        view.text=weather.main + " ( "+ weather.description + " )"

    }
}