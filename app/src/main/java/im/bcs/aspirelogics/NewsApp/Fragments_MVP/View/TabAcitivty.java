package im.bcs.aspirelogics.NewsApp.Fragments_MVP.View;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import im.bcs.aspirelogics.NewsApp.Fragments_MVP.Presenter.TAB_Presenter;
import im.bcs.aspirelogics.NewsApp.Fragments_MVP.View.View_Adapters.FragmentAdapter;
import im.bcs.aspirelogics.NewsApp.Fragments_MVP.View.View_Interfaces.I_TAB_View;
import im.bcs.aspirelogics.R;

public class TabAcitivty extends AppCompatActivity   {
    TabLayout tabLayout;
    TabLayout.Tab tab1,tab2,tab3;
    ViewPager viewPager;
    String tag = "TabAcitivty";
    FragmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
//
//        tabLayout = (TabLayout) findViewById(R.id.tablayout);
//        viewPager = (ViewPager) findViewById(R.id.viewPager);
//        TAB_Presenter TABPresenter = new TAB_Presenter(tabLayout,this,getSupportFragmentManager());
//
//        TABPresenter.createNewTab("GLOBAL",0);
//        TABPresenter.createNewTab("SPORT",1);
//        TABPresenter.createNewTab("TEC",2);
//
//        TABPresenter.createFragmentAdapter(tabLayout.getTabCount());
//        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.tabIndicator));
//        if (adapter != null)
//        viewPager.setAdapter(adapter);
//        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//
//    }
//    @Override
//    public void getNewTab(TabLayout.Tab tab) {
//        tabLayout.addTab(tab);
//    }
//
//    @Override
//    public void getFragmentAdapter(FragmentAdapter adapter) {
//        this.adapter = adapter;
    }


}
