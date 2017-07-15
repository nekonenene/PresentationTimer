package com.x0.hatonekoe.presentation_timer.model.repository

import com.x0.hatonekoe.presentation_timer.model.entity.TimerModel

/**
 * TimerModel をデータベースから取り出したり保存したり
 */
class TimerRepository: TimerRepositoryIF {
    override fun timer1(): TimerModel {
        return TimerModel(10000)
    }

    override fun getTimerByName(name: String): TimerModel {
        // 保存領域から取り出す処理……

        return TimerModel(20000)
    }
}
