package com.example.STAYHOME;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

  int mNumOfTabs;

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    com.example.STAYHOME.TabFragement1Activity tab1 = new com.example.STAYHOME.TabFragement1Activity();
                    return tab1;
                case 1:
                    com.example.STAYHOME.TabFragement2Activity tab2 = new com.example.STAYHOME.TabFragement2Activity();
                    return tab2;
                case 2:
                    com.example.STAYHOME.TabFragement3Activity tab3 = new com.example.STAYHOME.TabFragement3Activity();
                    return tab3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }

