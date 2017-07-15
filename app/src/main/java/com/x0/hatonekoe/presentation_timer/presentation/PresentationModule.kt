package com.x0.hatonekoe.presentation_timer.presentation

import com.x0.hatonekoe.presentation_timer.service.usecase.CurrentTimeUseCaseIF
import com.x0.hatonekoe.presentation_timer.presentation.presenter.MainFragmentPresenter
import com.x0.hatonekoe.presentation_timer.presentation.presenter.MainFragmentPresenterIF
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresentationModule {
    @Provides
    @Singleton
    fun provideMainFragmentPresenter(useCase: CurrentTimeUseCaseIF): MainFragmentPresenterIF {
        return MainFragmentPresenter(useCase)
    }
}
