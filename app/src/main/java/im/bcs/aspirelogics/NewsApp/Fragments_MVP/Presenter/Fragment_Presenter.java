package im.bcs.aspirelogics.NewsApp.Fragments_MVP.Presenter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import im.bcs.aspirelogics.NewsApp.Fragments_MVP.Model.News_Model;
import im.bcs.aspirelogics.NewsApp.Fragments_MVP.View.View_Interfaces.I_Fragment_View;
import im.bcs.aspirelogics.NewsApp.Fragments_MVP.View.View_Adapters.RecyclerAdapter;
import im.bcs.aspirelogics.R;

/**
 * Created by Opriday on 7/3/2018.
 */

public class Fragment_Presenter implements I_Fragment_Presenter{

    I_Fragment_View fragment_view;
    Context context;
    String tag = "Fragment_Presenter";
    String JSON_ARRAY_KEY = "articles";
    String TITLE_KEY = "title";
    String IMAGE_KEY = "urlToImage";
    String TIME_KEY = "publishedAt";
    String SOURCE_KEY = "name";
    String NEWS_URL_KEY = "url";
    List<News_Model> getArticles;
    LayoutAnimationController animationController;
    Activity activity;

    public Fragment_Presenter(I_Fragment_View fragment_view, Context context,Activity activity) {
        this.fragment_view = fragment_view;
        this.context = context;
        this.activity=activity;
    }


    @Override
    public void createNetworkRequest(String url) {

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
              getArticles = parsingJsonRequest(response);
              createAndSetRecyclerAdapter(getArticles);
              setAnimationToRecyclerView(fragment_view.getRecyclerViewObject());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(tag, "Error:" + error.toString());
            }
        });
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(objectRequest);
    }

    public  List<News_Model> parsingJsonRequest(JSONObject response) {
        List<News_Model> articles = new ArrayList<>();
        try {
            JSONArray jsonArray = response.getJSONArray(JSON_ARRAY_KEY);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                JSONObject mSource = object.getJSONObject("source");
                String getSource = mSource.getString(SOURCE_KEY);
                String getImage = object.getString(IMAGE_KEY);
                String getTitle = object.getString(TITLE_KEY);
                String getTime = object.getString(TIME_KEY);
                String getNewsUrl = object.getString(NEWS_URL_KEY);
                Log.i(tag, "imageUrl:" + getImage + "\nTitle:" + getTitle + "\nTime:" + getTime + "\nSource:" + getSource + "\nNewsUrl:" + getNewsUrl);
                articles.add(new News_Model(getImage, getNewsUrl, getTitle, getSource, getTime));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return articles;
    }

    @Override
    public void createAndSetRecyclerAdapter(List<News_Model> getArticles) {
        RecyclerAdapter adapter = new RecyclerAdapter(context,getArticles,fragment_view.getRecyclerViewObject(),activity);
        fragment_view.getRecyclerViewObject().setAdapter(adapter);
    }

    @Override
    public void setAnimationToRecyclerView(RecyclerView recyclerView) {
        animationController = AnimationUtils.loadLayoutAnimation(context, R.anim.layoutanimation);
        recyclerView.setLayoutAnimation(animationController);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();

    }

}
