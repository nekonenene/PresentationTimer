package com.x0.hatonekoe.presentation_timer.domain.usecase

import com.x0.hatonekoe.presentation_timer.domain.entity.TimerStatus

interface CurrentTimeUseCaseIF {
    fun getRemainingTimeString(): String
    fun getInitialTime(): Long
    fun setRemainingMilliSec(milliSec: Long)
    fun getTimerStatus(): TimerStatus
    fun setTimerStatus(timerStatus: TimerStatus)
    fun getRemainingMilliSec(): Long
    fun resetRemainingTime()
}
