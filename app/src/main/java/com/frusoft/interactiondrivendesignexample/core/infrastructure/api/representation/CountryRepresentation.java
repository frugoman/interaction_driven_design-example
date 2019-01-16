package com.frusoft.interactiondrivendesignexample.core.infrastructure.api.representation;

import com.frusoft.interactiondrivendesignexample.core.domain.country.Country;

public class CountryRepresentation {

    private String name;

    public Country toModel() {
        return new Country(name);
    }
}
