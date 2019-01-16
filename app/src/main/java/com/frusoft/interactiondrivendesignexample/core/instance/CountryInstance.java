package com.frusoft.interactiondrivendesignexample.core.instance;

import com.frusoft.interactiondrivendesignexample.core.action.GetAllCountries;
import com.frusoft.interactiondrivendesignexample.core.action.GetCountry;
import com.frusoft.interactiondrivendesignexample.core.infrastructure.api.ApiCountries;
import com.frusoft.interactiondrivendesignexample.core.infrastructure.api.CountriesService;
import com.frusoft.interactiondrivendesignexample.core.infrastructure.cache.InMemoryCountries;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class CountryInstance {

    private static final InMemoryCountries inMemoryCountries = countries();

    public static GetAllCountries getAllCountries(){
        return new GetAllCountries(inMemoryCountries);
    }

    public static GetCountry getCountry(){
        return new GetCountry(inMemoryCountries);
    }

    private static InMemoryCountries countries() {
        return new InMemoryCountries(new ApiCountries(countriesService()));
    }

    private static CountriesService countriesService() {
        return new Retrofit.Builder().baseUrl("https://restcountries.eu/rest/v2/").addConverterFactory(
            GsonConverterFactory.create()).build().create(CountriesService.class);
    }
}
