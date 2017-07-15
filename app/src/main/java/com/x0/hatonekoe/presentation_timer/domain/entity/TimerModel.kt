package com.x0.hatonekoe.presentation_timer.domain.entity

class TimerModel(initialMillSec: Long = 10000) {
    var mInitialMillSec: Long = initialMillSec
    var mMilliSecUntilFinished: Long = initialMillSec
    var mTimerStatus: TimerStatus = TimerStatus.WAIT
}

enum class TimerStatus {
    WAIT,
    RUN,
    FINISH,
}
