package android.exemple.myfirstapp.di

import android.exemple.myfirstapp.MainActivity
import android.exemple.myfirstapp.activities.ChartActivity
import android.exemple.myfirstapp.chart.LatestChart
import android.exemple.myfirstapp.fragments.CurrenciesListFragment
import android.exemple.myfirstapp.present.CurrenciesPresenter
import android.exemple.myfirstapp.present.LatestChartPresenter
import dagger.Component
import javax.inject.Singleton

@Component(modules = arrayOf(AppModule::class, RestModule::class, MvpModule::class, ChartModule::class))
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(fragment: CurrenciesListFragment)

    fun inject(chart: LatestChart)

    fun inject(activity: ChartActivity)

    fun inject(presenter: CurrenciesPresenter)

    fun inject(presenter: LatestChartPresenter)
}
