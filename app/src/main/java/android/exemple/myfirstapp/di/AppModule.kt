package android.exemple.myfirstapp.di

import android.content.Context
import android.exemple.myfirstapp.App
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

    @Provides
    @Singleton
    fun provideContext(): Context = app
}