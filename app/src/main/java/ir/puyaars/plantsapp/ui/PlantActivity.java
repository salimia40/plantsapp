package ir.puyaars.plantsapp.ui;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

import androidx.lifecycle.ViewModelProviders;
import ir.puyaars.plantsapp.R;
import ir.puyaars.plantsapp.repository.entities.PlantEntity;

import static ir.puyaars.plantsapp.repository.utils.Const.PLANT_ID_KEY;

public class PlantActivity extends AppCompatActivity {

    private PlantViewModel presenter;
    private PlantEntity mPlant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initPresenter();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            // TODO favorite the plant
            if (mPlant != null) {
                mPlant.setFavourite(!mPlant.isFavourite());
                presenter.savePlant(mPlant);
            }
        });
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    private void initPresenter() {
        presenter = ViewModelProviders.of(this).get(PlantViewModel.class);
        presenter.mPlant.observe(this,plantEntity -> {
            // TODO update UI
            mPlant = plantEntity;
        });

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            // no Id so get out soon
            finish();
        } else {
            int plantId = extras.getInt(PLANT_ID_KEY);
            presenter.loadData(plantId);
        }
    }
}
