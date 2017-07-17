package com.x0.hatonekoe.presentation_timer.model.repository

import android.content.Context
import android.content.SharedPreferences
import com.x0.hatonekoe.presentation_timer.PresentationTimerApp
import com.x0.hatonekoe.presentation_timer.model.entity.TimerModel
import javax.inject.Inject

/**
 * TimerModel をデータベースから取り出したり保存したり
 */
class TimerRepository: TimerRepositoryIF {
    @Inject
    lateinit var mContext: Context
    val mPref: SharedPreferences

    init {
        injectSelf()
        mPref = mContext.getSharedPreferences(this.javaClass.name, Context.MODE_PRIVATE)
    }

    private fun injectSelf() {
        PresentationTimerApp.appComponent.inject(this)
    }

    override fun timer1(): TimerModel {
        return TimerModel(10000)
    }

    override fun getTimerByName(name: String): TimerModel {
        // 保存領域から取り出す処理……

        return TimerModel(20000)
    }
}
