package com.x0.hatonekoe.presentation_timer.util

import android.os.CountDownTimer
import android.util.Log
import com.x0.hatonekoe.presentation_timer.domain.entity.TimerStatus
import com.x0.hatonekoe.presentation_timer.domain.usecase.CurrentTimeUseCaseIF
import com.x0.hatonekoe.presentation_timer.presentation.presenter.MainFragmentPresenterIF
import javax.inject.Inject

class PresentationCountDownTimer(millisInFuture: Long, countDownInterval: Long): CountDownTimer(millisInFuture, countDownInterval) {

    @Inject
    lateinit var mUseCase: CurrentTimeUseCaseIF
    @Inject
    lateinit var mPresenter: MainFragmentPresenterIF

    override fun onTick(millisUntilFinished: Long) {
        mUseCase.setRemainingMilliSec(millisUntilFinished)
        mPresenter.update()
    }

    override fun onFinish() {
        Log.d(this.javaClass.name, "時間終了です！！！")
        mUseCase.setTimerStatus(TimerStatus.FINISH)
    }
}
