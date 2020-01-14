package com.example.z.selectframe;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Color.*;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.widget.ImageView;
import android.media.FaceDetector;
public class Globals extends Application {


    private Bitmap bitImageFace;
    private static Integer chosenImage;
    private static Integer rayBanFrames [] = {R.drawable.frame};
    protected Bitmap getBitImageFace() {
        return bitImageFace;
    }

    protected void setBitImageFace(Bitmap image) {
        bitImageFace = image;
    }

    protected static void setChosenImage(int index){
        chosenImage = rayBanFrames[index];
    }

    protected static Integer  getChosenImage(){
        return chosenImage;
    }
}




