package com.x0.hatonekoe.presentation_timer.domain

import com.x0.hatonekoe.presentation_timer.domain.repository.TimerRepository
import com.x0.hatonekoe.presentation_timer.domain.repository.TimerRepositoryIF
import com.x0.hatonekoe.presentation_timer.domain.usecase.CurrentTimeUseCase
import com.x0.hatonekoe.presentation_timer.domain.usecase.CurrentTimeUseCaseIF
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Provides
    @Singleton
    fun provideTimeService(timerRepositoryIF: TimerRepositoryIF): CurrentTimeUseCaseIF {
        return CurrentTimeUseCase(timerRepositoryIF)
    }

    @Provides
    @Singleton
    fun provideTimerRepository(): TimerRepositoryIF {
        return TimerRepository()
    }
}
