package com.x0.hatonekoe.presentation_timer.presentation.presenter

import com.x0.hatonekoe.presentation_timer.domain.usecase.CurrentTimeUseCaseIF
import com.x0.hatonekoe.presentation_timer.presentation.activity.MainFragment
import com.x0.hatonekoe.presentation_timer.util.PresentationCountDownTimer

class MainFragmentPresenter(useCase: CurrentTimeUseCaseIF): MainFragmentPresenterIF {
    val mUseCase: CurrentTimeUseCaseIF = useCase

    lateinit var mFragment: MainFragment
    lateinit var mCountDown: PresentationCountDownTimer
    val intervalMilliSec: Long = 100

    override fun setFragment(fragment: MainFragment) {
        mFragment = fragment
    }

    override fun onStart() {
        mFragment.setTimerText(mUseCase.getRemainingTimeString())
    }

    override fun onClick() {
        mCountDown = PresentationCountDownTimer(mUseCase.getInitialTime(), intervalMilliSec)
        mCountDown.start()
    }

    override fun update() {
        mFragment.setTimerText(mUseCase.getRemainingTimeString())
    }
}
