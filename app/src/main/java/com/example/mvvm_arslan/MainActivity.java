package com.example.mvvm_arslan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.TextView;

import com.example.mvvm_arslan.db.CartViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recview;
    List<ModelEmployees> movielist;
    MovieListViewModel listViewModel;
    CartViewModel roomVM;
    MovieListAdapter adapter;
    TextView noresfound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recview = findViewById(R.id.rec_view);
        noresfound = findViewById(R.id.noresult);

        recview.setLayoutManager(new LinearLayoutManager(this));
        recview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        adapter = new MovieListAdapter(movielist);
        recview.setAdapter(adapter);


        listViewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);
        roomVM = new ViewModelProvider(this).get(CartViewModel.class);

        listViewModel.getMovielistObserver().observe(this, movieModels -> {
            if (movieModels != null) {
                movielist = movieModels;
                roomVM.insertCartList(movielist);
            }
            if (movieModels == null) {
                recview.setVisibility(View.GONE);
                noresfound.setVisibility(View.VISIBLE);
            }
        });

        roomVM.getAllCartItems().observe(this, modelEmployees -> adapter.updatemovielist(modelEmployees));
        listViewModel.makeApiCall();


    }


}