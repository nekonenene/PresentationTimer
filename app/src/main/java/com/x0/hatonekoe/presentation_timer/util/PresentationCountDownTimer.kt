package com.x0.hatonekoe.presentation_timer.util

import android.os.CountDownTimer
import android.util.Log
import com.x0.hatonekoe.presentation_timer.controller.MainFragmentPresenter
import com.x0.hatonekoe.presentation_timer.model.TimerModel

class PresentationCountDownTimer(millisInFuture: Long, countDownInterval: Long): CountDownTimer(millisInFuture, countDownInterval) {
    override fun onTick(millisUntilFinished: Long) {
        TimerModel.millisUntilFinished = millisUntilFinished
        MainFragmentPresenter.update()
    }

    override fun onFinish() {
        Log.d(this.javaClass.name, "時間終了です！！！")
    }
}
