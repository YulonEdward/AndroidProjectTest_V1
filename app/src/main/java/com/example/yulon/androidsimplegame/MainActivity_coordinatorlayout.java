package com.example.yulon.androidsimplegame;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity_coordinatorlayout extends AppCompatActivity {

    private FloatingActionButton mFab;
    private TextView mTxtMsg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_coordinatorlayout);

        mFab = (FloatingActionButton)findViewById(R.id.fab);
        mTxtMsg = (TextView)findViewById(R.id.txtMsg);

        mFab.setOnClickListener(mFabOnClick);
    }

    private View.OnClickListener mFabOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mTxtMsg.setText("你按了 FAB 按鈕！");
        }
   };
}
