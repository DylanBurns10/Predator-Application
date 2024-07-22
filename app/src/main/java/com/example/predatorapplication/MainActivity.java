package com.example.predatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);

        //Button start = (Button) findViewById(R.id.StartButton);
        //TextView title = (TextView) findViewById(R.id.Title);

    }

    public void goToGameScreen(View view){

        Intent gameScreen = new Intent(this, GameScreen.class);
        startActivity(gameScreen);

    }


}