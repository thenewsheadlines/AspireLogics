package im.bcs.aspirelogics.NewsApp.Fragments_MVP.Presenter;

import android.support.v7.widget.RecyclerView;

import java.util.List;

import im.bcs.aspirelogics.NewsApp.Fragments_MVP.Model.News_Model;

/**
 * Created by Opriday on 7/3/2018.
 */

public interface I_Fragment_Presenter {

    public void createAndSetRecyclerAdapter(List<News_Model> getArticles);
    public void createNetworkRequest(String Url);
    public void setAnimationToRecyclerView(RecyclerView recyclerView);

}
