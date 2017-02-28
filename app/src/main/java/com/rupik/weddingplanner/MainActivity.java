package com.rupik.weddingplanner;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.ikimuhendis.ldrawer.ActionBarDrawerToggle;
import com.ikimuhendis.ldrawer.DrawerArrowDrawable;
import com.vstechlab.easyfonts.EasyFonts;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerArrowDrawable drawerArrow;
    private boolean drawerArrowColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        android.support.v7.app.ActionBar ab = getSupportActionBar();
        if(ab!=null) {
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setHomeButtonEnabled(true);
            ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#e6f2ff")));
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.hamburger_icon_purple);
            Spannable text = new SpannableString(ab.getTitle());
            text.setSpan(new ForegroundColorSpan(Color.parseColor("#9966ff")), 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

            Typeface font  = EasyFonts.caviarDreamsBold(this);
            text.setSpan (new CustomTypefaceSpan("", font), 0, text.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
            ab.setTitle(text);
        }

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.navdrawer);

        drawerArrow = new DrawerArrowDrawable(this) {
            @Override
            public boolean isLayoutRtl() {
                return false;
            }
        };


        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                drawerArrow, R.string.drawer_open,
                R.string.drawer_close) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();

            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();


        String[] values = new String[]{
                "Events",
                "Tatta",
                "Wedding Dates",
                "Fun Ideas",
                "Destination Wedding",
                "Catering",
                "Important Contacts",
                "Notes",
                "Rate Us",
                "Share"
        };

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, values);
        MenuItemsAdapter adapter = new MenuItemsAdapter(this,values);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        mDrawerToggle.setAnimateEnabled(false);
                        drawerArrow.setProgress(1f);
                        break;
                    case 1:
                        mDrawerToggle.setAnimateEnabled(false);
                        drawerArrow.setProgress(0f);
                        break;
                    case 2:
                        mDrawerToggle.setAnimateEnabled(true);
                        mDrawerToggle.syncState();
                        break;
                    case 3:
                        if (drawerArrowColor) {
                            drawerArrowColor = false;
                            drawerArrow.setColor(R.color.ldrawer_color);
                        } else {
                            drawerArrowColor = true;
                            drawerArrow.setColor(R.color.drawer_arrow_second_color);
                        }
                        mDrawerToggle.syncState();
                        break;
                    case 4:
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/IkiMuhendis/LDrawer"));
                        startActivity(browserIntent);
                        break;
                    case 5:
                        Intent share = new Intent(Intent.ACTION_SEND);
                        share.setType("text/plain");
                        share.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        share.putExtra(Intent.EXTRA_SUBJECT,
                                getString(R.string.app_name));
                        share.putExtra(Intent.EXTRA_TEXT, getString(R.string.app_description) + "\n" +
                                "GitHub Page :  https://github.com/IkiMuhendis/LDrawer\n" +
                                "Sample App : https://play.google.com/store/apps/details?id=" +
                                getPackageName());
                        startActivity(Intent.createChooser(share,
                                getString(R.string.app_name)));
                        break;
                    case 6:
                        String appUrl = "https://play.google.com/store/apps/details?id=" + getPackageName();
                        Intent rateIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(appUrl));
                        startActivity(rateIntent);
                        break;
                }

            }
        });


        TextView titleText = (TextView)findViewById(R.id.titleText);
        titleText.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button eventsBtn = (Button)findViewById(R.id.eventsBtn);
        eventsBtn.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button shoppBtn = (Button)findViewById(R.id.shoppBtn);
        shoppBtn.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button cardDesignBtn = (Button)findViewById(R.id.cardDesignBtn);
        cardDesignBtn.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button guestListBtn = (Button)findViewById(R.id.guestListBtn);
        guestListBtn.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button fooBtn = (Button)findViewById(R.id.fooBtn);
        fooBtn.setTypeface(EasyFonts.caviarDreamsBold(this));


        populateEvents();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
                mDrawerLayout.closeDrawer(mDrawerList);
            } else {
                mDrawerLayout.openDrawer(mDrawerList);
            }
        }
        mDrawerToggle.syncState();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    ArrayList<Events> eventsArrayList = new ArrayList<>();
    void populateEvents()
    {
        Events event = new Events();
        event.setEventTitle("Engagement/Ashirbad");
        eventsArrayList.add(event);

        event = new Events();
        event.setEventTitle("Mehendi");
        eventsArrayList.add(event);

        event = new Events();
        event.setEventTitle("Aiburobhat");
        eventsArrayList.add(event);

        event = new Events();
        event.setEventTitle("Gaye Holud");
        eventsArrayList.add(event);

        event = new Events();
        event.setEventTitle("Bibaho");
        eventsArrayList.add(event);

        event = new Events();
        event.setEventTitle("Bashor");
        eventsArrayList.add(event);

        event = new Events();
        event.setEventTitle("Bidhai");
        eventsArrayList.add(event);

        event = new Events();
        event.setEventTitle("Kalratri Boron");
        eventsArrayList.add(event);

        event = new Events();
        event.setEventTitle("Bhat Kapor");
        eventsArrayList.add(event);

        event = new Events();
        event.setEventTitle("Boubhat");
        eventsArrayList.add(event);

        event = new Events();
        event.setEventTitle("Reception Party");
        eventsArrayList.add(event);

        event = new Events();
        event.setEventTitle("Suhaag Raat");
        eventsArrayList.add(event);

        event = new Events();
        event.setEventTitle("Dwiragamon");
        eventsArrayList.add(event);

        event = new Events();
        event.setEventTitle("Asthamangala");
        eventsArrayList.add(event);

        event = new Events();
        event.setEventTitle("Honeymoon");
        eventsArrayList.add(event);
    }
}
