package com.frusoft.interactiondrivendesignexample.core.action;

import com.frusoft.interactiondrivendesignexample.core.domain.country.Countries;
import com.frusoft.interactiondrivendesignexample.core.domain.country.Country;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StubCountries implements Countries {
    private final List<Country> countries;

    StubCountries(final String... countriesList) {
        countries = new ArrayList<>();
        for (String country : countriesList) {
            countries.add(new Country(country));
        }
    }

    @Override
    public List<Country> findAll() {
        return countries;
    }

    @Override
    public Optional<Country> findBy(final String name) {
        return countries.stream().filter(country -> country.value.equals(name)).findFirst();
    }
}
