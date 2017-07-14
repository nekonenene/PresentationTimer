package com.x0.hatonekoe.presentation_timer.service

object TimeService {
    fun toMinutesSecondsString(milliSecond: Long): String {
        val minutes: Int = (milliSecond / 1000 / 60).toInt()
        val seconds: Int = (milliSecond / 1000 % 60).toInt()
        return String.format("%1d:%2$02d", minutes, seconds)
    }
}
