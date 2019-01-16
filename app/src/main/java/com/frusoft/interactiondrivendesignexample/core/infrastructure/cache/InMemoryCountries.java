package com.frusoft.interactiondrivendesignexample.core.infrastructure.cache;

import com.frusoft.interactiondrivendesignexample.core.domain.country.Countries;
import com.frusoft.interactiondrivendesignexample.core.domain.country.Country;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryCountries implements Countries {

    static Map<String, Country> countries = new HashMap<>();
    private final Countries source;

    public InMemoryCountries(final Countries source) {
        this.source = source;
    }

    @Override
    public List<Country> findAll() {
        if (!countries.isEmpty()) {
            return new ArrayList<>(countries.values());
        }
        final List<Country> countries = source.findAll();
        countries.forEach(this::saveInMemory);
        return countries;
    }

    @Override
    public Optional<Country> findBy(final String name) {
        return findAll().stream().findFirst();
    }

    private Country saveInMemory(final Country country) {
        return countries.put(country.value,country);
    }
}
