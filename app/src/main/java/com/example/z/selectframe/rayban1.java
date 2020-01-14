package com.example.z.selectframe;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class rayban1 extends AppCompatActivity {
    public ImageView imageFace;
    private ViewGroup mainLayout;

    private int xDelta;
    private int yDelta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rayban1);
        mainLayout = (RelativeLayout) findViewById(R.id.rayban1);
        Globals b = (Globals)getApplication();
        final ImageView imageView = (ImageView) findViewById(R.id.frame);
        final ImageView imageView2 = (ImageView) findViewById(R.id.mobileFrame);
        imageView.setImageResource(b.getChosenImage());
        imageView2.setImageResource(b.getChosenImage());
        imageView2.setOnTouchListener(onTouchListener());
        imageView2.bringToFront();
        final int ratio = imageView2.getLayoutParams().height/imageView2.getLayoutParams().width;
        Bitmap previous = b.getBitImageFace();
        imageFace = (ImageView)findViewById(R.id.face);
        imageFace.setImageBitmap(previous);
        Button btnCamera = (Button)findViewById(R.id.btnCamera);
        Button scaleUp = (Button)findViewById(R.id.scaleUp);
        Button scaleDown = (Button)findViewById(R.id.scaleDown);
        Button mscaleUp = (Button)findViewById(R.id.MscaleUp);
        Button mscaleDown = (Button)findViewById(R.id.MscaleDown);
        Button rotateC = (Button)findViewById(R.id.rotateC);
        Button rotateCC = (Button)findViewById(R.id.rotateCC);
        Button rotateMC = (Button)findViewById(R.id.rotateMC);
        Button rotateMCC = (Button)findViewById(R.id.rotateMCC);
        scaleUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView2.getLayoutParams().width+=5;
                imageView2.getLayoutParams().height+=5*ratio;
                onTouchListener();
            }
        });
        scaleDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ratio =  imageView2.getLayoutParams().height/imageView2.getLayoutParams().width;
                imageView2.getLayoutParams().width-=5;
                imageView2.getLayoutParams().height-=5*ratio;
                onTouchListener();
            }
        });
        mscaleUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView2.getLayoutParams().width+=2;
                imageView2.getLayoutParams().height+=2*ratio;
                onTouchListener();
            }
        });
        mscaleDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ratio =  imageView2.getLayoutParams().height/imageView2.getLayoutParams().width;
                imageView2.getLayoutParams().width-=2;
                imageView2.getLayoutParams().height-=2*ratio;
                onTouchListener();
            }
        });
        rotateC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView2.setRotation(imageView2.getRotation()+9);
            }
        });
        rotateCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView2.setRotation(imageView2.getRotation()-9);
            }
        });
        rotateMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView2.setRotation(imageView2.getRotation()-2);
            }
        });
        rotateMCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView2.setRotation(imageView2.getRotation()+2);
            }
        });
        Button change = (Button)findViewById(R.id.reset);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
        Button reset = (Button)findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recreate();
            }
        });

    }

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

    private OnTouchListener onTouchListener() {
        return new OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();
                if(x == 0){

                }
                else if (y == 0){

                }
                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams)
                                view.getLayoutParams();

                        xDelta = x - lParams.leftMargin;
                        yDelta = y - lParams.topMargin;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                                .getLayoutParams();
                        layoutParams.leftMargin = x - xDelta;
                        layoutParams.topMargin = y - yDelta;

                        layoutParams.rightMargin = 300 - (x-98);
                        layoutParams.bottomMargin = 900 - (y - 204);
                        view.setLayoutParams(layoutParams);
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                    case MotionEvent.ACTION_POINTER_DOWN:
                        break;
                    case MotionEvent.ACTION_POINTER_UP:
                        break;
                }
                mainLayout.invalidate();
                return true;
            }
        };
    }

}
