package im.bcs.aspirelogics.NewsApp.Fragments_MVP.View.View_Interfaces;

import android.support.design.widget.TabLayout;

import im.bcs.aspirelogics.NewsApp.Fragments_MVP.View.View_Adapters.FragmentAdapter;

/**
 * Created by Opriday on 7/2/2018.
 */

public interface I_TAB_View {
    public void getNewTab(TabLayout.Tab tab);
    public void getFragmentAdapter(FragmentAdapter adapter);

}
