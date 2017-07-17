package com.x0.hatonekoe.presentation_timer.presentation.activity

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.x0.hatonekoe.presentation_timer.PresentationTimerApp
import com.x0.hatonekoe.presentation_timer.R
import com.x0.hatonekoe.presentation_timer.presentation.presenter.MainFragmentPresenterIF
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject
    lateinit var mPresenter: MainFragmentPresenterIF

    override fun onAttach(context: Context?) {
        PresentationTimerApp.appComponent.inject(this) // Fragmentの場合はonAttachにてinjectする
        mPresenter.setFragment(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onStart() {
        super.onStart()
        mPresenter.onStart()

        timerTextView.setOnClickListener {
            mPresenter.onClickTimerTextView()
        }
    }

    fun setTimerText(text: String) {
        timerTextView.text = text
    }
}
