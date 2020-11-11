package com.test.desing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity implements OnTouchListener{
    float fromPosition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ConstraintLayout tv = findViewById(R.id.fon);
        tv.setOnTouchListener(this);
        setContentView(tv);
    }

    public boolean onTouch(View view, MotionEvent event)
    {
        if (event.getAction()==MotionEvent.ACTION_DOWN){
            fromPosition = event.getX();
        }
        if (event.getAction()==MotionEvent.ACTION_UP){
            float toPosition = event.getX();
            if (fromPosition > toPosition){
                Intent intent = new Intent(MainActivity.this,game.class);
                startActivity(intent);
            }

        }
        return true;
    }
}