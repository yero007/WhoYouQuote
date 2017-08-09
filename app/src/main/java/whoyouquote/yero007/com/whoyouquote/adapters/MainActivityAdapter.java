package whoyouquote.yero007.com.whoyouquote.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import whoyouquote.yero007.com.whoyouquote.mainActivityFragments.ProfileFragment;
import whoyouquote.yero007.com.whoyouquote.mainActivityFragments.ScoreBoardFragment;
import whoyouquote.yero007.com.whoyouquote.mainActivityFragments.SettingsFragment;
import whoyouquote.yero007.com.whoyouquote.mainActivityFragments.StartGameFragment;

public class MainActivityAdapter extends FragmentStatePagerAdapter {

    List<Fragment> fragments;

    public MainActivityAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
        fragments.add(new StartGameFragment());
        fragments.add(new ProfileFragment());
        fragments.add(new ScoreBoardFragment());
        fragments.add(new SettingsFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
