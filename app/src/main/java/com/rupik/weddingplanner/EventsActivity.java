package com.rupik.weddingplanner;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;

import com.vstechlab.easyfonts.EasyFonts;

public class EventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        if(ab!=null) {
            ab.setDisplayHomeAsUpEnabled(true);

            Spannable text = new SpannableString("WEDDING EVENTS");
            text.setSpan(new ForegroundColorSpan(Color.parseColor("#9966ff")), 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

            Typeface font  = EasyFonts.caviarDreamsBold(this);
            text.setSpan (new CustomTypefaceSpan("", font), 0, text.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
            ab.setTitle(text);
        }

        Button eventEngagementBtn = (Button)findViewById(R.id.eventEngagementBtn);
        eventEngagementBtn.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button mehendiBtn = (Button)findViewById(R.id.mehendiBtn);
        mehendiBtn.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button sangeetBtn = (Button)findViewById(R.id.sangeetBtn);
        sangeetBtn.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button AiburobhatBtn = (Button)findViewById(R.id.AiburobhatBtn);
        AiburobhatBtn.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button GayeHoludBtn = (Button)findViewById(R.id.GayeHoludBtn);
        GayeHoludBtn.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button BiyeBtn = (Button)findViewById(R.id.BiyeBtn);
        BiyeBtn.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button BashorBtn = (Button)findViewById(R.id.BashorBtn);
        BashorBtn.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button VidaiBtn = (Button)findViewById(R.id.VidaiBtn);
        VidaiBtn.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button KalratriBoronBtn = (Button)findViewById(R.id.KalratriBoronBtn);
        KalratriBoronBtn.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button BoubhatBtn = (Button)findViewById(R.id.BoubhatBtn);
        BoubhatBtn.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button ReceptionPartyBtn = (Button)findViewById(R.id.ReceptionPartyBtn);
        ReceptionPartyBtn.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button GroomReceptionPartyBtn = (Button)findViewById(R.id.GroomReceptionPartyBtn);
        GroomReceptionPartyBtn.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button SuhagraatBtn = (Button)findViewById(R.id.SuhagraatBtn);
        SuhagraatBtn.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button AshtamangalaBtn = (Button)findViewById(R.id.AshtamangalaBtn);
        AshtamangalaBtn.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button HoneymoonBtn = (Button)findViewById(R.id.HoneymoonBtn);
        HoneymoonBtn.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button DwiragamanBtn = (Button)findViewById(R.id.DwiragamanBtn);
        DwiragamanBtn.setTypeface(EasyFonts.caviarDreamsBold(this));

    }
}
