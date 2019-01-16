package com.frusoft.interactiondrivendesignexample.presentation.countrylist.presenter;

import com.frusoft.interactiondrivendesignexample.core.action.GetAllCountries;
import com.frusoft.interactiondrivendesignexample.core.domain.country.Country;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class CountryListPresenter {

    private final GetAllCountries getAllCountries;
    private CountryListView view;

    public CountryListPresenter(final GetAllCountries getAllCountries, final CountryListView view) {
        this.getAllCountries = getAllCountries;
        this.view = view;
    }

    public void notifyViewCreated() {
        getAllCountries.build()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(countries -> view.showCountryList(countries), throwable -> view.showErrorView());
    }
}
