package com.example.internshipbatchssp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class CategoryActivity extends AppCompatActivity {

    RecyclerView category_recycler;


    int[] idArray = {1,2,3};
    String[] nameArray = {"Electronics", "Clothes", "Books"};
    int[] imageArray = {R.drawable.electronics, R.drawable.clothes, R.drawable.books};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        category_recycler = findViewById(R.id.category_recycler);

//        category_recycler.setLayoutManager(new LinearLayoutManager(CategoryActivity.this));
        category_recycler.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));

        CategoryAdapter adapter = new CategoryAdapter(CategoryActivity.this, idArray, nameArray, imageArray);
        category_recycler.setAdapter(adapter);



    }
}