package com.example.yulon.androidsimplegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mBtnScissors, mBtnStones, mBtnPaper;
    private TextView mTxtCom, mTxtR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        mBtnScissors.setOnClickListener(btnScissorsOnClick);
        mBtnStones.setOnClickListener(btnStonesOnClick);
        mBtnPaper.setOnClickListener(btnPaperOnClick);
    }

    private void initView(){
        mBtnPaper = (Button)findViewById(R.id.btnPaper);
        mBtnScissors = (Button)findViewById(R.id.btnScissors);
        mBtnStones = (Button)findViewById(R.id.btnStones);
        mTxtCom = (TextView)findViewById(R.id.txtComPlay);
        mTxtR = (TextView)findViewById(R.id.txtResult);
    }

    private View.OnClickListener btnScissorsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Play_Result(1);
        }
    };

    private View.OnClickListener btnStonesOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Play_Result(2);
        }
    };

    private View.OnClickListener btnPaperOnClick = new View.OnClickListener() {
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
                    mTxtCom.setText(getString(R.string.play_scissors));
                    s += getString(R.string.play_draw);
                    mTxtR.setText(s);
                }else if(iCom_play == 2){
                    mTxtCom.setText(getString(R.string.play_stones));
                    s += getString(R.string.play_lose);
                    mTxtR.setText(s);
                }else{
                    mTxtCom.setText(getString(R.string.play_paper));
                    s += getString(R.string.play_win);
                    mTxtR.setText(s);
                }
                break;
            case 2:
                //1-剪刀、2-石頭、3-布
                if(iCom_play == 1){
                    mTxtCom.setText(getString(R.string.play_scissors));
                    s += getString(R.string.play_win);
                    mTxtR.setText(s);
                }else if(iCom_play == 2){
                    mTxtCom.setText(getString(R.string.play_stones));
                    s += getString(R.string.play_draw);
                    mTxtR.setText(s);
                }else{
                    mTxtCom.setText(getString(R.string.play_paper));
                    s += getString(R.string.play_lose);
                    mTxtR.setText(s);
                }
                break;
            case 3:
                //1-剪刀、2-石頭、3-布
                if(iCom_play == 1){
                    mTxtCom.setText(getString(R.string.play_scissors));
                    s += getString(R.string.play_lose);
                    mTxtR.setText(s);
                }else if(iCom_play == 2){
                    mTxtCom.setText(getString(R.string.play_stones));
                    s += getString(R.string.play_win);
                    mTxtR.setText(s);
                }else{
                    mTxtCom.setText(getString(R.string.play_paper));
                    s += getString(R.string.play_draw);
                    mTxtR.setText(s);
                }
                break;
        }
    }
}
