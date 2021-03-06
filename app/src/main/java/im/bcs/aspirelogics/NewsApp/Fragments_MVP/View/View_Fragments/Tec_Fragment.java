package im.bcs.aspirelogics.NewsApp.Fragments_MVP.View.View_Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import im.bcs.aspirelogics.NewsApp.Fragments_MVP.Presenter.Fragment_Presenter;
import im.bcs.aspirelogics.NewsApp.Fragments_MVP.View.View_Interfaces.I_Fragment_View;
import im.bcs.aspirelogics.R;

public class Tec_Fragment extends Fragment implements I_Fragment_View {
    RecyclerView recyclerView;
    String api = "dd48d8a8a193404e99e77ab62008bf48";
    String Url = "https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=" + api;
    String tag = "Tec_Fragment";
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        {
            Log.i(tag, tag + " created");
            context = getActivity().getApplicationContext();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tec_, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.reyclerView);
        setRecyclerViewObject(recyclerView);
        Fragment_Presenter presenter = new Fragment_Presenter(this, context,getActivity());
        presenter.createNetworkRequest(Url);// passing url to presenter class, where whole task will execute and show list of data to recyclerview
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        return view;
    }

    @Override
    public void setRecyclerViewObject(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override
    public RecyclerView getRecyclerViewObject() {
        return recyclerView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(tag,tag+" fragment attached to activity");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(tag,tag+" fragment detached from activity");
    }
}
