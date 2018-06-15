package com.example.yulon.androidsimplegame;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity_gridView_V2 extends AppCompatActivity implements ViewSwitcher.ViewFactory{

    private GridView mGridView;
    private ImageSwitcher mImgSwitcher;

    private Integer[] miImgArr = {
      R.drawable.blue_eyes, R.drawable.red_eyes
    };

    private Integer[] miThumbImgArr = {
      R.drawable.blue_eyes01th, R.drawable.red_eyes02th
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gridview);

        mImgSwitcher = (ImageSwitcher)findViewById(R.id.imgSwitcher);
        mImgSwitcher.setFactory(this); //主程式類別必須implement ViewSwitcher.ViewFactory

//        mImgSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));

        ScaleAnimation scaleAnimIn = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        scaleAnimIn.setInterpolator(new LinearInterpolator());
        scaleAnimIn.setStartOffset(10);
        scaleAnimIn.setDuration(3000);

        RotateAnimation rotateAnimIn = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimIn.setInterpolator(new LinearInterpolator());
        rotateAnimIn.setStartOffset(10);
        rotateAnimIn.setDuration(3000);

        AnimationSet animSet = new AnimationSet(false);
        animSet.addAnimation(scaleAnimIn);
        animSet.addAnimation(rotateAnimIn);
        mImgSwitcher.setInAnimation(animSet);

        TranslateAnimation transAnimOut =
                new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0,
                                        Animation.RELATIVE_TO_SELF,0,
                                        Animation.RELATIVE_TO_SELF, 0,
                                        Animation.RELATIVE_TO_SELF, 300);
        transAnimOut.setInterpolator(new LinearInterpolator());
        transAnimOut.setDuration(3000);
        mImgSwitcher.setOutAnimation(transAnimOut);

//        mImgSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
//        mImgSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));

        ImageAdapter imgAdap = new ImageAdapter(this, miThumbImgArr);

        mGridView = (GridView)findViewById(R.id.gridView);
        mGridView.setAdapter(imgAdap);
        mGridView.setOnItemClickListener(gridViewOnItemClick);

    }

    @Override
    public View makeView() {
        ImageView v = new ImageView(this);
        v.setBackgroundColor(0xFF000000);
        v.setScaleType(ImageView.ScaleType.FIT_CENTER);
        v.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        v.setBackgroundColor(Color.WHITE);
        return v;
    }

    AdapterView.OnItemClickListener gridViewOnItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//            switch ((int)(Math.random()*3 + 1)){
//                case 1:
//                    mImgSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity_gridView_V2.this, R.anim.alpha_in));
//                    mImgSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MainActivity_gridView_V2.this, R.anim.alpha_out));
//                    break;
//                case 2:
//                    mImgSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity_gridView_V2.this, R.anim.scale_rotate_in));
//                    mImgSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MainActivity_gridView_V2.this, R.anim.scale_rotate_out));
//                    break;
//                case 3:
//                    mImgSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity_gridView_V2.this, R.anim.trans_in));
//                    mImgSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MainActivity_gridView_V2.this, R.anim.trans_out));
//                    break;
//            }

            mImgSwitcher.setImageResource(miImgArr[position]);
        }
    };

}
