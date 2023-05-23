package com.android.leesangmin.quiz;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SecondActivity extends Activity {
    ListView listView;

    public static String[] listVal = new String[]{"피자가 웃으면?","아우디 보다 먼저나온 차는?","세상에서 가장 잔인한 비빔밥은?","미소의 반댓말은?","중학생과 고등학생이 타는 차는?"
            ,"세사람만 탈수인는 차는?","펭귄이 다니는 고등학교는?","서울시민 천만명이 한마디씩하면?","아몬드가 죽으면?","슈렉의 어머니는?",
            "'개가 사람을 가르친다'를 4글자로 줄이면?","타이타닉의 구명보트에 몇 명이 탈 수 있을까요?","신사가 하는 인사는?","할아버지가 좋아하는 돈은?",
            "김은 김인데 하얀 김은?","검둥이와 흰둥이가 싸우는 것은?","얼음이 죽으면?","차에서 코를 푸는 것을 줄이면?",
            "붉은 길에서 동전을 주은 것을 줄이면?","머리로 들어가고 입으로 나오는 것은?","입으로 들어가서 배로 나오는 것은?","형이랑 동생이 싸웠는데 동생편만 드는 것을 뭐라고 할까요?",
            "바나나가 웃으면?","병아리가 태어나서 가장 먼저 찾는 약은?","사과를 베어먹으면?","왕이 넘어지면?","많이 맞을수록 좋은 것은?","동생이 형을 굉장히 좋아하는것은?",
            "성세개가 불타고 있는 것은?","불은 불인데 안 뜨거운 불은?","콩쥐의 깨진 독을 수리해 준 사람들은?","가장 더러운 강은?","서로 진짜라고 우기는 신은?","전주비빕밥보다 늦은 비빕밥은?",
            "세상에서 가장 먼저 자는 자는 사람은?","세종대왕이 만든 우유는?","어부들이 가장 싫어하는 가수는?","불이 4곳에 나면?","오리를 생으로 먹으면?","원숭이를 불에 구우면?",
            "사람의 몸무게가 가장 많이 나갈 때는?","정삼각형의 동생 이름은?","신발이 화가나면?","펭귄이 다니는 중학교는?","눈과 구름, 칼을 세글자로 하면?","배우 최지우가 키우는 개 이름은?",
            "엄마와 아이가 길을 가다가 넘어진 것을 네 글자로 하면?","송혜교, 송대관, 송윤아의 공통점은?","발이 두 개 달린 소는?","제빵왕 김탁구가 가장 싫어하는 유머는?","늘 배고픈 나라는?",
            "부처님이 잘생겼다를 네 글자로 줄이면?","꽃가게 주인이 가장 싫어하는 나라는?","별 중에 가장 슬픈 별은?","세상에서 가장 뜨거운 바다는?","목수도 고칠 수 없는 집은?",
            "폭력배가 많은 나라는?","차도가 없는 나라는?","먹고 살기 위해 하는 내기는?","말은 말인데 타지 못하는 말은?","사람이 먹을 수 있는 제비는?","세상에서 가장 빠른 닭은?","개 중에 가장 아름다운 개는?",
            "누구나 즐겁게 웃으며 읽는 글은?","다리 중 아무도 보지 못한 다리는?","떡 중에 가장 빨리 먹는 떡은?","똥은 똥인데 다른 곳으로 튀는 똥은?","물고기 중에서 가장 학벌이 좋은 물고기는?",
            "물은 물인데 사람들이 가장 좋아하는 물은?","바닷가에서는 해도 되는 욕은?","사람들이 가장 싫어하는 (길)거리는?","사람이 즐겨 먹는 피는?","아홉 명의 자식을 세자로 줄이면?",
            "약은 약인데 아껴 먹어야 하는 약은?","장사꾼들이 싫어하는 경기는?"," 전쟁 중에 장군이 가장 받고 싶어하는 복은?","칼은 칼인데 전혀 들지 않는 칼은?","탈 중에 쓰지 못하는 탈은?",
            "파리 중에 가장 무거운 파리는?","호랑이는 영어로 Tiger이다. 그러면 이 빠진 호랑이는?","남이 먹어야 맛있는 것은?","못 팔고도 돈 번 사람은?","가만히 있는데 잘 돈다고 하는 것은?",
            "이상한 사람들이 모이는 곳은?","날마다 가슴에 흑심을 품고 있는 것은?","허수아비의 아들 이름은?","언제나 말다툼이 있는 곳은?","양초가 가득 차 있는 상자를 3자로 줄이면?",
            "억수 같은 폭우가 쏟아지는 곳은?","김과 김밥이 길을 걷는데 비가오고 있었다. 김밥은 비에 풀어질까봐 열심히 뛰어왔지만 김은 느긋하게 걸어오고 있었다. 왜 그럴까? 'OO O이라서'",
            "소금장수가 좋아하는 사람은?","거지가 가장 좋아하는 욕은?","도둑이 가장 좋아하는 아이스크림은?","헌병이 가장 무서워하는 사람은?","먹을수록 덜덜 떨리는 음식은?",
            "직장에서 가장 무서운 상사는?","세상 사람들이 가장 좋아하는 영화는?","도둑이 가장 싫어하는 아이스크림은?","새 중에서 가장 빠른 새는?","하늘에서 떨어지는 개는?",
            "부인이 남편에게 매일같이 주는 상은?","먹으면 죽는데 안 먹을 수 없는 것은?","집에서 매일 먹는 약은?","세계에서 몸집에 제일 큰 여자의 이름은?","물 없는 사막에서도 할 수 있는 물놀이는?",
            "도둑이 훔친 돈을 뭐라고 할까?","처음 만나는 소가 하는 말은?","잠자는 소는?","쥐가 네 마리 모이면 무엇이 될까?","소금을 죽이면?","친구들과 술집에 가서, 술값 안 내려고 추는 춤은?",
            "미국은 달러, 한국은 원, 일본은 엔 그러면 호주는?","가장 쓸모없는 구리는?","오락실을 지키는 수호신 용 두 마리는?","노인들이 가장 좋아하는 폭포는?","텔레토비가 차린 안경점 이름은?",
            "비가 올 때 하는 욕은?","고기 먹을 때마다 따라오는 개는?","세상에서 가장 추운 바다는?","가기만 하고 돌아오지 않는 것은?"};

    public static String[] listVal2 = new String[]{"피자헛","형디","산채비빔밥","당기소","중고차","인삼차","냉장고","천만의 말씀","다이아몬드","녹색어머니"
            ,"개인지도","9명","신사임당","할머니","앙드레김","바둑","다이빙","차이코프스키","홍길동전","주전자","우체통","형편없는세상",
    "바나나킥","삐약","파인애플","킹콩","시험문제","형광펜","삼성화재","이불","독수리오형제","요강","옥신각신","이번주비빔밥","이미자","아야어여오요우유",
    "배철수","사파이어","회오리","구운몽","철들때","정삼각","신발끈","냉방중","설운도","지우개","모자이크","성동일","이발소","빵터지는 유머","헝가리",
    "부처핸섬","시드니","이별","열바다","고집","칠레","인도","모내기","거짓말","수제비","후다닥","무지개","싱글벙글","헛다리","헐레벌떡",
    "불똥","고등어","선물","해수욕","걱정거리","커피","아이구","절약","불경기","항복","머리칼","배탈","돌팔이","Tigr","골탕","철물점 주인","머리",
    "치과","연필","허수","경마장","초만원","비무장지대","양반 김","싱거운 사람","빌어먹을","보석바","고물장수","추어탕","불상사",
    "부귀영화","누가바","눈 깜짝할 새","번개","밥상","나이","치약","태평양","사물놀이","슬그머니","반갑소","주무소","쥐포","죽염","주춤주춤","호주머니",
    "멍텅구리","일인용과 이인용","나이아가라 폭포","아이조아","BYC","이쑤시개","썰렁해","세월"}; //120문제

    public static String[] hint_listVal = new String[]{"허허헛","동생과 ?","ㅅㅊ","pull","used","몸에 좋은것","시원하다~","10000000","진짜 비싸다","초록엄마"
    ,"1:1","비둘기가 우는 소리","5만원","할 + 돈","하얀 패션 디자이너","오목<->??","수영 관련","러시아 작곡가","호부호형","ㅈㅈㅈ","우체국","ㅎㅍㅇㄴㅅㅅ"
    ,"바나나 과자","B","I'm fine","고릴라","XX기간","빛나는 펜","화재 보험","잠잔다~","XXX오형제","요ㄱㅏ","ㅇㅅㄱㅅ","저번주","ㅇㅁㅈ","ㅇㅇㅇㅇㅇㅇㅇㅇ"
    ,"가수","4화","XXX감자","육관대사의 수제자","피가 철철 난다.","빼기","신발 친구","추운 고등학교 안에서 일어나는 일","ㅅㅇㄷ","알리","뉴스에서 얼굴 가릴 때 쓰는 것","성이 같네?","2+foot+cow","빵 폭발","헝그리"
    ,"손들어!","꽃이 시들었네","저별<->??","ㅇ바다","go home","ㅊㄹ","사람이 걸어다니는 곳","무슨 내기할래?","빅뱅이 부릅니다.","물X제비","ㅎㄷ닥","7가지 색","싱ㄱㅂㄱ","ㅎ다리","ㅎㄹㅂ떡"
    ,"물똥<->??","자반","생일","ㅎㅅㅇ","고민","스타벅X","kid 9","물 XX //전기 XX","물경기<->???","행복-ㅣ","얼굴 위","ㅂㅌ","돌파는 상인","e->X","ㄱㅌ","ㅊㅁㅈ ㅈㅇ","아이디어 뱅크"
    ,"충치 치료","샤프 형","두글자","3번마 이름 번개","꽉 찼다.","DMZ","노비 김<->?? ?","짠 사람<->??? 사람","ㅂㅇㅁㅇ","뭔가 박혀있는 아이스크림","go water XX 돌침대","추운탕","ㅂㅅㅅ"
    ,"귀가 아닌 영화","훔쳐보는 아이스크림","ㄴ ㄲㅉㅎ ㅅ","ㅂㄱ","XX머리 앞에서","떡국","칫솔 친구","???을 건너 대서양을 건너~","4 water 놀이","ㅅㄱㅁㄴ","ㅂㄱㅅ","주유소에서 한글자만..","ㅈㅍ","ㅈㅇ","엉거 ㅈㅊ X2","바지의 영원한 친구"
    ,"ㅁㅌㄱㄹ","1P(과) 2P","나이 잘가~","I like it","?ewh? ?jam(대문자)","뾰족한 물건","XX개그","XX아 내월아"};

    public long seed=System.nanoTime();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        listView=(ListView)findViewById(R.id.listview1);

        final ArrayList<String> list2 = new ArrayList<String>(); //답 배열
        final ArrayList<String> list = new ArrayList<String>(); //넌센스 문제 배열 입력
        final ArrayList<String> hint_list = new ArrayList<String>(); //정답 힌트 배열
        final soundActivity soundplay = (soundActivity)getApplication(); //사운드 출력

        for(int i=0;i<listVal.length;++i){
            list.add(listVal[i]);
            list2.add(listVal2[i]); //답
            hint_list.add(hint_listVal[i]); //힌트
        }

        Intent get_intent = getIntent();
        int get_check = get_intent.getIntExtra("a",0);

        if(get_check==1){

            Collections.shuffle(list,new Random(seed)); //문제 셔플
            Collections.shuffle(list2,new Random(seed)); // 답 셔플
            Collections.shuffle(hint_list,new Random(seed)); //힌트 셔플

            Intent Ran_intent = new Intent(SecondActivity.this,RandomActivity.class);

            Ran_intent.putExtra("list",list); //문제
            Ran_intent.putExtra("list2",list2); //답
            Ran_intent.putExtra("hint",hint_list); //힌트
            Ran_intent.putExtra("count1",5); //무한 반복하지 않도록 값 보내줌
            startActivity(Ran_intent);
//
            finish();
        }

        final ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this,R.layout.simple_list_item_1,list);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){ //listview클릭
            @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String a_list = listVal2[position]; //정답 받음
                Intent intent = new Intent(SecondActivity.this,OneActivity.class);
                final String item = (String)parent.getItemAtPosition(position); //position값 받아옴
                soundplay.play_click();
                intent.putExtra("count",position); //다음으로 넘어가는 버튼 때문에 position 보냄
                intent.putExtra("question",item);
                intent.putExtra("answer",a_list);
                startActivity(intent);
                }
        });
    }
}