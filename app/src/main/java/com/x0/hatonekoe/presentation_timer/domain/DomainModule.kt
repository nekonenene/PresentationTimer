package com.x0.hatonekoe.presentation_timer.domain

import com.x0.hatonekoe.presentation_timer.domain.repository.TimerRepository
import com.x0.hatonekoe.presentation_timer.domain.usecase.CurrentTimeUseCase
import com.x0.hatonekoe.presentation_timer.domain.usecase.CurrentTimeUseCaseIF
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideTimeService(timerRepository: TimerRepository): CurrentTimeUseCaseIF {
        return CurrentTimeUseCase(timerRepository)
    }
}
