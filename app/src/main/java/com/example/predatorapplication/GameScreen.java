package com.example.predatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class GameScreen extends AppCompatActivity {

    ImageView icon, predIcon, combistick, powerGauntlet, shoulderCannon, wristBlades, countdown, combistick2, powerGauntlet2;
    TextView description, question, HP, energy;
    Button option1, option2, option3, nextButton, mainMenu, gameOverBtn, next2, back;
    DecisionNode node;
    public int Health = 100;
    public int Energy = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        icon = (ImageView) findViewById(R.id.icon);
        predIcon = (ImageView) findViewById(R.id.pred_icon);
        combistick = (ImageView) findViewById(R.id.combistick);
        combistick2 = (ImageView) findViewById(R.id.combistick2);
        countdown = (ImageView) findViewById(R.id.countdown);
        wristBlades = (ImageView) findViewById(R.id.wristBlades);
        powerGauntlet = (ImageView) findViewById(R.id.powerGauntlet);
        powerGauntlet2 = (ImageView) findViewById(R.id.powerGauntlet2);
        shoulderCannon = (ImageView) findViewById(R.id.shoulder_cannon);

        option1 = (Button) findViewById(R.id.Option1);
        option2 = (Button) findViewById(R.id.Option2);
        option3 = (Button) findViewById(R.id.Option3);
        nextButton = (Button) findViewById(R.id.next);
        mainMenu = (Button) findViewById(R.id.mainMenu);
        gameOverBtn = (Button) findViewById(R.id.GameOver1);
        next2 = (Button) findViewById(R.id.next2);
        back = (Button) findViewById(R.id.back);

        question = (TextView) findViewById(R.id.Question);
        description = (TextView) findViewById(R.id.Description);
        HP = (TextView) findViewById(R.id.health);
        energy = (TextView) findViewById(R.id.energy);

        DecisionMap map;
        try {
            map = new DecisionMap(getApplicationContext());
        }
        catch (CustomException e) {
            description.setText(e.getMessage());
            return;
        }
        node = map.entryPoint();
        Visibility();

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectOption1();
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectOption2();
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectOption3();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectOption1();
            }
        });

        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainMenu();
            }
        });

        gameOverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToGameOver();
            }
        });

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextBtnToMenu();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });

    }

        public void Visibility(){

            description.setText(node.getDescription());
            question.setText(node.getQuestion());

            shoulderCannon.setVisibility(View.INVISIBLE);
            wristBlades.setVisibility(View.INVISIBLE);
            countdown.setVisibility(View.INVISIBLE);
            combistick.setVisibility(View.INVISIBLE);
            combistick2.setVisibility(View.INVISIBLE);
            powerGauntlet.setVisibility(View.INVISIBLE);
            powerGauntlet2.setVisibility(View.INVISIBLE);

            back.setVisibility(View.INVISIBLE);
            nextButton.setVisibility(View.INVISIBLE);
            next2.setVisibility(View.INVISIBLE);
            gameOverBtn.setVisibility(View.INVISIBLE);

            if (node.getNodeID() == 49){
                icon.setImageResource(R.drawable.underwater_base);
            }

            if (node.getNodeID() == 108){
                shoulderCannon.setVisibility(View.VISIBLE);
            }

            if (node.getNodeID() == 113){
                countdown.setVisibility(View.VISIBLE);
            }


            if (node.getNodeID() == 33 || node.getNodeID() == 83 || node.getNodeID() == 88 || node.getNodeID() == 116){
                next2.setVisibility(View.VISIBLE);
            }

            if (node.getOption3ID() == -1){
                option3.setVisibility(View.INVISIBLE);
            }
            else {
                option3.setVisibility(View.VISIBLE);
            }
            if (node.getQuestion().equals("-")){
                question.setVisibility(View.INVISIBLE);
                nextButton.setVisibility(View.VISIBLE);
                option1.setVisibility(View.INVISIBLE);
                option2.setVisibility(View.INVISIBLE);
            }
            else {
                question.setVisibility(View.VISIBLE);
                option1.setVisibility(View.VISIBLE);
                option2.setVisibility(View.VISIBLE);
            }
            if (node.getDescription().equals("-")){
                description.setVisibility(View.INVISIBLE);
                }
            else {
                description.setVisibility(View.VISIBLE);
            }
            if (node.getNodeID() == 2){
                option1.setText("Mountains surrounding the base");
                option2.setText("Centre of the base");
            }
            else if (node.getNodeID() == 3 || node.getNodeID() == 5 || node.getNodeID() == 8 || node.getNodeID() == 29 || node.getNodeID() == 42 || node.getNodeID() == 47
                    || node.getNodeID() == 51 || node.getNodeID() == 55 || node.getNodeID() == 56 || node.getNodeID() == 59 || node.getNodeID() == 67
                    || node.getNodeID() == 104 || node.getNodeID() == 135){
                option1.setText("Yes");
                option2.setText("No");
            }
            else if (node.getNodeID() == 40 || node.getNodeID() == 66 || node.getNodeID() == 76 || node.getNodeID() == 90 || node.getNodeID() == 97
                    || node.getNodeID() == 108 || node.getNodeID() == 113 || node.getNodeID() == 127 || node.getNodeID() == 130){
                option1.setText("No");
                option2.setText("Yes");
            }
            else if (node.getNodeID() == 64 || node.getNodeID() == 84 || node.getNodeID() == 125){
                option1.setText("Left");
                option2.setText("Right");
            }
            else if (node.getNodeID() == 38 || node.getNodeID() == 78 || node.getNodeID() == 99 || node.getNodeID() == 109){
                option1.setText("Wrist-blades");
                wristBlades.setVisibility(View.VISIBLE);
                option2.setText("Combistick");
                combistick.setVisibility(View.VISIBLE);
                option3.setText("Power gauntlet");
                powerGauntlet.setVisibility(View.VISIBLE);
            }
            else if (node.getNodeID() == 13 || node.getNodeID() == 17){
                option1.setText("Leap");
                option2.setText("Run");
            }
            else if (node.getNodeID() == 25){
                option1.setText("Run at them");
                option2.setText("Leap through the air");
            }
            else if (node.getNodeID() == 23){
                option1.setText("Take cover");
                option2.setText("Take the fight");
            }
            else if (node.getNodeID() == 31){
                option1.setText("Wrist-blades");
                wristBlades.setVisibility(View.VISIBLE);
                option2.setText("Power gauntlet");
                powerGauntlet2.setVisibility(View.VISIBLE);
                option3.setText("Combistick");
                combistick2.setVisibility(View.VISIBLE);
            }
            else if (node.getNodeID() == 7){
                option1.setText("Leap into the trees");
                option2.setText("Front gate");
            }
            else if (node.getNodeID() == 16){
                option1.setText("Face them");
                option2.setText("Run");
            }
            else if (node.getNodeID() == 10){
                option1.setText("Kill them");
                option2.setText("Run");
            }
            else if (node.getNodeID() == 121){
                option1.setText("Right");
                option2.setText("In front");
            }
            else if (node.getNodeID() == 62){
                option1.setText("In front");
                option2.setText("Right");
            }

            // HP
            if (node.getNodeID() == 20 || node.getNodeID() == 26 || node.getNodeID() == 80){
                HP.setText("HP: " + (Health = Health - 25));
            }
            else if (node.getNodeID() == 34){
                HP.setText("HP: " + (Health = Health - 70));
            }
            else if (node.getNodeID() == 15 || node.getNodeID() == 19 || node.getNodeID() == 27){
                HP.setText("HP: " + (Health = Health - 15));
            }
            else if (node.getNodeID() == 32 || node.getNodeID() == 37 || node.getNodeID() == 82 || node.getNodeID() == 95 || node.getNodeID() == 112){
                HP.setText("HP: " + (Health = Health - 999));
            }
            else if (node.getNodeID() == 11 || node.getNodeID() == 18 || node.getNodeID() == 48 || node.getNodeID() == 79 || node.getNodeID() == 102 || node.getNodeID() == 117){
                HP.setText("HP: " + (Health = Health - 10));
            }
            else if (node.getNodeID() == 12 || node.getNodeID() == 44){
                HP.setText("HP: " + (Health = Health - 20));
            }
            else if (node.getNodeID() == 52){
                HP.setText("HP: " + (Health = Health + 50));
            }
            else if (node.getNodeID() == 110 || node.getNodeID() == 111 || node.getNodeID() == 123){
                HP.setText("HP: " + (Health = (Health*0) + 1));
            }
            else if (node.getNodeID() == 100){
                HP.setText("HP: " + (Health = Health - 50));
            }
            if (Health < 0){
                nextButton.setVisibility(View.INVISIBLE);
                option1.setVisibility(View.INVISIBLE);
                option2.setVisibility(View.INVISIBLE);
                option3.setVisibility(View.INVISIBLE);
                gameOverBtn.setVisibility(View.VISIBLE);
            }
            if (Health > 100){
                HP.setText("HP: " + (Health = (Health*0) + 100));
            }
            if (Health < 50){
                predIcon.setImageResource(R.drawable.injured);
            }

            //Energy
            if (node.getNodeID() == 6 || node.getNodeID() == 9 || node.getNodeID() == 43 || node.getNodeID() == 57 || node.getNodeID() == 68 || node.getNodeID() == 131){
                energy.setText("Energy: " + (Energy = Energy - 20));
                if (Energy < 0){
                    description.setText("You do not have enough energy!");
                    back.setVisibility(View.VISIBLE);
                    nextButton.setVisibility(View.INVISIBLE);
                    energy.setText("Energy: " + (Energy = Energy + 20));
                }
            }
            if (node.getNodeID() == 34 || node.getNodeID() == 46 || node.getNodeID() == 92 || node.getNodeID() == 102 || node.getNodeID() == 105 || node.getNodeID() == 129){
                energy.setText("Energy: " + (Energy = Energy - 35));
                if (Energy < 0){
                    description.setText("You do not have enough energy!");
                    back.setVisibility(View.VISIBLE);
                    nextButton.setVisibility(View.INVISIBLE);;
                    energy.setText("Energy: " + (Energy = Energy + 35));
                    HP.setText("HP: " + (Health = Health + 10));
                }
            }
            if (node.getNodeID() == 115){
                energy.setText("Energy: " + (Energy = Energy - 50));
                if (Energy < 0){
                    description.setText("You do not have enough energy!");
                    back.setVisibility(View.VISIBLE);
                    nextButton.setVisibility(View.INVISIBLE);
                    energy.setText("Energy: " + (Energy = Energy + 50));
                }
            }
            if (node.getNodeID() == 117){
                energy.setText("Energy: " + (Energy = Energy - 40));
                if (Energy < 0){
                    description.setText("You do not have enough energy!");
                    back.setVisibility(View.VISIBLE);
                    nextButton.setVisibility(View.INVISIBLE);
                    energy.setText("Energy: " + (Energy = Energy + 40));
                    HP.setText("HP: " + (Health = Health + 10));
                }
            }
            if (node.getNodeID() == 68 || node.getNodeID() == 131 || node.getNodeID() == 34 || node.getNodeID() == 46 || node.getNodeID() == 92 || node.getNodeID() == 102
                    || node.getNodeID() == 105 || node.getNodeID() == 129 || node.getNodeID() == 115 || node.getNodeID() == 117){
                option3.setVisibility(View.INVISIBLE);
            }

        }
        public void back(){
            node = node.getOption3Node();
            Visibility();
        }

        public void selectOption1(){
        node = node.getOption1Node();
        Visibility();
        }

        public void selectOption2(){
        node = node.getOption2Node();
        Visibility();
        }
        public void selectOption3(){
        node = node.getOption3Node();
        Visibility();
        }

        public void goToMainMenu(){
            Intent mainMenuScreen = new Intent(this, MainActivity.class);
            startActivity(mainMenuScreen);
        }

        public void goToGameOver(){
            Intent gameOverScreen = new Intent(this, GameOver.class);
            startActivity(gameOverScreen);
        }

        public void nextBtnToMenu(){
            Intent nextBtnToMenu = new Intent(this, MainActivity.class);
            startActivity(nextBtnToMenu);
        }


    }

