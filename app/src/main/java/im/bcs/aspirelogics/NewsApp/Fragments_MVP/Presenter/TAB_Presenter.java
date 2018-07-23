package im.bcs.aspirelogics.NewsApp.Fragments_MVP.Presenter;


import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.widget.TextView;

import im.bcs.aspirelogics.NewsApp.Fragments_MVP.Model.TAB_Model;
import im.bcs.aspirelogics.NewsApp.Fragments_MVP.View.MainActivity;
import im.bcs.aspirelogics.NewsApp.Fragments_MVP.View.View_Adapters.FragmentAdapter;
import im.bcs.aspirelogics.NewsApp.Fragments_MVP.View.View_Interfaces.I_TAB_View;
import im.bcs.aspirelogics.R;

/**
 * Created by Opriday on 7/2/2018.
 */

public class TAB_Presenter implements I_TAB_Presenter{
    Context context;
    TabLayout.Tab tab;
    TabLayout tabLayout;
    TAB_Model tab_model;
    I_TAB_View tab_view;
    FragmentManager fm;

    public TAB_Presenter(TabLayout tabLayout, I_TAB_View tab_view, FragmentManager fm) {
        this.tabLayout = tabLayout;
        this.tab_view = tab_view;
        this.fm = fm;
    }

    @Override
    public void createNewTab(String title, int tag) {
        tab_model = new TAB_Model(tabLayout);
        tab = tab_model.onCreateNewTab(title,tag);
        if(tab != null){
            tab_view.getNewTab(tab);
        }
    }

    @Override
    public void createFragmentAdapter(int count) {
        tab_view.getFragmentAdapter(new FragmentAdapter(fm,count));
    }


}
