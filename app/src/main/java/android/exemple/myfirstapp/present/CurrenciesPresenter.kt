package android.exemple.myfirstapp.present

import android.exemple.myfirstapp.rest.CoinGeckoApi
import android.exemple.myfirstapp.adapter.CurrenciesAdapter
import android.exemple.myfirstapp.contract.CurrenciesContract
import android.exemple.myfirstapp.App
import android.exemple.myfirstapp.extensions.formatThousands
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class CurrenciesPresenter: CurrenciesContract.Presenter() {
    @Inject
    lateinit var geckoApi: CoinGeckoApi

    init {
        App.appComponent.inject(this)

    }
    override fun makeList() {
        view.showProgress()

        subscribe(geckoApi.getCoinMarket()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnComplete {
                view.hideProgress()
            }
            .subscribe({ coins ->
                val geckoCoins = coins.map { coin ->
                    CurrenciesAdapter.Currency(
                        coin.id,
                        coin.symbol,
                        coin.name,
                        coin.image,
                        coin.current_price,
                        coin.market_cap.formatThousands(),
                        coin.market_cap_rank,
                        coin.total_volume,
                        coin.price_change_percentage_24h,
                        coin.market_cap_change_percentage_24h,
                        coin.circulating_supply,
                        coin.total_supply,
                        coin.ath,
                        coin.ath_change_percentage)
                }
                view.addAllCurrency(geckoCoins)
                view.hideProgress()
                view.notifyAdapter()
            }, {
                view.showErrorMessage(it.message)
                view.hideProgress()
                it.printStackTrace()
            })
        )
    }
    override fun refreshList() {
        view.refresh()
        makeList()
    }

}
