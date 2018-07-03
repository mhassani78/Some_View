package com.example.maryam.someview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SeekBar seekBarAge=(SeekBar)findViewById(R.id.seekBarAge);
        final TextView textViewAge=(TextView)findViewById(R.id.textViewAge);
        seekBarAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int age=0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                age=i;
                textViewAge.setText(age);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (age<0)
                    age=0;
                seekBarAge.setProgress(age);
            }
        });


        Button buttonSave=(Button) findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextname=(EditText)findViewById(R.id.editTextname);
                RadioButton radioMale,radioFemale;
                radioMale=(RadioButton)findViewById(R.id.radioMale);
                radioFemale=(RadioButton)findViewById(R.id.radioFemale);

                CheckBox checkBoxNet=(CheckBox)findViewById(R.id.checkboxNet);
                CheckBox checkBoxDelphi=(CheckBox)findViewById(R.id.checkboxDelphi);
                CheckBox checkBoxAndroid=(CheckBox)findViewById(R.id.checkboxAndroid);
                EditText editTextRating=(EditText)findViewById(R.id.editTextRating);
                RatingBar ratingBarRating=(RatingBar)findViewById(R.id.ratingBarRating);

                TextView textViewFinal=(TextView) findViewById(R.id.textViewFinal);
                textViewFinal.setText("");
                String s="",sex="";
                if (radioFemale.isChecked()) sex="خانم" ; else sex="آقای";
                if (editTextname.getText().toString()!="")
                    s=sex+" "+editTextname.getText().toString();
                if (seekBarAge.getProgress()>0) 
                    s=s+" "+ (String.valueOf(seekBarAge.getProgress()))+"ساله";
                if (checkBoxAndroid.isChecked() || checkBoxDelphi.isChecked() || checkBoxNet.isChecked())
                {
                    s=s+" "+" علاقه مند به ";
                    if (checkBoxAndroid.isChecked()) s=s+" اندروید ";
                    if (checkBoxDelphi.isChecked()) s=s+" دلفی ";
                    if (checkBoxNet.isChecked()) s=s+" دات نت ";
                }
                textViewFinal.setText(s.toString());
                float rate=Float.parseFloat(editTextRating.getText().toString());
                if (rate>0) ratingBarRating.setRating(rate);
            }
        });
    }
}
