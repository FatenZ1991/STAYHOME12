package com.example.STAYHOME;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

/**
public class TabhomeActivity extends AppCompatActivity {
    private TabAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhome);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        //Faten
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabFragement1Activity(), "Tab 1");
        adapter.addFragment(new TabFragement2Activity(), "Tab 2");
        //
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}**/


public class TabhomeActivity extends AppCompatActivity {

 private TabAdapter adapter;
 private TabLayout tabLayout;
 private ViewPager viewPager;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_tabhome);
 viewPager = (ViewPager) findViewById(R.id.view_pager);
 tabLayout = (TabLayout) findViewById(R.id.tabs);
 adapter = new TabAdapter(getSupportFragmentManager());
 adapter.addFragment(new TabFragement1Activity(), "Inform Health Care");
 adapter.addFragment(new TabFragement2Activity(), "Send Code");
 viewPager.setAdapter(adapter);
 tabLayout.setupWithViewPager(viewPager);
        }
    }




