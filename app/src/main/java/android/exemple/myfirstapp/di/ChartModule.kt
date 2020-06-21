package android.exemple.myfirstapp.di

import android.exemple.myfirstapp.YearValueFormatter
import android.exemple.myfirstapp.chart.LatestChart
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ChartModule {
    @Provides
    @Singleton
    fun provideLatestChart() = LatestChart()

    @Provides
    @Singleton
    fun provideYearFormatter() = YearValueFormatter()
}


