package com.android.filemanager2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProductTourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_tour);

        skip = Button.class.cast(findViewById(R.id.skip));
        skip.setOnClickListener(new View.OnClickListener(){

        });
    }
}
