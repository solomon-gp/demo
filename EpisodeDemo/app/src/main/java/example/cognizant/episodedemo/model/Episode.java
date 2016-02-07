package example.cognizant.episodedemo.model;

import java.io.Serializable;

/**
 * Created by spathinathan on 2/4/16.
 *
 * This model class contains the properties of an Episode. This class will act as a base class for
 * the episode details class.
 */
public class Episode implements Serializable{

    /**
     * Release Date of the Episode.
     */
    private String releasedDate;

    /**
     * Title of the Episode.
     */
    private String title;

    /**
     * Episode number which will be a number.
     */
    private String episodeNumber;

    /**
     * Rating of the episode. Value will be from 0 to 10 with decimals.
     */
    private String imdbRating;

    /**
     * IMDB Id which will uniquely identify identify an episode. This is an alpha numeric id.
     */
    private String imdbId;

    public String getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(String releasedDate) {
        this.releasedDate = releasedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(String episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }
}
