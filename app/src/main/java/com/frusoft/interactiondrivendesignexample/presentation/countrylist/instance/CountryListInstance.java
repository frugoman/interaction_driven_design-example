package com.frusoft.interactiondrivendesignexample.presentation.countrylist.instance;

import com.frusoft.interactiondrivendesignexample.core.instance.CountryInstance;
import com.frusoft.interactiondrivendesignexample.presentation.countrylist.presenter.CountryListPresenter;
import com.frusoft.interactiondrivendesignexample.presentation.countrylist.presenter.CountryListView;

public final class CountryListInstance {

    public static CountryListPresenter presenter(final CountryListView view) {
        return new CountryListPresenter(CountryInstance.getAllCountries(), view);
    }
}
