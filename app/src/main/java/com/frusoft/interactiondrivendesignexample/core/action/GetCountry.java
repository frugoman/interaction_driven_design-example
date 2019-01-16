package com.frusoft.interactiondrivendesignexample.core.action;

import com.frusoft.interactiondrivendesignexample.core.domain.country.Countries;
import com.frusoft.interactiondrivendesignexample.core.domain.country.Country;
import io.reactivex.Single;
import java.util.Optional;

public class GetCountry {

    private final Countries countries;

    public GetCountry(final Countries countries) {
        this.countries = countries;
    }

    public Optional<Country> doAction(final String name) {
        return countries.findBy(name);
    }

    public Single<Optional<Country>> build(final String name) {
        return Single.fromCallable(() -> doAction(name));
    }
}
