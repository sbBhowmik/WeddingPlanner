package com.rupik.weddingplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.vstechlab.easyfonts.EasyFonts;

public class EngagementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engagement);

        TextView titleText = (TextView)findViewById(R.id.engagementTextView);
        titleText.setTypeface(EasyFonts.caviarDreamsBold(this));
    }
}
