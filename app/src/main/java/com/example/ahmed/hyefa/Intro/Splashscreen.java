package com.example.ahmed.hyefa.Intro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.example.ahmed.hyefa.Manager.Loginas;
import com.example.ahmed.hyefa.Manager.Navigation;
import com.example.ahmed.hyefa.R;


public class Splashscreen extends AppCompatActivity {
    LinearLayout l1,l2;
    Animation uptodown,downtoup;
    private int SLEEP_TIMER = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splashscreen);
        getSupportActionBar().hide();
        LogoLauncher logoLauncher = new LogoLauncher();
        logoLauncher.start();


         l1 =  findViewById(R.id.l1);
         l2 =  findViewById(R.id.l2);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        l1.setAnimation(uptodown);
        l2.setAnimation(downtoup);

    }

    private class LogoLauncher extends Thread {
        public void run(){
            try{
                sleep(1000 * SLEEP_TIMER);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            Intent intent = new Intent(Splashscreen.this, Loginas.class);
            startActivity(intent);
            Splashscreen.this.finish();
        }
    }
}