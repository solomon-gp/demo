package example.cognizant.episodedemo.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import example.cognizant.episodedemo.R;
import example.cognizant.episodedemo.datafetch.EpisodeDetailResponseParser;
import example.cognizant.episodedemo.model.EpisodeDetails;

/**
 * This fragment displays the details of an episode given the IMDB Id. IMDB Id is passed from the
 * Episode list fragment. A web service call is made to get the list of episodes based on the IMDB ID.
 */
public class EpisodeDetailFragment extends Fragment {

    /**
     * ImDB Id to get the episode detail.
     */
    private String imDBId;

    /**
     * Method to get IMDB id.
     * @return Returns the IMDB Id
     */
    public String getImDBId() {
        return imDBId;
    }

    /**
     * Method to set IMDB Id to the Fragment class.
     * @param imDBId IMDB Id to be set in the Fragment class.
     */
    public void setImDBId(String imDBId) {
        this.imDBId = imDBId;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        EpisodeDetailActivity detailActivity = (EpisodeDetailActivity)getActivity();
        setImDBId(detailActivity.getImdbId());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        //http://www.omdbapi.com/?plot=short&amp;r=json&amp;i=
        String url = getString(R.string.episode_detail_url)+getImDBId();


        final EpisodeBaseActivity baseActivity = (EpisodeBaseActivity)getActivity();
        baseActivity.showLoadingIndicator();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        EpisodeDetails episodeDetails = EpisodeDetailResponseParser.parseEpisodeDetails(response);

                        if(episodeDetails != null) {
                            TextView valYear = (TextView) getActivity().findViewById(R.id.valYear);
                            valYear.setText(episodeDetails.getYear());

                            TextView valRated = (TextView) getActivity().findViewById(R.id.valRated);
                            valRated.setText(episodeDetails.getRated());

                            TextView valReleased = (TextView) getActivity().findViewById(R.id.valReleased);
                            valReleased.setText(episodeDetails.getReleasedDate());

                            TextView valSeason = (TextView) getActivity().findViewById(R.id.valSeason);
                            valSeason.setText(episodeDetails.getSeasonNumber());

                            TextView valEpisode = (TextView) getActivity().findViewById(R.id.valEpisode);
                            valEpisode.setText(episodeDetails.getEpisodeNumber());

                            TextView valRuntime = (TextView) getActivity().findViewById(R.id.valRuntime);
                            valRuntime.setText(episodeDetails.getRunDuration());

                            getActivity().setTitle(episodeDetails.getTitle());
                            baseActivity.hideLoadingIndicator();
                        }else{
                            baseActivity.showErrorDialog(getString(R.string.errorAlertTitle),getString(R.string.errorMessage));
                            baseActivity.hideLoadingIndicator();
                        }

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                baseActivity.hideLoadingIndicator();
                baseActivity.showErrorDialog(getString(R.string.errorAlertTitle),getString(R.string.errorMessage));
            }
        });
        queue.add(stringRequest);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_episode_detail, container, false);
    }

}
