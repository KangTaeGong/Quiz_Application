package com.android.leesangmin.quiz;

import android.app.Application;
import android.media.AudioManager;
import android.media.SoundPool;

public class soundActivity extends Application{

    private SoundPool sound_pool;
    private int sound_click,sound_correct,sound_wrong,sound_check;

    @Override
    public void onCreate() {
        super.onCreate();

        sound_pool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        sound_click = sound_pool.load(getBaseContext(),R.raw.click,1);
        sound_correct = sound_pool.load(getBaseContext(),R.raw.correct,1);
        sound_wrong = sound_pool.load(getBaseContext(),R.raw.wrong,1);
        sound_check = sound_pool.load(getBaseContext(),R.raw.check,1);
    }

    public void play_click(){
        sound_pool.play(sound_click,1.0f,1.0f,0,0,1.0f);
    }

    public void play_correct(){
        sound_pool.play(sound_correct,1.0f,1.0f,0,0,1.0f);
    }

    public void play_wrong(){
        sound_pool.play(sound_wrong,1.0f,1.0f,0,0,1.0f);
    }

    public void play_check(){
        sound_pool.play(sound_check,1.0f,1.0f,0,0,1.0f);
    }

}
