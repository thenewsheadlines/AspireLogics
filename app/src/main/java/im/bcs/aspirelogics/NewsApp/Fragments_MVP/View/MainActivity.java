package im.bcs.aspirelogics.NewsApp.Fragments_MVP.View;

import android.graphics.Color;
import android.os.Build;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import im.bcs.aspirelogics.NewsApp.Fragments_MVP.View.View_Adapters.FragmentAdapter;
import im.bcs.aspirelogics.NewsApp.Fragments_MVP.View.View_Adapters.ListViewAdapter;
import im.bcs.aspirelogics.NewsApp.Fragments_MVP.View.View_Adapters.RecyclerAdapter;
import im.bcs.aspirelogics.NewsApp.Fragments_MVP.Presenter.TAB_Presenter;
import im.bcs.aspirelogics.NewsApp.Fragments_MVP.View.View_Interfaces.I_TAB_View;
import im.bcs.aspirelogics.R;

public class MainActivity extends AppCompatActivity implements I_TAB_View{

    String api = "dd48d8a8a193404e99e77ab62008bf48";
    String[] titles = {"BBC","Euronews","Aljazeera","Sky","ESPN","Ten Sport"};
    String[] tab_title = {"GLOBAL","TEC","SPORT"};
    int[] icons = {R.drawable.source_24dp,R.drawable.source_24dp,R.drawable.source_24dp,R.drawable.source_24dp,R.drawable.source_24dp,R.drawable.source_24dp,R.drawable.source_24dp};

    String JSON_ARRAY_KEY = "articles";
    String TITLE_KEY = "title";
    String IMAGE_KEY = "urlToImage";
    String TIME_KEY = "publishedAt";
    String SOURCE_KEY = "name";
    String NEWS_URL_KEY = "url";
    RecyclerAdapter adapter;

    ListView listView;

    DrawerLayout drawerLayout;
    ListAdapter listAdapter;
    ActionBarDrawerToggle actionBarDrawerToggle;
    TabLayout tabLayout;
    ViewPager viewPager;
    String tag = "TabAcitivty";
    FragmentAdapter fragmentAdapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbarLL);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        getSupportActionBar().setHomeButtonEnabled(true);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            getWindow().setStatusBarColor(Color.TRANSPARENT);
//            Window window = getWindow();
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//         //   window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

// setting of drawer layout...
        listView = (ListView) findViewById(R.id.left_drawer);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        listAdapter = new ListViewAdapter(this,icons,titles);
        listView.setAdapter(listAdapter);
// ActionBarDrawerToggle manage to open and close drawerlayout...
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Drawer Open");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle("Drawer Close");
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        TAB_Presenter TABPresenter = new TAB_Presenter(tabLayout,this,getSupportFragmentManager());
        TABPresenter.createNewTab("GLOBAL",0);
        TABPresenter.createNewTab("SPORT",1);
        TABPresenter.createNewTab("TEC",2);
        TABPresenter.createFragmentAdapter(tabLayout.getTabCount());
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        setTabTilteStyle(tabLayout);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.tabIndicator));
        if (fragmentAdapter != null)
            viewPager.setAdapter(fragmentAdapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setTabTilteStyle(TabLayout tabLayout) {
        for (int i= 0; i<tabLayout.getTabCount(); i++){
            TextView tv = (TextView) LayoutInflater.from(MainActivity.this).inflate(R.layout.tab_title_style,null);
            tv.setText(tab_title[i]);
            tabLayout.getTabAt(i).setCustomView(tv);
        }
    }

    @Override
    public void getNewTab(TabLayout.Tab tab) {
        tabLayout.addTab(tab);
    }

    @Override
    public void getFragmentAdapter(FragmentAdapter adapter) {
        this.fragmentAdapter = adapter;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.about) {
            Log.i(tag, "about selected.");
            return true;
        } else if (item.getItemId() == android.R.id.home) {
            if(!drawerLayout.isDrawerOpen(GravityCompat.START)) {
                Log.i(tag, "Drawer opened.");
                drawerLayout.openDrawer(Gravity.LEFT); //gravity - Gravity.LEFT to move the left drawer or Gravity.RIGHT for the right. GravityCompat.START or GravityCompat.END may also be used.
                return true;
            }else {
                Log.i(tag,"Drawer closed.");
                drawerLayout.closeDrawer(Gravity.LEFT);
                return true;
            }
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        actionBarDrawerToggle.syncState();
    }

}
