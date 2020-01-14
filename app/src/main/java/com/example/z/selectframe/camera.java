package com.example.z.selectframe;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import java.io.File;

import static android.util.Log.e;

public class camera extends AppCompatActivity {


    private ImageView imageFace;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        Globals b = (Globals)getApplication();
        Bitmap previous = b.getBitImageFace();
        Button btnCamera = (Button)findViewById(R.id.btnCamera);
        imageFace = (ImageView)findViewById(R.id.imageView);
        imageFace.setImageBitmap(previous);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        try {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageFace.setImageBitmap(bitmap);

            Globals b = (Globals) getApplication();
            b.setBitImageFace(bitmap);
        } catch (Exception e){
            System.out.println("something went wrong");
        }
    }


}

