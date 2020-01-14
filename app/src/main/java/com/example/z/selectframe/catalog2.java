package com.example.z.selectframe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class catalog2 extends AppCompatActivity {

    private Button next1;
    private Button back1;
    private Button camera1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog2);

        next1 = (Button) findViewById(R.id.next);
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iii = new Intent(catalog2.this, catalog2.class);
                startActivity(iii);
            }
        });
        back1 = (Button) findViewById(R.id.back);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(catalog2.this, catalog.class);
                startActivity(ii);
            }
        });
        camera1 = (Button) findViewById(R.id.camera);
        camera1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(catalog2.this, camera.class);
                startActivity(i);
            }
        });
    }
}
