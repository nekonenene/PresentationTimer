package com.x0.hatonekoe.presentation_timer.presentation.presenter

import android.util.Log
import com.x0.hatonekoe.presentation_timer.PresentationTimerApp
import com.x0.hatonekoe.presentation_timer.domain.usecase.CurrentTimeUseCaseIF
import com.x0.hatonekoe.presentation_timer.presentation.activity.MainFragment
import com.x0.hatonekoe.presentation_timer.util.PresentationCountDownTimer

class MainFragmentPresenter(useCase: CurrentTimeUseCaseIF): MainFragmentPresenterIF {
    val mUseCase: CurrentTimeUseCaseIF = useCase

    lateinit var mFragment: MainFragment
    val intervalMilliSec: Long = 100
    val mCountDown: PresentationCountDownTimer= PresentationCountDownTimer(mUseCase.getInitialTime(), intervalMilliSec)

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
        PresentationTimerApp.appComponent.inject(mCountDown)
        mCountDown.start()
    }

    override fun update() {
        mFragment.setTimerText(mUseCase.getRemainingTimeString())
    }
}
