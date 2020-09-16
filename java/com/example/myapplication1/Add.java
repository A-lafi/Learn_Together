package com.example.myapplication1;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import androidx.appcompat.app.AppCompatActivity;

import com.tutlane.loginexample.R;

import java.text.DateFormat;
import java.util.Calendar;

public class Add extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private TextView textView;
    private SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        Button share = (Button) findViewById(R.id.idShare);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Add.this, "shared successfully", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Add.this, Home.class);
                startActivity(intent);

            }
        });

        Button from = (Button) findViewById(R.id.from);
        ImageView home = (ImageView) findViewById (R.id.idHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Add.this, Home.class);
                startActivity(intent);

            }
        });
        from.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });
        Button to = (Button) findViewById(R.id.to);
        to.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());


         textView = (TextView) findViewById(R.id.textViwe);
         seekBar = (SeekBar) findViewById(R.id.seekBar);
         seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            textView.setText(progress + "Km");
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    });

    }}