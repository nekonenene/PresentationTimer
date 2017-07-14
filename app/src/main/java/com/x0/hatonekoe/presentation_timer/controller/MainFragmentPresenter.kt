package com.x0.hatonekoe.presentation_timer.controller

import com.x0.hatonekoe.presentation_timer.model.TimerModel
import com.x0.hatonekoe.presentation_timer.service.TimeService
import com.x0.hatonekoe.presentation_timer.util.PresentationCountDownTimer

object MainFragmentPresenter {
    lateinit var mFragment: MainFragment
    lateinit var mCountDown: PresentationCountDownTimer
    val intervalMilliSec: Long = 100

    fun setFragment(fragment: MainFragment) {
        mFragment = fragment
    }

    fun onStart() {
        mFragment.setTimerText(TimeService.toMinutesSecondsString(TimerModel.initialMills))
    }

    fun onClick() {
        mCountDown = PresentationCountDownTimer(TimerModel.millisUntilFinished, intervalMilliSec)
        mCountDown.start()
    }

    fun update() {
        mFragment.setTimerText(TimeService.toMinutesSecondsString(TimerModel.millisUntilFinished))
    }
}
