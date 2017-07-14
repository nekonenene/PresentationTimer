package com.x0.hatonekoe.presentation_timer.service

import android.os.CountDownTimer

class CountDownService(millisInFuture: Long, countDownInterval: Long): CountDownTimer(millisInFuture, countDownInterval) {
    override fun onTick(millisUntilFinished: Long) {
        val minute: Int = (millisUntilFinished / 1000 / 60).toInt()
        val second: Int = (millisUntilFinished / 1000 % 60).toInt()
    }

    override fun onFinish() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}