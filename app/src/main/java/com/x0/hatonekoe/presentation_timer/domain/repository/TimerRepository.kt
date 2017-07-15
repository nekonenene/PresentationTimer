package com.x0.hatonekoe.presentation_timer.domain.repository

import com.x0.hatonekoe.presentation_timer.domain.entity.TimerModel

/**
 * Created by radio7954 on 2017/07/15.
 */
class TimerRepository: TimerRepositoryIF {
    override fun timer1(): TimerModel {
        return TimerModel(10000)
    }

    override fun timer2(): TimerModel {
        return TimerModel(20000)
    }
}
