package example.cognizant.episodedemo.model;

/**
 * Created by spathinathan on 2/4/16.
 *
 * This class models the details of the episodes. This class inherits some common properties from
 * {@link Episode} class.
 */
public class EpisodeDetails extends Episode {
    /**
     * Year of the episode
     */
    private String year;
    /**
     * Rating of the episode.
     */
    private String rated;
    /**
     * Season number of the episode. It is usually a number.
     */
    private String seasonNumber;

    /**
     * Run duration of the episode. It is usually in minutes.
     */
    private String runDuration;

    /**
     * Genre of the episode.
     */
    private String genre;
    /**
     * Director name of the episode. Multiple director names are comma separated.
     */
    private String director;

    /**
     * Name of the writer. Multiple writers are comma separated.
     */
    private String writer;

    /**
     * Name of the actor. Multiple actors are comma separated.
     */
    private String actor;
    /**
     * Plot explains the details. Usually it will be a lengthy string.
     */
    private String plot;

    /**
     * Language of the episode.
     */
    private String language;
    /**
     * Country of the episode.
     */
    private String country;

    /**
     * Awards received.
     */
    private String awards;
    /**
     * URL for the poster image.
     */
    private String poster;
    /**
     * Meta score of the episode.
     */
    private String metascore;
    /**
     * Number of viewer votes from IMDB. This is a number.
     */
    private int imdbVotes;
    /**
     * Id of the series. This is alphanumeric.
     */
    private String seriesId;
    /**
     * Type of the data. It will be episode for episode.
     */
    private String type;

    private String response;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(String seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public String getRunDuration() {
        return runDuration;
    }

    public void setRunDuration(String runDuration) {
        this.runDuration = runDuration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getMetascore() {
        return metascore;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public int getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(int imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
