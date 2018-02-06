package com.appin.musicmaster.presentation;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.appin.musicmaster.R;
import com.appin.musicmaster.framework.BaseFragment;
import com.appin.musicmaster.framework.adapters.GridSpacingItemDecoration;
import com.appin.musicmaster.model.MusicResponse;
import com.appin.musicmaster.model.Response;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SearchResultsFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private Response response;
    private TextView errorText;
    private Button tryAgain;
    private List<MusicResponse> musicResponseList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_result_fragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        errorText = (TextView) view.findViewById(R.id.error_text);
        tryAgain = (Button) view.findViewById(R.id.try_again);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showMusicResponse();
        setListeners();
    }

    protected void showMusicResponse() {
        response = (Response) getActivity().getIntent().getSerializableExtra("SearchObject");
        musicResponseList = response.getResults();
        if (!musicResponseList.isEmpty()) {
            hideErrorMessage();
            final GridLayoutManager manager = new GridLayoutManager(SearchResultsFragment.this.getActivity(),2);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(manager);
            recyclerView.addItemDecoration(new GridSpacingItemDecoration(6));
            recyclerView.setAdapter(new SearchResultAdapter(SearchResultsFragment.this.getActivity(), musicResponseList));
        } else {
            // show error message when song tracks are not available
            showErrorMessage();
        }
    }

    protected void setListeners() {
        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go back to home Screen
                Intent i = new Intent(SearchResultsFragment.this.getActivity(), HomePageActivity.class);
                startActivity(i);
            }
        });
    }

    protected void hideErrorMessage() {
        errorText.setVisibility(View.GONE);
        tryAgain.setVisibility(View.GONE);
    }

    private void showErrorMessage() {
        errorText.setVisibility(View.VISIBLE);
        tryAgain.setVisibility(View.VISIBLE);
    }

    protected void setTrackImage(ImageView imageView, String url) {
        // Download Image in background
        new DownloadImageTask(imageView).execute(url);
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView trackImage;

        public DownloadImageTask(ImageView image) {
            this.trackImage = image;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap icon = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                icon = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return icon;
        }

        protected void onPostExecute(Bitmap result) {
            trackImage.setImageBitmap(result);
        }
    }


    public class SearchResultAdapter extends RecyclerView.Adapter {

        private List<MusicResponse> resultsList = new ArrayList<>();
        private Context context;

        public SearchResultAdapter(Context context, List<MusicResponse> resultsList) {
            this.context = context;
            this.resultsList = resultsList;
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
                tileImage = (ImageView) itemView.findViewById(R.id.tile_image);
                type = (TextView) itemView.findViewById(R.id.tile_type);
                title = (TextView) itemView.findViewById(R.id.tile_title);
            }

            @Override
            public void onClick(View v) {
                openDetail(getLayoutPosition());
            }
        }

        public MusicResponse getItem(int position) {
            return position < getItemCount() ? resultsList.get(position) : new MusicResponse();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View resultView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.search_result_item, parent, false);
            SearchResultViewHolder searchResultViewHolder = new SearchResultViewHolder(resultView);
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
            holder.type.setText(item.getArtistName());
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public int getItemCount() {
            return resultsList.size();
        }

        public void openDetail(int position) {
            MusicResponse response = musicResponseList.get(position);
            // Open lyrics when a song track is selected
            Intent intent = new Intent(SearchResultsFragment.this.getActivity(), LyricsActivty.class);
            intent.putExtra("artistName", response.getArtistName());
            intent.putExtra("song", response.getTrackName());
            startActivity(intent);

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
}
