package com.example.android.sortinghat;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.sortinghat.R.string.gryffindor;
import static com.example.android.sortinghat.R.string.gryffindor_des;
import static com.example.android.sortinghat.R.string.hufflepuff_des;
import static com.example.android.sortinghat.R.string.ravenclaw;
import static com.example.android.sortinghat.R.string.ravenclaw_des;
import static com.example.android.sortinghat.R.string.slytherin_des;

public class MainActivity extends AppCompatActivity {

    RadioGroup question1, question2, question3, question4, question5, question6, question7;
    LinearLayout results;
    TextView houseName, houseDescription;
    ImageView houseImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void computeResult(View view){
        int     gryffindorPoints = 0,
                ravenclawPoints = 0,
                hufflepuffPoints = 0,
                slytherinPoints = 0,
                gryffindorID = 1,
                ravenclawID = 2,
                hufflepuffID = 3,
                slytherinID = 4,
                staleID = 5;

        question1 = (RadioGroup) findViewById(R.id.question_1);
        question2 = (RadioGroup) findViewById(R.id.question_2);
        question3 = (RadioGroup) findViewById(R.id.question_3);
        question4 = (RadioGroup) findViewById(R.id.question_4);
        question5 = (RadioGroup) findViewById(R.id.question_5);
        question6 = (RadioGroup) findViewById(R.id.question_6);
        question7 = (RadioGroup) findViewById(R.id.question_7);


        int firstAnswer = question1.getCheckedRadioButtonId();
        int secondAnswer = question2.getCheckedRadioButtonId();
        int thirdAnswer = question3.getCheckedRadioButtonId();
        int fourthAnswer = question4.getCheckedRadioButtonId();
        int fifthAnswer = question5.getCheckedRadioButtonId();
        int sixthAnswer = question6.getCheckedRadioButtonId();
        int seventhAnswer = question7.getCheckedRadioButtonId();

        if((firstAnswer == -1) || (secondAnswer == -1) || (thirdAnswer == -1) || (fourthAnswer == -1) || (fifthAnswer == -1) || (sixthAnswer == -1) || (seventhAnswer == -1)){
            Context context = getApplicationContext();
            CharSequence text = "You have not answered all the questions!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else{
            switch(firstAnswer) {
                case (R.id.answer_1_1):
                    slytherinPoints++;
                    break;
                case (R.id.answer_1_2):
                    gryffindorPoints++;
                    break;
                case (R.id.answer_1_3):
                    hufflepuffPoints++;
                    break;
                case (R.id.answer_1_4):
                    ravenclawPoints++;
                    break;
            }
            switch(secondAnswer) {
                case (R.id.answer_2_4):
                    slytherinPoints++;
                    break;
                case (R.id.answer_2_1):
                    gryffindorPoints++;
                    break;
                case (R.id.answer_2_2):
                    hufflepuffPoints++;
                    break;
                case (R.id.answer_2_3):
                    ravenclawPoints++;
                    break;
            }
            switch(thirdAnswer) {
                case (R.id.answer_3_3):
                    slytherinPoints++;
                    break;
                case (R.id.answer_3_1):
                    gryffindorPoints++;
                    break;
                case (R.id.answer_3_4):
                    hufflepuffPoints++;
                    break;
                case (R.id.answer_3_2):
                    ravenclawPoints++;
                    break;
            }
            switch(fourthAnswer) {
                case (R.id.answer_4_3):
                    slytherinPoints++;
                    break;
                case (R.id.answer_4_4):
                    gryffindorPoints++;
                    break;
                case (R.id.answer_4_2):
                    hufflepuffPoints++;
                    break;
                case (R.id.answer_4_1):
                    ravenclawPoints++;
                    break;
            }
            switch(fifthAnswer) {
                case (R.id.answer_5_2):
                    slytherinPoints++;
                    break;
                case (R.id.answer_5_4):
                    gryffindorPoints++;
                    break;
                case (R.id.answer_5_3):
                    hufflepuffPoints++;
                    break;
                case (R.id.answer_5_1):
                    ravenclawPoints++;
                    break;
            }
            switch(sixthAnswer) {
                case (R.id.answer_6_2):
                    slytherinPoints++;
                    break;
                case (R.id.answer_6_1):
                    gryffindorPoints++;
                    break;
                case (R.id.answer_6_3):
                    hufflepuffPoints++;
                    break;
                case (R.id.answer_6_4):
                    ravenclawPoints++;
                    break;
            }
            switch(seventhAnswer) {
                case (R.id.answer_7_2):
                    slytherinPoints++;
                    break;
                case (R.id.answer_7_3):
                    gryffindorPoints++;
                    break;
                case (R.id.answer_7_4):
                    hufflepuffPoints++;
                    break;
                case (R.id.answer_7_1):
                    ravenclawPoints++;
                    break;
            }
        }
        if((gryffindorPoints > ravenclawPoints) && (gryffindorPoints > hufflepuffPoints) && (gryffindorPoints > slytherinPoints))
            displayResult(gryffindorID);
        else if((slytherinPoints > ravenclawPoints) && (slytherinPoints > gryffindorPoints) && (slytherinPoints > hufflepuffPoints))
            displayResult(slytherinID);
            else if((hufflepuffPoints > ravenclawPoints) && (hufflepuffPoints > gryffindorPoints ) && (hufflepuffPoints > slytherinPoints))
                displayResult(hufflepuffID);
                else if((ravenclawPoints > hufflepuffPoints) && (ravenclawPoints > gryffindorPoints ) && (ravenclawPoints > slytherinPoints))
                    displayResult(ravenclawID);
                    else
                    displayResult(staleID);
    }

