package com.android.leesangmin.quiz;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OneActivity extends Activity{

    LinearLayout check1;
    TextView tvqu,tvan;
    Button btn2;
    public int num1,next,count1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        check1 = (LinearLayout)findViewById(R.id.answer);

        tvqu = (TextView)findViewById(R.id.textview1);
        tvan = (TextView)findViewById(R.id.textview2);
        btn2 = (Button)findViewById(R.id.button2); //다음 버튼

        final Intent intent = getIntent();
        final soundActivity soundplay = (soundActivity)getApplication();

        num1 = intent.getIntExtra("count",0); //positinon값 저장

//        tvqu.setText("");
        tvqu.setText(intent.getStringExtra("question"));
//        Log.v("알림","값 받아서 OneActivity에 출력합니다.");

        next=0; //맨처음과 두번째 부터 구분하기 위한 변수
        if(num1>=119){ //listview가 마지막까지 온다면 아래 명령 실행
            btn2.setEnabled(false);
        }

        check1.setOnClickListener(new View.OnClickListener(){ //정답 클릭 이벤트
            @Override
            public void onClick(View v) {
                if(next==0){
                    tvan.setText(intent.getStringExtra("answer"));
                    next=1; //처음만 0이어서 받아서 출력 나머지는 1이되어서 때마다 다르게 출력
                    soundplay.play_check();
                }else{
                    soundplay.play_check();
                    tvan.setText(""+SecondActivity.listVal2[num1]);
                }
            }
        });

        btn2.setOnTouchListener(new View.OnTouchListener(){ //버튼 누르면 다음 문제로 넘어감
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){
                    soundplay.play_click();
                    num1++; //다음으로 넘어가면 카운트 +1
                    tvqu.setText(""+SecondActivity.listVal[num1]);
                    tvan.setText("정답"); //다음으로 넘어가면 정답칸 텍스트를 다시 정답으로 고침
//                        Log.v("알림",""+num1);
//                  }
                    if(num1>=119){
//                        Log.v("알림","119 됬다");
                        btn2.setEnabled(false);
                    }
                }
                return false;
            }
        });
    }
}