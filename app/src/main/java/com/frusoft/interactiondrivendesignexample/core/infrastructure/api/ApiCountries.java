package com.frusoft.interactiondrivendesignexample.core.infrastructure.api;

import com.frusoft.interactiondrivendesignexample.core.domain.country.Countries;
import com.frusoft.interactiondrivendesignexample.core.domain.country.Country;
import com.frusoft.interactiondrivendesignexample.core.infrastructure.api.representation.CountryRepresentation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ApiCountries implements Countries {

    private final CountriesService countriesService;

    public ApiCountries(final CountriesService countriesService) {
        this.countriesService = countriesService;
    }

    @Override
    public List<Country> findAll() {
        try {
            final List<CountryRepresentation> body = countriesService.getAllCountries().execute()
                .body();
                final List<Country> countries = new ArrayList<>();
            if (body != null) {
                body.forEach(countryRepresentation -> countries.add(countryRepresentation.toModel()));
            }
            return countries;

        } catch (IOException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Country> findBy(final String name) {
        throw new RuntimeException("find by not supported");
    }
}
