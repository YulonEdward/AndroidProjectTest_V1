package com.example.yulon.androidsimplegame;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity_gridView extends AppCompatActivity implements ViewSwitcher.ViewFactory{

    private GridView mGridView;
    private ImageSwitcher mImgSwitcher;

    private Integer[] miImgArr = {
        R.drawable.red_eyes, R.drawable.blue_eyes
    };

    private List<Map<String, Object>> gridItemList = null;

    private String GRID_ITEM_MAP_KEY_NAME = "image";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gridview);

        initGridViewItemData();

        mImgSwitcher = (ImageSwitcher)findViewById(R.id.imgSwitcher);
        mImgSwitcher.setFactory(this);
//        mImgSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
//        mImgSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
        mImgSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.trans_in));
        mImgSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.trans_out));

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, this.gridItemList, R.layout.activity_grid_view_cell,
                new String[]{this.GRID_ITEM_MAP_KEY_NAME}, new int[]{R.id.gridCellImageView});

        mGridView = (GridView)findViewById(R.id.gridView);
        mGridView.setAdapter(simpleAdapter);
        mGridView.setOnItemClickListener(gridViewOnItemClick);
       // mGridView.setOnItemSelectedListener(gridViewOnItemSelectedClick);

    }

    @Override
    public View makeView() {
        ImageView v = new ImageView(this);
        v.setScaleType(ImageView.ScaleType.FIT_CENTER);
        v.setBackgroundColor(Color.GREEN);
        ImageSwitcher.LayoutParams imgLayoutParams = new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);
        v.setLayoutParams(imgLayoutParams);
        return v;
    }

    private AdapterView.OnItemClickListener gridViewOnItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int selectImageDrawableId = miImgArr[position];
            mImgSwitcher.setImageResource(selectImageDrawableId);
        }
    };

    private AdapterView.OnItemSelectedListener gridViewOnItemSelectedClick = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            int selectImageDrawableId = miImgArr[position];
            mImgSwitcher.setImageResource(selectImageDrawableId);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private void initGridViewItemData(){
        if(this.gridItemList==null)
        {
            this.gridItemList = new ArrayList<Map<String, Object>>();
        }

        int imageCount = this.miImgArr.length;
        for(int i = 0; i< imageCount ; i++)
        {
            int imageDrawableId = this.miImgArr[i];
            Map<String, Object> gridItemMap = new HashMap<String, Object>();
            gridItemMap.put(this.GRID_ITEM_MAP_KEY_NAME, imageDrawableId);

            this.gridItemList.add(gridItemMap);
        }
    }
}
