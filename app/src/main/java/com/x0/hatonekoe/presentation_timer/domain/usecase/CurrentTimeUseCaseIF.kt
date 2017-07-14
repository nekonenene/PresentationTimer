package com.x0.hatonekoe.presentation_timer.domain.usecase

interface CurrentTimeUseCaseIF {
    fun getRemainingTimeString(): String
    fun getInitialTime(): Long
    fun setRemainingMilliSec(milliSec: Long)
}
