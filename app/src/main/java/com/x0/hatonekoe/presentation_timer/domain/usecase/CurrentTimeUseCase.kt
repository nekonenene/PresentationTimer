package com.x0.hatonekoe.presentation_timer.domain.usecase

import com.x0.hatonekoe.presentation_timer.domain.entity.TimerStatus
import com.x0.hatonekoe.presentation_timer.domain.repository.TimerRepositoryIF

class CurrentTimeUseCase(timerRepository: TimerRepositoryIF): CurrentTimeUseCaseIF {
    val mTimerRepository: TimerRepositoryIF = timerRepository
    val mTimer1 = mTimerRepository.timer1()

    override fun getRemainingTimeString(): String {
        val remainingMilliSec = mTimer1.mMilliSecUntilFinished
        val minutes: Int = (remainingMilliSec / 1000 / 60).toInt()
        val seconds: Int = (remainingMilliSec / 1000 % 60).toInt()

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
