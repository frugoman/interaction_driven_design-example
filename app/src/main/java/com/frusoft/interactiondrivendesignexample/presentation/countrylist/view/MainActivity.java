package com.frusoft.interactiondrivendesignexample.presentation.countrylist.view;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.frusoft.interactiondrivendesignexample.R;
import com.frusoft.interactiondrivendesignexample.core.action.GetAllCountries;
import com.frusoft.interactiondrivendesignexample.core.action.GetCountry;
import com.frusoft.interactiondrivendesignexample.core.domain.country.Country;
import com.frusoft.interactiondrivendesignexample.core.instance.CountryInstance;
import com.frusoft.interactiondrivendesignexample.presentation.countrylist.instance.CountryListInstance;
import com.frusoft.interactiondrivendesignexample.presentation.countrylist.presenter.CountryListPresenter;
import com.frusoft.interactiondrivendesignexample.presentation.countrylist.presenter.CountryListView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CountryListView {

    private CountryListPresenter presenter = CountryListInstance.presenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter.notifyViewCreated();
    }

    @Override
    public void showCountryList(@NonNull final List<Country> countries) {
        final LinearLayout listView = findViewById(R.id.countriesListContainer);
        countries.forEach(country -> {
            final TextView countryTitle = new TextView(this);

            countryTitle.setText(country.value);
            listView.addView(countryTitle);
        });
    }

    @Override
    public void showErrorView() {
        //Do something
    }
}
