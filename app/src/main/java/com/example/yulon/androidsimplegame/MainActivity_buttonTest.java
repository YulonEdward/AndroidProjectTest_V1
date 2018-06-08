package com.example.yulon.androidsimplegame;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity_buttonTest extends AppCompatActivity{

    private Button mBtn1, mBtn2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_buttontest);

        mBtn1 = (Button)findViewById(R.id.btn1);
        mBtn2 = (Button)findViewById(R.id.btn2);

        if(Build.VERSION.SDK_INT >= 21){
            mBtn1.setBackgroundResource(R.drawable.btn_bg_ripple);
        }else{
            mBtn1.setBackgroundResource(R.drawable.btn_bg_selector);
        }
    }
}
