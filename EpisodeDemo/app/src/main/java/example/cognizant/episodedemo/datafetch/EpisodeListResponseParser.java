package example.cognizant.episodedemo.datafetch;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import example.cognizant.episodedemo.model.Episode;

/**
 * Created by spathinathan on 2/4/16.
 * This class parses the Episode List JSON response and returns an ArrayList of Episode object
 */
public class EpisodeListResponseParser {

    private static final String TAG = "EpisodeListResponse";

    /**
     * Converts JSON response to ArrayList of Episode object
     * @param jsonResponse JSON response String
     * @return Returns ArrayList of {@link example.cognizant.episodedemo.model.Episode}
     */
    public static ArrayList<Episode> parseEpisodeListJson(String jsonResponse){

        ArrayList<Episode> episodeList = new ArrayList<>();

        try {
            JSONObject root = new JSONObject(jsonResponse);
            String showTitle = root.getString("Title");
            String season = root.getString("Season");

            JSONArray episodeListJson = root.getJSONArray("Episodes");

            for(int i = 0; i < episodeListJson.length();i++){
                Episode episodeObj = new Episode();
                JSONObject episodeJson = (JSONObject)episodeListJson.get(i);
                episodeObj.setTitle(episodeJson.getString("Title"));
                episodeObj.setEpisodeNumber(episodeJson.getString("Episode"));
                episodeObj.setImdbId(episodeJson.getString("imdbID"));
                episodeObj.setImdbRating(episodeJson.getString("imdbRating"));
                episodeObj.setReleasedDate(episodeJson.getString("Released"));
                episodeList.add(episodeObj);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(TAG, "Error when parsing Episode List Response: [Error Message]"+e.getMessage());
        }

        return episodeList;
    }

}
