package com.example.makemyhome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    ImageView imageVie;
    ProgressBar pb;
    Button btnProceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btnProceed=findViewById(R.id.btnProceed);
        //   Handler thread.;

        Handler handler = new Handler();

// a runnable that will hide the image after some seconds.
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // Hide image
                ImageView imageView = findViewById(R.id.imageVie);
                imageView.setVisibility(View.GONE);
            }
        };

// Post the runnable to the Handler thread after some seconds.o
        handler.postDelayed(runnable, 4000); // 3 seconds

btnProceed.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent intent=new Intent(MainActivity.this, MainPage.class);
        startActivity(intent);
        Toast.makeText(MainActivity.this, "Team Welcomes You!", Toast.LENGTH_SHORT).show();
    }
});


    }
}