package com.frusoft.interactiondrivendesignexample.core.action;

import com.frusoft.interactiondrivendesignexample.core.domain.country.Country;
import java.util.Optional;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class GetCountryTest {
    private static final String ARGENTINA = "Argentina";
    private Optional<Country> result;
    private String countryToFind;

    @Test
    public void canGetCountry() throws Exception {
        givenSomeCountry(ARGENTINA);
        whenGetCountry();
        thenCountryIsFound();
    }

    private void givenSomeCountry(final String argentina) {
        countryToFind = argentina;
    }

    private void whenGetCountry() {
        result = new GetCountry(new StubCountries(ARGENTINA)).doAction(countryToFind);
    }

    private void thenCountryIsFound() {
        assertTrue(result.isPresent());
    }
}