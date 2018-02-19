package com.example.bandaab.musicapp.UI.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bandaab.musicapp.Model.Search.MusicResponse;
import com.example.bandaab.musicapp.Presenter.SearchResult.SearchResultPresenter;
import com.example.bandaab.musicapp.R;
import com.example.bandaab.musicapp.UI.fragments.searchResult.ISearchResultView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bandaab on 1/18/18.
 */
public class SearchResultAdapter extends RecyclerView.Adapter implements ISearchResultView {
    private List<MusicResponse> resultsList = new ArrayList<>();
    private Context context;
    private SearchResultPresenter mSearchResultPresenter;

    public SearchResultAdapter(Context context, List<MusicResponse> resultsList) {
        this.context = context;
        this.resultsList = resultsList;
        mSearchResultPresenter =  new SearchResultPresenter(this);
    }

    public MusicResponse getItem(int position){
        return position < getItemCount() ? resultsList.get(position) : null;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View resultItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_result_item,parent,false);
        SearchResultViewHolder searchResultViewHolder = new SearchResultViewHolder(resultItemView);
        return searchResultViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MusicResponse item = getItem(position);
        if (item != null) {
            setupCapsule((SearchResultViewHolder) holder, item, position);
        }
    }

    protected <VH extends SearchResultViewHolder> void setupCapsule(final VH holder, MusicResponse item, int position) {
        holder.title.setText(item.getTrackName());
        setTrackImage(holder.tileImage, item.getArtworkUrl100());
//        holder.tileImage.setImageDrawable(LoadImageFromWebOperations(item.getArtworkUrl100()));
        holder.type.setText(item.getArtistName());
    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }

    @Override
    public void OnImageDownloadedSucess(ImageView imageView, Bitmap bitMapImage) {
        imageView.setImageBitmap(bitMapImage);
    }

    @Override
    public void OnImageDownloadedFail() {
        Toast.makeText(context,"OnImageDownloadedFail", Toast.LENGTH_SHORT).show();
    }

    public class SearchResultViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // each data item is just a string in this case
        protected TextView type;
        protected TextView title;
        protected ImageView tileImage;

        public SearchResultViewHolder(final View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
                itemView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        applyGradation(itemView);
                    }
                });
            tileImage = itemView.findViewById(R.id.tile_image);
            type = itemView.findViewById(R.id.tile_type);
            title = itemView.findViewById(R.id.tile_title);
        }

        @Override
        public void onClick(View v) {
            //Add click
            openDetail(getLayoutPosition());
        }
    }

    protected void setTrackImage(ImageView imageView, String url) {
        // Download Image in background
        mSearchResultPresenter.onImageDownload(imageView,url,context);
    }

    public void openDetail(int position) {
        MusicResponse clickItem = resultsList.get(position);
        Toast.makeText(context, clickItem.getCollectionName()+" : $"+clickItem.getCollectionPrice(),Toast.LENGTH_SHORT).show();
    }
    private void applyGradation(View rootView) {
        int height = rootView.getHeight();
        int gradationTop1Height, gradationTop2Height;
        View gradationTop1 = rootView.findViewById(R.id.gradation_top1);
        View gradationTop2 = rootView.findViewById(R.id.gradation_top2);

        gradationTop2Height = (int) (height * 0.4885f);
        gradationTop1Height = height - gradationTop2Height;

        gradationTop1.getLayoutParams().height = gradationTop1Height;
        gradationTop1.forceLayout();

        gradationTop2.getLayoutParams().height = gradationTop2Height;
        gradationTop2.forceLayout();
    }


}
