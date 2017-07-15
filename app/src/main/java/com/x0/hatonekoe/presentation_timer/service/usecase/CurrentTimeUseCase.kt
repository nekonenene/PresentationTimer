package com.x0.hatonekoe.presentation_timer.service.usecase

import com.x0.hatonekoe.presentation_timer.model.entity.TimerStatus
import com.x0.hatonekoe.presentation_timer.model.repository.TimerRepositoryIF

class CurrentTimeUseCase(timerRepository: TimerRepositoryIF): CurrentTimeUseCaseIF {
    val mTimerRepository: TimerRepositoryIF = timerRepository
    val mTimer1 = mTimerRepository.timer1()

    /**
     * 残り時間を、画面に表示する「3:39」のような形式で渡す
     *
     * @return String
     */
    override fun getRemainingTimeString(): String {
        val remainingMilliSec = mTimer1.mMilliSecUntilFinished

        return toMinutesSecondsString(remainingMilliSec)
    }

    /**
     * 「3:39」のような分と秒の形式に、ミリ秒を変換
     *
     * @param milliSec ミリ秒
     * @return String
     */
    fun toMinutesSecondsString(milliSec: Long): String {
        val minutes: Int = (milliSec / 1000 / 60).toInt()
        val seconds: Int = (milliSec / 1000 % 60).toInt()

        return String.format("%1d:%2$02d", minutes, seconds)
    }

    override fun getInitialTime(): Long {
        return mTimer1.mInitialMillSec
    }

    override fun getRemainingMilliSec(): Long {
        return mTimer1.mMilliSecUntilFinished
    }

    override fun setRemainingMilliSec(milliSec: Long) {
        mTimer1.mMilliSecUntilFinished = milliSec
    }

    override fun getTimerStatus(): TimerStatus {
        return mTimer1.mTimerStatus
    }

    override fun setTimerStatus(timerStatus: TimerStatus) {
        mTimer1.mTimerStatus = timerStatus
    }

    override fun resetRemainingTime() {
        mTimer1.mMilliSecUntilFinished = mTimer1.mInitialMillSec
    }
}
