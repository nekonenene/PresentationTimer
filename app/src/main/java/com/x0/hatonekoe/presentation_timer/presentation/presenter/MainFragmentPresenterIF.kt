package com.x0.hatonekoe.presentation_timer.presentation.presenter

import com.x0.hatonekoe.presentation_timer.presentation.activity.MainFragment

interface MainFragmentPresenterIF {
    fun setFragment(fragment: MainFragment)
    fun onStart()
    fun onClickTimerTextView()
    fun update()
    fun onTimerFinish()
}
