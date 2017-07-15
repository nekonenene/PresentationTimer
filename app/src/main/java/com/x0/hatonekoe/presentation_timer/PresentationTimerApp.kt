package com.x0.hatonekoe.presentation_timer

import android.app.Application

class PresentationTimerApp: Application() {
    companion object {
        @JvmStatic lateinit var appComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}
