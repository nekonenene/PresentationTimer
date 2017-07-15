package com.x0.hatonekoe.presentation_timer.domain.repository

import com.x0.hatonekoe.presentation_timer.domain.entity.TimerModel

interface TimerRepositoryIF {
    fun timer1(): TimerModel
    fun timer2(): TimerModel
}
