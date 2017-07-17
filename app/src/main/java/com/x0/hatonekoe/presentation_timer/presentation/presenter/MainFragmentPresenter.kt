package com.x0.hatonekoe.presentation_timer.presentation.presenter

import android.content.Context
import android.media.MediaPlayer
import com.x0.hatonekoe.presentation_timer.PresentationTimerApp
import com.x0.hatonekoe.presentation_timer.R
import com.x0.hatonekoe.presentation_timer.model.entity.TimerStatus
import com.x0.hatonekoe.presentation_timer.presentation.activity.MainFragment
import com.x0.hatonekoe.presentation_timer.service.usecase.CurrentTimeUseCaseIF
import com.x0.hatonekoe.presentation_timer.service.util.PresentationCountDownTimer
import javax.inject.Inject

class MainFragmentPresenter(useCase: CurrentTimeUseCaseIF): MainFragmentPresenterIF {
    val mUseCase: CurrentTimeUseCaseIF = useCase
    lateinit var mFragment: MainFragment
    lateinit var mCountDown: PresentationCountDownTimer
    @Inject
    lateinit var mContext: Context
    val mPlayer: MediaPlayer

    init {
        injectSelf()
        mPlayer = MediaPlayer.create(mContext, R.raw.alarm)
    }

    private fun injectSelf() {
        PresentationTimerApp.appComponent.inject(this)
    }

    companion object {
        const val INTERVAL_MILLI_SEC: Long = 100
    }

    override fun setFragment(fragment: MainFragment) {
        mFragment = fragment
    }

    override fun onStart() {
        mFragment.setTimerText(mUseCase.getRemainingTimeString())
    }

    override fun onClick() {
        if (mPlayer.isPlaying) {
            mPlayer.stop()
        }

        when (mUseCase.getTimerStatus()) {
            TimerStatus.WAIT -> {
                mCountDown = PresentationCountDownTimer(mUseCase.getRemainingMilliSec(), INTERVAL_MILLI_SEC)
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

    override fun onTimerFinish() {
        mUseCase.setTimerStatus(TimerStatus.FINISH)
        mPlayer.isLooping = true
        mPlayer.seekTo(0)
        mPlayer.start()
    }
}
