package com.x0.hatonekoe.presentation_timer.model.repository

import com.x0.hatonekoe.presentation_timer.model.entity.TimerModel

interface TimerRepositoryIF {
    fun timer1(): TimerModel
    fun timer2(): TimerModel
}
