package com.x0.hatonekoe.presentation_timer.controller

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.x0.hatonekoe.presentation_timer.R
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A placeholder fragment containing a simple view.
 */
class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onStart() {
        super.onStart()
        MainFragmentPresenter.setFragment(this)
        MainFragmentPresenter.onStart()

        timer_text.setOnClickListener {
            MainFragmentPresenter.onClick()
        }
    }

    fun setTimerText(text: String) {
        timer_text.text = text
    }
}