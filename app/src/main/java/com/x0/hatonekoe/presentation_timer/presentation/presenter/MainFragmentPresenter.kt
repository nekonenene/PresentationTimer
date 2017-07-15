package com.x0.hatonekoe.presentation_timer.presentation.presenter

import android.util.Log
import com.x0.hatonekoe.presentation_timer.PresentationTimerApp
import com.x0.hatonekoe.presentation_timer.model.entity.TimerStatus
import com.x0.hatonekoe.presentation_timer.service.usecase.CurrentTimeUseCaseIF
import com.x0.hatonekoe.presentation_timer.presentation.activity.MainFragment
import com.x0.hatonekoe.presentation_timer.service.util.PresentationCountDownTimer

class MainFragmentPresenter(useCase: CurrentTimeUseCaseIF): MainFragmentPresenterIF {
    val mUseCase: CurrentTimeUseCaseIF = useCase
    lateinit var mFragment: MainFragment
    lateinit var mCountDown: PresentationCountDownTimer

    companion object {
        val intervalMilliSec: Long = 100
    }

    init {
        Log.d(this.javaClass.name, "initされた")
        PresentationTimerApp.appComponent.inject(this)
    }

    override fun setFragment(fragment: MainFragment) {
        mFragment = fragment
    }

    override fun onStart() {
        mFragment.setTimerText(mUseCase.getRemainingTimeString())
    }

    override fun onClick() {
        when (mUseCase.getTimerStatus()) {
            TimerStatus.WAIT -> {
                mCountDown = PresentationCountDownTimer(mUseCase.getRemainingMilliSec(), intervalMilliSec)
                PresentationTimerApp.appComponent.inject(mCountDown)
                mCountDown.start()

                mUseCase.setTimerStatus(TimerStatus.RUN)
            }
            TimerStatus.RUN -> {
                mCountDown.cancel()

                mUseCase.setTimerStatus(TimerStatus.WAIT)
            }
            TimerStatus.FINISH -> {
                mUseCase.resetRemainingTime()
                mFragment.setTimerText(mUseCase.getRemainingTimeString())

                mUseCase.setTimerStatus(TimerStatus.WAIT)
            }
        }
    }

    override fun update() {
        mFragment.setTimerText(mUseCase.getRemainingTimeString())
    }
}
