package ir.puyaars.plantsapp.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.puyaars.plantsapp.R;
import ir.puyaars.plantsapp.repository.entities.PlantEntity;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private MainViewModel presenter;
//    private List<PlantEntity> plantsList = new ArrayList<>();
    private PlantAdapter adapter;

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initRecycler();
        initPresenter();
    }

    private void initRecycler() {
        adapter = new PlantAdapter(this);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

    }

    private void initPresenter() {

        final Observer<List<PlantEntity>> observer = plantEntities -> {
//            plantsList.clear();
//            plantsList.addAll(plantEntities);
            // TODO UI CHANGE
            adapter.setPlants(plantEntities);
        };

        presenter = ViewModelProviders.of(this).get(MainViewModel.class);
        presenter.mPlants.observe(this,observer);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
