package com.example.abhinav.survey;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    public ViewPager mPager;
    public static final int Light=0;
    public static final int Transport=1;
    public static final int Education=2;
    public static final int Hospital=3;
    private MyPagerAdapter mAdapter;
//    int icons[]={R.drawable.ic_account_box,R.drawable.ic_action_phone_end};
String title[]={"Light Facility","Transport Facility","Education","Hospital Facility"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mPager = (ViewPager) findViewById(R.id.pager);
        TabLayout mTablayout = (TabLayout) findViewById(R.id.tab_layout);
        mPager.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        //DatabaseHandler handler=new DatabaseHandler(this);
        //handler.clearEvent();
        mTablayout.setupWithViewPager(mPager);
        mTablayout.setTabGravity(TabLayout.MODE_SCROLLABLE);
    }



    class MyPagerAdapter extends FragmentStatePagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {

            super(fm);
        }

        /**
         * Return the Fragment associated with a specified position.
         *
         * @param position
         */
        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
// for switching according to the fragment required
            switch (position) {
                case Light:
                    fragment = lightfacility.newInstance("", "");

                    break;
                case Transport:

                    fragment = transport.newInstance("", "");
                    break;
                case Education:

                    fragment = com.example.abhinav.survey.Education.newInstance("", "");
                    break;
                case Hospital:

                    fragment = hospital.newInstance("", "");
                    break;
            }
            return fragment;
        }
        public int getItemPosition(Object object){
            return POSITION_NONE;
        }

        /**
         * Return the number of views available.
         */
        @Override
        public CharSequence getPageTitle(int position) {

            SpannableString spannableString=new SpannableString(title[position]);// becoz we want only image
            return spannableString;
        }
        @Override
        public int getCount() {
            return 4;//we require 2 Tabs
        }
    }
}
