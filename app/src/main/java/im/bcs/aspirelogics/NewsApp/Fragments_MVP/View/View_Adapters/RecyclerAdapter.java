package im.bcs.aspirelogics.NewsApp.Fragments_MVP.View.View_Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import im.bcs.aspirelogics.NewsApp.Fragments_MVP.View.Browser;
import im.bcs.aspirelogics.NewsApp.Fragments_MVP.Model.News_Model;
import im.bcs.aspirelogics.R;

/**
 * Created by Opriday on 6/28/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHolder> {

    Context context;
    List<News_Model> articles;
    News_Model getArticle;
    Typeface font;
    SimpleDateFormat sdf;
    RecyclerView recyclerView;
    Activity activity; // for fragment use getActivity object instead of context. It can lead crashes
    public RecyclerAdapter(Context context, List<News_Model> articles, RecyclerView recyclerView,Activity activity) {
        this.articles = articles;
        this.context = context;
        this.recyclerView = recyclerView;
        this.activity=activity;
        //     font = Typeface.create("Shrikhand-Regular.ttf",Typeface.NORMAL);
        sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT/UTC + 5h"));
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.newsitem, viewGroup, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyHolder Holder, int position) {
        getArticle = articles.get(position);
        if (getArticle.getImageUrl() == null || getArticle.getImageUrl().contentEquals("")) {
            Holder.image.setImageResource(R.mipmap.ic_launcher);
        } else {
            Picasso.get().load(getArticle.getImageUrl()).fit().into(Holder.image);
        }
        //    Holder.title.setTypeface(font);
        if (getArticle.getTitle().length() > 80) {
            String subTitle = getArticle.getTitle().substring(0, 80);
            subTitle = subTitle + "...";
            Holder.title.setText(subTitle);
        } else {
            Holder.title.setText(getArticle.getTitle());
        }
        // setting time.
        try {
            Date d = sdf.parse(getArticle.getTime());
            Log.i("check", "time:" + d.getTime());
            CharSequence str = DateUtils.getRelativeDateTimeString(context, d.getTime(), DateUtils.MINUTE_IN_MILLIS, DateUtils.WEEK_IN_MILLIS, 0);
            String mTime = str.toString();
            mTime = mTime.substring(0,mTime.indexOf(","));
            Holder.time.setText(mTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Holder.source.setText(getArticle.getSource());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView title;
        TextView source;
        TextView time;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
            source = (TextView) itemView.findViewById(R.id.source);
            time = (TextView) itemView.findViewById(R.id.time);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            int position = recyclerView.getChildPosition(v);
            String url = articles.get(position).getNewsUrl();
            Intent browser = new Intent(activity,Browser.class);
            browser.putExtra("url",url);
            activity.startActivity(browser);
        }
    }
}
