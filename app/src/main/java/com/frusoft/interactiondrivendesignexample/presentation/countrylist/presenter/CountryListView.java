package com.frusoft.interactiondrivendesignexample.presentation.countrylist.presenter;

import com.frusoft.interactiondrivendesignexample.core.domain.country.Country;
import java.util.List;

public interface CountryListView {

    void showCountryList(final List<Country> countries);

    void showErrorView();
}
