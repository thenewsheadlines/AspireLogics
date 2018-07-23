package im.bcs.aspirelogics.NewsApp.Fragments_MVP.Model;

import android.content.Context;
import android.support.design.widget.TabLayout;

/**
 * Created by Opriday on 7/2/2018.
 */

public class TAB_Model implements I_TAB_Model{

    Context context;
    TabLayout tabLayout;

    public TAB_Model(){

    }

    public TAB_Model(TabLayout tabLayout) {
        this.tabLayout = tabLayout;
    }


    @Override
    public TabLayout.Tab onCreateNewTab(String title, int tag) {
        TabLayout.Tab tab = tabLayout.newTab();

        if(tag == 0) {
            tab.setText(title);
            tab.setTag(tag);
            return tab;
        }else if(tag == 1){
            tab.setText(title);
            tab.setTag(tag);
            return tab;
        }else if (tag == 2){
            tab.setText(title);
            tab.setTag(tag);
            return tab;
        }
        return null;
    }
}
