package com.x0.hatonekoe.presentation_timer

import com.x0.hatonekoe.presentation_timer.model.ModelModule
import com.x0.hatonekoe.presentation_timer.model.ServiceModule
import com.x0.hatonekoe.presentation_timer.presentation.PresentationModule
import com.x0.hatonekoe.presentation_timer.presentation.activity.MainFragment
import com.x0.hatonekoe.presentation_timer.presentation.presenter.MainFragmentPresenter
import com.x0.hatonekoe.presentation_timer.service.util.PresentationCountDownTimer
import dagger.Component
import javax.inject.Singleton

/**
 * ModuleとInject対象となるクラスの関係を定義
 */
@Component(
        modules = arrayOf(
                ApplicationModule::class,
                ModelModule::class,
                PresentationModule::class,
                ServiceModule::class
        )
)
@Singleton
interface ApplicationComponent {
    fun inject(fragment: MainFragment)
    fun inject(presenter: MainFragmentPresenter)
    fun inject(util: PresentationCountDownTimer)
}
