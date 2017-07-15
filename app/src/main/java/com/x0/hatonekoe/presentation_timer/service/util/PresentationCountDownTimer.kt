package com.x0.hatonekoe.presentation_timer.service.util

import android.content.Context
import android.media.MediaPlayer
import android.os.CountDownTimer
import android.util.Log
import com.x0.hatonekoe.presentation_timer.PresentationTimerApp
import com.x0.hatonekoe.presentation_timer.R
import com.x0.hatonekoe.presentation_timer.model.entity.TimerStatus
import com.x0.hatonekoe.presentation_timer.presentation.presenter.MainFragmentPresenterIF
import com.x0.hatonekoe.presentation_timer.service.usecase.CurrentTimeUseCaseIF
import javax.inject.Inject

class PresentationCountDownTimer(millisInFuture: Long, countDownInterval: Long): CountDownTimer(millisInFuture, countDownInterval) {

    @Inject
    lateinit var mContext: Context
    @Inject
    lateinit var mUseCase: CurrentTimeUseCaseIF
    @Inject
    lateinit var mPresenter: MainFragmentPresenterIF
    var mPlayer: MediaPlayer

    init {
        injectSelf()
        mPlayer = MediaPlayer.create(mContext, R.raw.alarm)
    }

    // init内はコンパイルされないようなので、injectは外側で関数化
    private fun injectSelf() {
        PresentationTimerApp.appComponent.inject(this)
    }

    override fun onTick(millisUntilFinished: Long) {
        mUseCase.setRemainingMilliSec(millisUntilFinished)
        mPresenter.update()
    }

    override fun onFinish() {
        Log.d(this.javaClass.name, "時間終了です！！！")
        mPlayer.seekTo(0)
        mPlayer.start()
        mUseCase.setTimerStatus(TimerStatus.FINISH)
    }
}
