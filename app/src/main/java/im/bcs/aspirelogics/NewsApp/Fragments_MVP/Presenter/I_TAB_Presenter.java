package im.bcs.aspirelogics.NewsApp.Fragments_MVP.Presenter;

import android.support.design.widget.TabLayout;

/**
 * Created by Opriday on 7/2/2018.
 */

public interface I_TAB_Presenter {
    public void createNewTab(String title, int tag);
    public void createFragmentAdapter(int count);

}
