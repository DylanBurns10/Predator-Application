package com.example.predatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameOver extends AppCompatActivity {

    Button mainMenu2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        mainMenu2 = (Button) findViewById(R.id.mainMenu2);

        mainMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainMenu();
            }
        });
    }
    public void goToMainMenu(){
        Intent mainMenuScreen = new Intent(this, MainActivity.class);
        startActivity(mainMenuScreen);
    }

}