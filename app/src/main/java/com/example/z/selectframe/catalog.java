package com.example.z.selectframe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class catalog extends AppCompatActivity {
    private Button next1;
    private Button camera1;
    private ImageView frame1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        frame1 = (ImageView) findViewById(R.id.frames);
        frame1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent frame1 = new Intent(catalog.this, rayban1.class);
                Globals.setChosenImage(0);
                startActivity(frame1);
            }
        });
    }
}
