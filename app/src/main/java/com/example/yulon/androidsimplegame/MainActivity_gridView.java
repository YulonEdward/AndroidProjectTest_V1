package com.example.yulon.androidsimplegame;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity_gridView extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gridview);

        Integer[] miThumbImgArr = {};

        //建立一個ImageAdapter型態的物件，this是主程式類別的物件
        ImageAdapter imgAdap = new ImageAdapter(this, miThumbImgArr);

        GridView gridView = (GridView)findViewById(R.id.gridView);
        gridView.setAdapter(imgAdap);

        //ridView 物件的 OnItemClickListener
        gridView.setOnItemClickListener(gridViewOnItemClick);
    }

    private AdapterView.OnItemClickListener gridViewOnItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        }
    };
}
