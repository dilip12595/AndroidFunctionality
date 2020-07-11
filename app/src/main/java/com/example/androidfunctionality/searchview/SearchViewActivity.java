package com.example.androidfunctionality.searchview;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidfunctionality.R;

import java.util.ArrayList;
import java.util.List;

public class SearchViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private SearchAdapter adapter;
    private List<SearchItem> items;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        fillExampleList();
        setUpRecyclerView();

    }

    private void fillExampleList() {
        items = new ArrayList<>();
        items.add(new SearchItem("Title One", "Potato"));
        items.add(new SearchItem("Title Two", "Onion"));
        items.add(new SearchItem("Title Three", "Cabbage"));
        items.add(new SearchItem("Title Four", "Lady finger"));
        items.add(new SearchItem("Title Five", "Capsicum"));
        items.add(new SearchItem("Title Six", "Tomato"));
        items.add(new SearchItem("Title Seven", "Chili"));
        items.add(new SearchItem("Title Eight", "Garlic"));
        items.add(new SearchItem("Title Nine", "Ginger"));
        items.add(new SearchItem("Title Ten", "Red chili"));
    }

    private void setUpRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new SearchAdapter(items);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setQueryHint("Search veg...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}
