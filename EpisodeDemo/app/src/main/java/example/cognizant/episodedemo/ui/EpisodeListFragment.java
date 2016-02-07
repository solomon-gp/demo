package example.cognizant.episodedemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

import example.cognizant.episodedemo.R;
import example.cognizant.episodedemo.datafetch.EpisodeListResponseParser;
import example.cognizant.episodedemo.model.Episode;
import example.cognizant.episodedemo.model.EpisodeListAdapter;

/**
 * This fragment displays the list of Episodes by calling the webservice with name and season number.
 * In case of an error, an alert dialog is shown.
 */
public class EpisodeListFragment extends ListFragment {

    private static final String TAG = "EpisodeListFragment";
    public static final String IMDB_ID = "IMDB_ID";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        //http://www.omdbapi.com/?t=Game%20of%20Thrones&amp;Season=1
        String url = getString(R.string.episode_list_url);

        final EpisodeBaseActivity baseActivity = (EpisodeBaseActivity)getActivity();
        baseActivity.showLoadingIndicator();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i(TAG,"Response Returned from Web Service");
                        ArrayList<Episode> episodeList = EpisodeListResponseParser.parseEpisodeListJson(response);

                        EpisodeListAdapter episodeListAdapter = new EpisodeListAdapter(getContext(),R.layout.episode_list_rowitem,episodeList);
                        setListAdapter(episodeListAdapter);
                        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String imdbId = view.getTag().toString();

                                Intent intent = new Intent(getContext(), EpisodeDetailActivity.class);
                                Bundle imdbIdBundle = new Bundle();
                                imdbIdBundle.putString(IMDB_ID, imdbId);

                                intent.putExtra(IMDB_ID, imdbIdBundle);
                                getContext().startActivity(intent);
                            }
                        });
                        baseActivity.hideLoadingIndicator();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                baseActivity.hideLoadingIndicator();
                EpisodeBaseActivity baseActivity = (EpisodeBaseActivity)getActivity();
                baseActivity.showErrorDialog(getString(R.string.errorAlertTitle),getString(R.string.errorMessage));
            }
        });
        queue.add(stringRequest);
    }

}
