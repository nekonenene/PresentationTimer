package com.x0.hatonekoe.presentation_timer

import android.app.Application
import com.x0.hatonekoe.presentation_timer.domain.DomainModule
import com.x0.hatonekoe.presentation_timer.presentation.PresentationModule

class PresentationTimerApp: Application() {
    companion object {
        @JvmStatic lateinit var appComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .domainModule(DomainModule())
                .presentationModule(PresentationModule())
                .build()
        appComponent.inject(this)
    }
}
