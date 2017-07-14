package com.x0.hatonekoe.presentation_timer

import com.x0.hatonekoe.presentation_timer.domain.DomainModule
import com.x0.hatonekoe.presentation_timer.presentation.PresentationModule
import com.x0.hatonekoe.presentation_timer.presentation.activity.MainFragment
import dagger.Component
import javax.inject.Singleton

/**
 * ModuleとInject対象となるクラスの関係を定義
 */
@Singleton
@Component(
        modules = arrayOf(
            ApplicationModule::class,
            DomainModule::class,
            PresentationModule::class
        )
)
interface ApplicationComponent {
    fun inject(application: PresentationTimerApp)
    fun inject(fragment: MainFragment)
}
