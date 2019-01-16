package com.frusoft.interactiondrivendesignexample.core.action;

import com.frusoft.interactiondrivendesignexample.core.domain.country.Countries;
import com.frusoft.interactiondrivendesignexample.core.domain.country.Country;
import io.reactivex.Single;
import java.util.List;

public class GetAllCountries {

    private final Countries countries; //should always be final

    public GetAllCountries(final Countries countries) {
        this.countries = countries;
    }

    public List<Country> doAction() {
        return countries.findAll();
    }

    public Single<List<Country>> build() {
        return Single.fromCallable(this::doAction);
    }
}