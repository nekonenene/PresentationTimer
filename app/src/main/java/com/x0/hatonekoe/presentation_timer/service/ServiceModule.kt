package com.x0.hatonekoe.presentation_timer.model

import com.x0.hatonekoe.presentation_timer.model.repository.TimerRepositoryIF
import com.x0.hatonekoe.presentation_timer.service.usecase.CurrentTimeUseCase
import com.x0.hatonekoe.presentation_timer.service.usecase.CurrentTimeUseCaseIF
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ServiceModule {
    @Provides
    @Singleton
    fun provideTimeUseCase(timerRepositoryIF: TimerRepositoryIF): CurrentTimeUseCaseIF {
        return CurrentTimeUseCase(timerRepositoryIF)
    }
}
