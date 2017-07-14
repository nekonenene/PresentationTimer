package com.x0.hatonekoe.presentation_timer.domain.usecase

import com.x0.hatonekoe.presentation_timer.domain.repository.TimerRepositoryIF

class CurrentTimeUseCase(timerRepository: TimerRepositoryIF): CurrentTimeUseCaseIF {
    val mTimerRepository: TimerRepositoryIF = timerRepository

    override fun getRemainingTimeString(): String {
        val remainingMilliSec = mTimerRepository.timer1().mMilliSecUntilFinished
        val minutes: Int = (remainingMilliSec / 1000 / 60).toInt()
        val seconds: Int = (remainingMilliSec / 1000 % 60).toInt()

        return String.format("%1d:%2$02d", minutes, seconds)
    }

    override fun getInitialTime(): Long {
        return mTimerRepository.timer1().mInitialMillSec
    }

    override fun setRemainingMilliSec(milliSec: Long) {
        mTimerRepository.timer1().mMilliSecUntilFinished = milliSec
    }
}
