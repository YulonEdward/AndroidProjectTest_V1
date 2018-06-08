package com.example.yulon.androidsimplegame;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity_gameimagebtn extends AppCompatActivity {

    private ImageView mImageViewComPlay;
    private ImageButton mImageBtnScissor, mImageBtnStone, mImageBtnPaper;
    private TextView mTxtR;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_imagebutton);

        initView();

        mImageBtnScissor.setOnClickListener(imgBtnScissorOnClick);
        mImageBtnStone.setOnClickListener(imgBtnStoneOnClick);
        mImageBtnPaper.setOnClickListener(imgBtnPaperOnClick);
    }

    private void initView(){
        mImageViewComPlay = (ImageView)findViewById(R.id.imgCom);
        mImageBtnPaper = (ImageButton)findViewById(R.id.imgbtnPaper);
        mImageBtnScissor = (ImageButton)findViewById(R.id.imgbtnScissor);
        mImageBtnStone = (ImageButton)findViewById(R.id.imgbtnStone);
        mTxtR = (TextView)findViewById(R.id.txtResult);
    }

    private View.OnClickListener imgBtnScissorOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Play_Result(1);
        }
    };

    private View.OnClickListener imgBtnStoneOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Play_Result(2);
        }
    };

    private View.OnClickListener imgBtnPaperOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Play_Result(3);
        }
    };

    private void Play_Result(int i){
        int iCom_play = (int)(Math.random()*3 + 1);
        String s = getString(R.string.result);

        switch (i){
            case 1:
                //1-剪刀、2-石頭、3-布
                if(iCom_play == 1){
                    mImageViewComPlay.setImageResource(R.drawable.scissor);
                    s += getString(R.string.play_draw);
                    mTxtR.setText(s);
                }else if(iCom_play == 2){
                    mImageViewComPlay.setImageResource(R.drawable.stone);
                    s += getString(R.string.play_lose);
                    mTxtR.setText(s);
                }else{
                    mImageViewComPlay.setImageResource(R.drawable.paper);
                    s += getString(R.string.play_win);
                    mTxtR.setText(s);
                }
                break;
            case 2:
                //1-剪刀、2-石頭、3-布
                if(iCom_play == 1){
                    mImageViewComPlay.setImageResource(R.drawable.scissor);
                    s += getString(R.string.play_win);
                    mTxtR.setText(s);
                }else if(iCom_play == 2){
                    mImageViewComPlay.setImageResource(R.drawable.stone);
                    s += getString(R.string.play_draw);
                    mTxtR.setText(s);
                }else{
                    mImageViewComPlay.setImageResource(R.drawable.paper);
                    s += getString(R.string.play_lose);
                    mTxtR.setText(s);
                }
                break;
            case 3:
                //1-剪刀、2-石頭、3-布
                if(iCom_play == 1){
                    mImageViewComPlay.setImageResource(R.drawable.scissor);
                    s += getString(R.string.play_lose);
                    mTxtR.setText(s);
                }else if(iCom_play == 2){
                    mImageViewComPlay.setImageResource(R.drawable.stone);
                    s += getString(R.string.play_win);
                    mTxtR.setText(s);
                }else{
                    mImageViewComPlay.setImageResource(R.drawable.paper);
                    s += getString(R.string.play_draw);
                    mTxtR.setText(s);
                }
                break;
        }
    }
}
