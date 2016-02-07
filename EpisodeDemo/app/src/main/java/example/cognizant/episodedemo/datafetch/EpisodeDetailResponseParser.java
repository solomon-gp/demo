package example.cognizant.episodedemo.datafetch;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import example.cognizant.episodedemo.model.EpisodeDetails;

/**
 * Created by spathinathan on 2/4/16.
 *
 * This Class parses the Web Service JSON response and converts into a Java Object.
 */
public class EpisodeDetailResponseParser {

    private static final String TAG = "EpisodeDetailResponse";

    /**
     * This method converts a JSON String into {@link example.cognizant.episodedemo.model.EpisodeDetails}  java object
     * @param jsonResponse JSON response string from Web Service.
     * @return Returns an object of {@link example.cognizant.episodedemo.model.EpisodeDetails}
     */
    public static EpisodeDetails parseEpisodeDetails(String jsonResponse){

        EpisodeDetails episodeDetail = new EpisodeDetails();
        JSONObject root = null;
        try {
            root = new JSONObject(jsonResponse);


            episodeDetail.setTitle(root.getString("Title"));
            episodeDetail.setYear(root.getString("Year"));
            episodeDetail.setRated(root.getString("Rated"));
            episodeDetail.setReleasedDate(root.getString("Released"));
            episodeDetail.setEpisodeNumber(root.getString("Episode"));
            episodeDetail.setSeasonNumber(root.getString("Season"));
            episodeDetail.setRunDuration(root.getString("Runtime"));
            episodeDetail.setGenre(root.getString("Genre"));
            episodeDetail.setDirector(root.getString("Director"));
            episodeDetail.setWriter(root.getString("Writer"));
            episodeDetail.setActor(root.getString("Actors"));
            episodeDetail.setPlot(root.getString("Plot"));
            episodeDetail.setLanguage(root.getString("Language"));
            episodeDetail.setCountry(root.getString("Country"));
            episodeDetail.setAwards(root.getString("Awards"));
            episodeDetail.setPoster(root.getString("Poster"));
            episodeDetail.setMetascore(root.getString("Metascore"));
            episodeDetail.setImdbRating(root.getString("imdbRating"));
            episodeDetail.setImdbVotes(Integer.valueOf(root.getString("imdbVotes")));
            episodeDetail.setImdbId(root.getString("imdbID"));
            episodeDetail.setSeriesId(root.getString("seriesID"));
            episodeDetail.setType(root.getString("Type"));
            episodeDetail.setResponse(root.getString("Response"));


        } catch (JSONException e) {
            e.printStackTrace();
            episodeDetail = null;
            Log.e(TAG, "Error when parsing Episode Detail Response: [Error Message]" + e.getMessage());
        }

        return episodeDetail;
    }
}
