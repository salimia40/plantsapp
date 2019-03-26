package ir.puyaars.plantsapp.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ir.puyaars.plantsapp.R;

public class MainActivity extends AppCompatActivity {


    private PlantAdapter adapter;
    private MainViewModel presenter;

    // filter the plants by favourite
    private Boolean favFilter = false;

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
        RecyclerView recyclerView = findViewById(R.id.recycler);
        adapter = new PlantAdapter(this);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        DividerItemDecoration decoration = new DividerItemDecoration(
                recyclerView.getContext(), manager.getOrientation()
        );

        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(adapter);


    }

    private void initPresenter() {

        presenter = ViewModelProviders.of(this).get(MainViewModel.class);

        presenter.mPlants.observe(this, plantEntities -> {
            if (!favFilter) {
                adapter.setPlants(plantEntities);
            }
        });

        presenter.fPlants.observe(this, plantEntities -> {
            if (favFilter) {
                adapter.setPlants(plantEntities);
            }
        });

    }


    // TODO call this so adapter will update
    private void onFilterChanged(boolean favFilter) {
        if (favFilter) adapter.setPlants(presenter.fPlants.getValue());
        else adapter.setPlants(presenter.mPlants.getValue());
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

        // TODO favourite filter changer item

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
