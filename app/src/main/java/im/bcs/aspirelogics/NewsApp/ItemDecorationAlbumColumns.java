package im.bcs.aspirelogics.NewsApp;

/**
 * Created by Opriday on 4/30/2018.
 */

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ItemDecorationAlbumColumns extends RecyclerView.ItemDecoration {

    private int mItemOffset;

    public ItemDecorationAlbumColumns(int itemOffset) {
        mItemOffset = itemOffset;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
    }
}