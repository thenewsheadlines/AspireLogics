package im.bcs.aspirelogics.NewsApp.Fragments_MVP.View.View_Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import im.bcs.aspirelogics.R;

/**
 * Created by Opriday on 6/29/2018.
 */

public class ListViewAdapter extends ArrayAdapter{

    Context context;
    int[] icons;
    String[] titles;


    public ListViewAdapter(Context context, int[] icons, String[] titles) {
        super(context,R.layout.custom_drawer_list);
        this.context = context;
        this.icons = icons;
        this.titles = titles;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_drawer_list,parent,false);
        }
        ImageView image = (ImageView) convertView.findViewById(R.id.drawer_image);
        TextView title = (TextView) convertView.findViewById(R.id.drawer_title);
        image.setImageResource(icons[position]);
        title.setText(titles[position]);
        return convertView;
    }
}