    public void displayResult(int houseID) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.result);
        dialog.getWindow().setBackgroundDrawableResource(R.color.colorBackground);

        final EditText nameText = (EditText) findViewById(R.id.wizard_name);
        String name = nameText.getText().toString();

        houseImage = (ImageView) dialog.findViewById(R.id.house_image);
        houseName = (TextView) dialog.findViewById(R.id.house_name);
        houseDescription = (TextView) dialog.findViewById(R.id.house_description);

        Button dialogButton = (Button) dialog.findViewById(R.id.reset_button);
        dialogButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                question1.clearCheck();
                question2.clearCheck();
                question3.clearCheck();
                question4.clearCheck();
                question5.clearCheck();
                question6.clearCheck();
                question7.clearCheck();
                nameText.clearComposingText();
                dialog.dismiss();
            }
        });

        switch (houseID) {
            case 1:
                houseImage.setImageResource(R.drawable.gryffindor);
                houseName.setText(name + ", " + getString(gryffindor));
                houseDescription.setText(getString(gryffindor_des));
                dialog.show();
                break;
            case 2:
                houseImage.setImageResource(R.drawable.ravenclaw);
                houseName.setText(name + ", " + getString(ravenclaw));
                houseDescription.setText(getString(ravenclaw_des));
                dialog.show();
                break;
            case 3:
                houseImage.setImageResource(R.drawable.hufflepuff);
                houseName.setText(name + ", " + getString(R.string.hufflepuff));
                houseDescription.setText(getString(hufflepuff_des));
                dialog.show();
                break;
            case 4:
                houseImage.setImageResource(R.drawable.slytherin);
                houseName.setText(name + ", " + getString(R.string.slytherin));
                houseDescription.setText(getString(slytherin_des));
                dialog.show();
                break;
            case 5:
                houseImage.setVisibility(View.GONE);
                houseName.setText(name + ", " + getString(R.string.stale));
                houseDescription.setText(getString(R.string.stale_des));
                dialog.show();
                break;
        }
    }
    public void sendMail(View view) {
        String subject = "My Hogwarts House!";
        String text = "Hello, take a look at my Hogwarts House, isn't it great? " + "\n\n" + houseName.getText() + "\n\n" + houseDescription.getText();

    //Create a send intent
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        sendIntent.putExtra(Intent.EXTRA_TEXT, text);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }


}
