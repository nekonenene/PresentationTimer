package com.x0.hatonekoe.presentation_timer.model

import com.x0.hatonekoe.presentation_timer.model.repository.TimerRepository
import com.x0.hatonekoe.presentation_timer.model.repository.TimerRepositoryIF
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModelModule {
    @Provides
    @Singleton
    fun provideTimerRepository(): TimerRepositoryIF {
        return TimerRepository()
    }
}
