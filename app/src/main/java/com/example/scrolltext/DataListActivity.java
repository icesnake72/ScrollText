package com.example.scrolltext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class DataListActivity extends AppCompatActivity {

    private Button btnBack;
    private RecyclerView rcDataView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Product> liProds = new ArrayList<>();

    private String[] products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);

        initProducts();

        rcDataView = findViewById(R.id.rcviewDataList);
        rcDataView.setHasFixedSize(true);   // contents의 크기가 물리적으로 변해도 RecyclerView의 크기를 고정시킴
        layoutManager = new LinearLayoutManager(this);
        rcDataView.setLayoutManager(layoutManager);

        adapter = new DataAdaptor(liProds);
        rcDataView.setAdapter(adapter);

        btnBack = findViewById(R.id.back_button);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DataListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initProducts() {

        Product android = new Product(R.drawable.android_gif_icon,
                                      getString(R.string.android_app),
                                      getString(R.string.android_desc),
                                      getString(R.string.android_price));

        Product apple = new Product(R.drawable.apple_logo_black,
                getString(R.string.apple_app),
                getString(R.string.apple_desc),
                getString(R.string.apple_price));

        Product micro = new Product(R.drawable.microsoft_logo,
                getString(R.string.microsoft_app),
                getString(R.string.microsoft_desc),
                getString(R.string.microsoft_price));

        Product google = new Product(R.drawable.google_logo,
                getString(R.string.google_app),
                getString(R.string.google_desc),
                getString(R.string.google_price));

        Product insta = new Product(R.drawable.instagram_icon,
                getString(R.string.insta_app),
                getString(R.string.insta_desc),
                getString(R.string.insta_price));

        liProds.add(android);
        liProds.add(apple);
        liProds.add(micro);
        liProds.add(google);
        liProds.add(insta);
    }
}