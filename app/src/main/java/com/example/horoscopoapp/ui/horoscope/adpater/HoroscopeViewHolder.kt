package com.example.horoscopoapp.ui.horoscope.adpater

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopoapp.databinding.ItemHoroscopeBinding
import com.example.horoscopoapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val bining = ItemHoroscopeBinding.bind(view)
    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        val context = bining.tvTitle.context
        bining.ivHoroscope.setImageResource(horoscopeInfo.img)
        bining.tvTitle.text = context.getString(horoscopeInfo.name)

        bining.parent.setOnClickListener {
            startRotationAnimation(
                bining.ivHoroscope,
                newLambda = { onItemSelected(horoscopeInfo) })
        }
    }

    private fun startRotationAnimation(view: View, newLambda: () -> Unit) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction { newLambda() }
            start()
        }
    }
}