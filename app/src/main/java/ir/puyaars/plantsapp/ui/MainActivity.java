package ir.puyaars.plantsapp.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ir.puyaars.plantsapp.R;
import ir.puyaars.plantsapp.repository.entities.PlantEntity;
import ir.puyaars.plantsapp.repository.utils.Const;

public class MainActivity extends AppCompatActivity {


    private MainViewModel presenter;
    private List<PlantEntity> plantsList = new ArrayList<>();
    private PlantAdapter adapter;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initRecycler();
        initPresenter();
    }

    private void initRecycler() {
        recyclerView = findViewById(R.id.recycler);
        adapter = new PlantAdapter(this);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        DividerItemDecoration decoration = new DividerItemDecoration(
                recyclerView.getContext(),manager.getOrientation()
        );

        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(adapter);


    }

    private void initPresenter() {

        final Observer<List<PlantEntity>> observer = plantEntities -> {
            plantsList.clear();
            plantsList.addAll(plantEntities);
            // TODO UI CHANGE
            Log.i(Const.TAG, "initPresenter: " + plantEntities);
            adapter.setPlants(plantsList);
//            adapter.notifyDataSetChanged();
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
