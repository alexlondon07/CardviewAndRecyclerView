package io.github.alexlondon07.cardviewandreciclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import io.github.alexlondon07.cardviewandreciclerview.models.Movie;

public class MainActivity extends AppCompatActivity {

    private List<Movie> movies;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private  RecyclerView.LayoutManager mLayoutManager;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movies = this.getAllMovies();

        recyclerView = findViewById(R.id.my_recycler_view);
        //mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager = new GridLayoutManager(this, 2);
        //mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        mAdapter = new MyAdapter(movies, R.layout.recycler_view_item, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Movie movie, int position) {
                //deleteName(position);
            }
        });

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.add_name:
                //this.addName(0);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /*private void addName(int position) {
        movies.add(position, "New movie "+(++counter));
        mAdapter.notifyItemInserted(position);
        mLayoutManager.scrollToPosition(position);
    }

    private void deleteName(int position){
        movies.remove(position);
        mAdapter.notifyItemRemoved(position);
    }*/

    private List<Movie> getAllMovies(){
        return new ArrayList<Movie>(){{
            add(new Movie("12 Strong", R.drawable.poster));
            add(new Movie("A Fantastic woman", R.drawable.poster1));
            add(new Movie("Winkle Time", R.drawable.poster2));
            add(new Movie("Act the violence ", R.drawable.poster3));
        }};
    }
}
