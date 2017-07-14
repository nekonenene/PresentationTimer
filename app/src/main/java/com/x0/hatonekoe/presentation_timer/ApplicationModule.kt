package com.x0.hatonekoe.presentation_timer

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Context をどこからでも拾えるようにする
 */
@Module
class ApplicationModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return context
    }
}
