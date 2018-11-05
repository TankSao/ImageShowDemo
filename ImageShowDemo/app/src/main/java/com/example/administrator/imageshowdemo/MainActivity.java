package com.example.administrator.imageshowdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    private TextView index;
    private LinearLayout linear;
    private RelativeLayout relative;
    private int[] images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linear = findViewById(R.id.linear);
        relative = findViewById(R.id.relative);
        img = findViewById(R.id.img);
        index = findViewById(R.id.index);
        initImages();
        initListener();
    }

    private void initListener() {
        relative.setOnTouchListener(new View.OnTouchListener() {
            float currentX = 0;
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        currentX = motionEvent.getX();
                        Log.e("eeeee",currentX+"");
                        break;
                    case  MotionEvent.ACTION_UP:
                        if(currentX<motionEvent.getX()){
                            Log.e("sssssss",currentX+"right"+motionEvent.getX());
                            finish();
                        }else {
                            Log.e("sssssss",currentX+"left"+motionEvent.getX());
                        }
                        break;
                }
                return true;
            }
        });
    }

    private void initImages() {
        images = new int[]{R.mipmap.kobe1,R.mipmap.kobe2,R.mipmap.kobe3,R.mipmap.kobe4,R.mipmap.kobe5,R.mipmap.kobe6,R.mipmap.kobe7,R.mipmap.kobe8,R.mipmap.kobe9,R.mipmap.kobe10,R.mipmap.kobe11,R.mipmap.kobe12};
        for(int i = 0;i<images.length;i++){
            final ImageView imageView = new ImageView(MainActivity.this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(180,180);
            params.setMargins(10,0,10,0);
            imageView.setLayoutParams(params);  //设置图片宽高
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(images[i]); //图片资源
            linear.addView(imageView);
            final int i1 = i;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    img.setImageResource(images[i1]);
                    index.setText((i1+1)+"/"+images.length);
                }
            });
        }
        img.setImageResource(images[0]);
        index.setText("1/"+images.length);
    }
}
