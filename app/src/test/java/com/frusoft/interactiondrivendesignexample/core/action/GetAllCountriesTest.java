package com.frusoft.interactiondrivendesignexample.core.action;

import com.frusoft.interactiondrivendesignexample.core.domain.country.Countries;
import com.frusoft.interactiondrivendesignexample.core.domain.country.Country;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetAllCountriesTest {
    private List<Country> allCountries;
    private Countries countries;

    @Test
    public void canGetAllCountries() throws Exception {
        givenSomeCountries("Argentina", "Brazil");
        whenGetCountries();
        thenAreCountriesFound();
    }

    private void thenAreCountriesFound() {
        assertTrue(!allCountries.isEmpty());
    }

    private void whenGetCountries() {
        GetAllCountries getAllCountries = new GetAllCountries(countries);
        allCountries = getAllCountries.doAction();
    }

    private void givenSomeCountries(final String... countriesList) {
        countries = new StubCountries(countriesList);
    }
}