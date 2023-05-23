package com.android.leesangmin.quiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RandomActivity extends Activity{

    TextView tv1,tv2,hint_text;
    Button back_button,check_button,next_button;
    EditText check;
    LinearLayout hint_blank;

    public static ArrayList<String>list = new ArrayList<String>(); //문제를 list에 받음
    public static ArrayList<String>list2 = new ArrayList<String>(); //정답을 list2에 받음
    public static ArrayList<String>hint_list = new ArrayList<String>(); //힌드를 hint_list에 받음
    public int count=0,count1; //문제 넘어갈때마다 카운트

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        tv1 = (TextView)findViewById(R.id.textview1); //Q1.
        tv2 = (TextView)findViewById(R.id.textview2); //question

        back_button = (Button)findViewById(R.id.button1); //한번 누르면 다이얼로그 박스 출력하기
        check_button = (Button)findViewById(R.id.button2);
        next_button = (Button)findViewById(R.id.button3); //버튼 비활성화/정답 확인시 활성화

        check = (EditText)findViewById(R.id.editText); //정답 쓰는 칸

        hint_blank = (LinearLayout)findViewById(R.id.line1); //정답 LinearLayout
        hint_text=(TextView)findViewById(R.id.tv1); //정답 텍스트 출력

        next_button.setEnabled(false); //문제를 맞추기 전까지 다음으로 넘어가는 버튼 비활성화
        tv1.setText("Question 1.");

        hint_text.setText("Hint");

        //SecondActivity에서 값을 가져오기 위해서 보냄
        Intent Se_intent = getIntent();
        count1 = Se_intent.getIntExtra("count1",0);
        int a=1;
        final soundActivity soundplay = (soundActivity)getApplication();

        if(count1==0){ //처음 들어오면 SecondActivity로 값 넘김(값을 받아 오기 위한 준비)
            Intent intent1 = new Intent(RandomActivity.this,SecondActivity.class);
            intent1.putExtra("a",a);
            startActivity(intent1);

            finish();
        } else if(count1==5){
            ArrayList<String> arraylist1 =(ArrayList<String>)Se_intent.getSerializableExtra("list"); //문제
            ArrayList<String> arraylist2 =(ArrayList<String>)Se_intent.getSerializableExtra("list2");//답
            ArrayList<String> arraylist3 =(ArrayList<String>)Se_intent.getSerializableExtra("hint"); //힌트

            for(int i=0;i<arraylist1.size();i++){
                list.add(arraylist1.get(i)); //받아온 문제 저장
                list2.add(arraylist2.get(i)); //받아온 답 저장
                hint_list.add(arraylist3.get(i)); //받아온 힌트 저장
            }

            tv2.setText(""+list.get(0)); //셔플 값을 받아온 후 맨 처음 값 출력
        }

        back_button.setOnTouchListener(new View.OnTouchListener(){ //나가기 버튼
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){
                    soundplay.play_click();
                    AlertDialog ms1 = new AlertDialog.Builder(RandomActivity.this).setMessage("여기서 나가시겠습니까?")
                            .setPositiveButton("네",new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    soundplay.play_click();
                                    finish();
                                }
                            })
                            .setNegativeButton("아니요",new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    soundplay.play_click();
                                    //그대로 있을꺼니까 내용 안넣어도 됨
                                }
                            }).create();
                    ms1.show();
                }
                return false;
            }
        });

            next_button.setOnTouchListener(new View.OnTouchListener(){ //다음 문제로 넘어가는 버튼
                @Override
                public boolean onTouch(View v, MotionEvent event) { //다음으로 넘어가는 버튼을 누르면 다시 난수를 보내서 문제 출력
                    if(event.getAction() == MotionEvent.ACTION_UP){
                        count++; //문제와 답의 index번호
                        int count2 = count+1;
//                        Log.v("알림","count값 출력"+count); //count에 1을 더해서 Question+i일때 i로 출력함
                        tv1.setText("Question "+count2+".");
                        tv2.setText(""+list.get(count));
                        check.setText("");
                        hint_text.setText("Hint");
                        next_button.setEnabled(false);
                        soundplay.play_click();
                    }
                    return false;
                }
            });

        check_button.setOnTouchListener(new View.OnTouchListener(){ //답 확인 버튼 클릭시 이벤트
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){ //버튼을 눌렀다가 손을 땟을때 아래 이벤트 실행
//                    int i=0;
                    String answer = list2.get(count); //답이 들어가있는 list2의 위치를 잡아서 가져옴
                    String user_answer = check.getText().toString(); //사용자가 쓴 답
                    soundplay.play_click();

                    if(user_answer.equals(answer)){ //사용자가 쓴 답과 원래의 답이 같다면 아래 소스코드 실행
                        next_button.setEnabled(true); //다음으로 넘어가는 버튼 활성화
                        Toast.makeText(RandomActivity.this,"정답입니다!!",Toast.LENGTH_SHORT).show();
                        soundplay.play_correct();

                    } else if(user_answer.equals("")){
                        Toast.makeText(RandomActivity.this,"정답을 입력해 주세요!",Toast.LENGTH_SHORT).show();
                    } else{

                        check.setText("");
                        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); //답이 틀리면 진동
                        vibrator.vibrate(1000);
                        soundplay.play_wrong();
                        Toast.makeText(RandomActivity.this,"오답입니다ㅜㅜ",Toast.LENGTH_SHORT).show();
                    }
                }
                return false;
            }
        });

        hint_blank.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                hint_text.setText(""+hint_list.get(count));
            }
        });
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setMessage("여기서 나가시겠습니까?")
                .setPositiveButton("네",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("아니요",null)
                .show();
    }

}