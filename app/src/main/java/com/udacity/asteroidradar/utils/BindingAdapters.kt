package com.udacity.asteroidradar.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.udacity.asteroidradar.domain.Asteroid

@BindingAdapter("statusIcon")
fun bindAsteroidStatusImage(imageView: ImageView, isHazardous: Boolean) {
    if (isHazardous) {
        imageView.setImageResource(R.drawable.ic_status_potentially_hazardous)
    } else {
        imageView.setImageResource(R.drawable.ic_status_normal)
    }
}

@BindingAdapter("asteroidStatusImage")
fun bindDetailsStatusImage(imageView: ImageView, isHazardous: Boolean) {
    if (isHazardous) {
        imageView.setImageResource(R.drawable.asteroid_hazardous)
    } else {
        imageView.setImageResource(R.drawable.asteroid_safe)
    }
}

@BindingAdapter("astronomicalUnitText")
fun bindTextViewToAstronomicalUnit(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.astronomical_unit_format), number)
}

@BindingAdapter("kmUnitText")
fun bindTextViewToKmUnit(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.km_unit_format), number)
}

@BindingAdapter("velocityText")
fun bindTextViewToDisplayVelocity(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.km_s_unit_format), number)
}


/**
 *
 * **/
@BindingAdapter("asteroidName")
fun TextView.setAsteroidName (item : Asteroid) {
    item?.let {
        text = item.codename
    }
}

@BindingAdapter("asteroidDate")
fun TextView.setAsteroidData (item : Asteroid) {
    item?.let {
        text = item.closeApproachDate
    }
}

@BindingAdapter("bindStatus")
fun ImageView.bindStatus (item: Asteroid) {

    item?.let {
        setImageResource(when(item.isPotentiallyHazardous) {
            true -> R.drawable.ic_status_potentially_hazardous
            else -> R.drawable.ic_status_normal
        })
    }
}

//@BindingAdapter("imageOfTheDay")
//fun ImageView.imageOfTheDay (item : PictureOfDay, imageView: ImageView) {
//
//    item?.let {
//        Picasso.with(context).load(item.url).into(imageView)
//    }
//}