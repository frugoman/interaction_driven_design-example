package com.frusoft.interactiondrivendesignexample.core.infrastructure.api;

import com.frusoft.interactiondrivendesignexample.core.infrastructure.api.representation.CountryRepresentation;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CountriesService {
    @GET("all") Call<List<CountryRepresentation>> getAllCountries();
}