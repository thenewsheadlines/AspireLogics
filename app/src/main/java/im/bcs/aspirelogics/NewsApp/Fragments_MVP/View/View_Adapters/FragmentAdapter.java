package im.bcs.aspirelogics.NewsApp.Fragments_MVP.View.View_Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import im.bcs.aspirelogics.NewsApp.Fragments_MVP.View.View_Fragments.Global_Fragment;
import im.bcs.aspirelogics.NewsApp.Fragments_MVP.View.View_Fragments.Sport_Fragment;
import im.bcs.aspirelogics.NewsApp.Fragments_MVP.View.View_Fragments.Tec_Fragment;

/**
 * Created by Opriday on 7/2/2018.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    int count;
    String tag = "FragmentAdapter";
    public FragmentAdapter(FragmentManager fm, int count) {
        super(fm);
        this.count = count;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Global_Fragment();
        }else if (position == 1){
            return new Tec_Fragment();
        }
        else if ( position== 2){
            return new Sport_Fragment();
        }
        return  null;
    }

    @Override
    public int getCount() {
        return count;
    }
}
