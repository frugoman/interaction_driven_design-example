package com.frusoft.interactiondrivendesignexample.core.domain.country;

import java.util.List;
import java.util.Optional;

public interface Countries {

    List<Country> findAll();

    Optional<Country> findBy(final String name);
}
