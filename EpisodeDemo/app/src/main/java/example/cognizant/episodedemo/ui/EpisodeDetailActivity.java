package example.cognizant.episodedemo.ui;

import android.os.Bundle;
import android.view.View;

import example.cognizant.episodedemo.R;

/**
 * This class houses the {@link EpisodeDetailFragment}
 */
public class EpisodeDetailActivity extends EpisodeBaseActivity {

    private String imdbId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle imdbIdBundle = getIntent().getExtras().getBundle(EpisodeListFragment.IMDB_ID);
        String imdbId = imdbIdBundle.getString(EpisodeListFragment.IMDB_ID);

        setImdbId(imdbId);

        setContentView(R.layout.activity_episode_detail);
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    @Override
    public void onToolBarMenuItemClicked(View view) {
        switch(view.getId()){
            case R.id.menuItemBack:
                //onBackPressed();
                finish();
                break;
            case R.id.menuItemHome:
                break;
            case R.id.menuItemList:

                break;
        }

    }
}
