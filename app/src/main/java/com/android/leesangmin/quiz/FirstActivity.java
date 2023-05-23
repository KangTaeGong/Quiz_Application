package com.android.leesangmin.quiz;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends Activity{

    Button start_btn,check_btn,solve_btn,end_btn;

    private final long FINISH_INTERVAL_TIME=2000; //뒤로가기 두번 클릭 사이의 시간
    private long backPressedTime=0; //누른 횟수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        start_btn = (Button)findViewById(R.id.button1);
//        check_btn = (Button)findViewById(R.id.button2); //설정
        solve_btn = (Button)findViewById(R.id.button3); //문제 풀기
        end_btn = (Button)findViewById(R.id.button4);

        final soundActivity soundPlay = (soundActivity)getApplication();

        start_btn.setOnTouchListener(new View.OnTouchListener(){ //문제 보기
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){
                    Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                    soundPlay.play_click();
                    startActivity(intent);
                }
                return false;
            }
        });

//        check_btn.setOnTouchListener(new View.OnTouchListener(){ //설정
//            @Override
//        public boolean onTouch(View v, MotionEvent event) {
//            if(event.getAction() == MotionEvent.ACTION_UP){
//                Intent intent = new Intent(FirstActivity.this,bookActivity.class);
//                startActivity(intent);
//            }
//            return false;
//        }
//    });

        solve_btn.setOnTouchListener(new View.OnTouchListener(){ //문제 풀기 버튼
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){
                    Intent intent = new Intent(FirstActivity.this,RandomActivity.class);
                    soundPlay.play_click();
                    startActivity(intent);
                }
                return false;
            }
        });

        end_btn.setOnTouchListener(new View.OnTouchListener(){ //종료
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_UP){
                    soundPlay.play_click();
                    moveTaskToBack(true);
                    finish();
                    android.os.Process.killProcess(android.os.Process.myPid());
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() { //뒤로가기 버튼 2번 누르면 나감
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        if(0<=intervalTime && FINISH_INTERVAL_TIME >= intervalTime) {
            super.onBackPressed();
        }
        else{
            backPressedTime=tempTime;
            Toast.makeText(getApplicationContext(),"'뒤로'버튼을 한번도 누르시면 종료됩니다.",Toast.LENGTH_SHORT).show();
        }
    }
}