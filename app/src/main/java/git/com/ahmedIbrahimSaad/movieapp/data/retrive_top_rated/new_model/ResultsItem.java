package git.com.ahmedIbrahimSaad.movieapp.data.retrive_top_rated.new_model;

import java.util.List;

public class ResultsItem{
	private String overview;
	private String originalLanguage;
	private String originalTitle;
	private boolean video;
	private String title;
	private List<Integer> genreIds;
	private String poster_path;
	private String backdrop_path;
	private String release_date;
	private double vote_average;
	private double popularity;
	private int id;
	private boolean adult;
	private int vote_count;

	public void setOverview(String overview){
		this.overview = overview;
	}

	public String getOverview(){
		return overview;
	}

	public void setOriginalLanguage(String originalLanguage){
		this.originalLanguage = originalLanguage;
	}

	public String getOriginalLanguage(){
		return originalLanguage;
	}

	public void setOriginalTitle(String originalTitle){
		this.originalTitle = originalTitle;
	}

	public String getOriginalTitle(){
		return originalTitle;
	}

	public void setVideo(boolean video){
		this.video = video;
	}

	public boolean isVideo(){
		return video;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setGenreIds(List<Integer> genreIds){
		this.genreIds = genreIds;
	}

	public List<Integer> getGenreIds(){
		return genreIds;
	}

	public void setPosterPath(String poster_Path){
		this.poster_path = poster_Path;
	}

	public String getPosterPath(){
		return poster_path;
	}

	public void setBackdropPath(String backdropPath){
		this.backdrop_path = backdropPath;
	}

	public String getBackdropPath(){
		return backdrop_path;
	}

	public void setReleaseDate(String releaseDate){
		this.release_date = releaseDate;
	}

	public String getReleaseDate(){
		return release_date;
	}

	public void setVoteAverage(double voteAverage){
		this.vote_average = voteAverage;
	}

	public double getVoteAverage(){
		return vote_average;
	}

	public void setPopularity(double popularity){
		this.popularity = popularity;
	}

	public double getPopularity(){
		return popularity;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAdult(boolean adult){
		this.adult = adult;
	}

	public boolean isAdult(){
		return adult;
	}

	public void setVoteCount(int voteCount){
		this.vote_count = voteCount;
	}

	public int getVoteCount(){
		return vote_count;
	}

	@Override
 	public String toString(){
		return 
			"ResultsItem{" + 
			"overview = '" + overview + '\'' + 
			",original_language = '" + originalLanguage + '\'' + 
			",original_title = '" + originalTitle + '\'' + 
			",video = '" + video + '\'' + 
			",title = '" + title + '\'' + 
			",genre_ids = '" + genreIds + '\'' + 
			",poster_path = '" + poster_path + '\'' +
			",backdrop_path = '" + backdrop_path + '\'' +
			",release_date = '" + release_date + '\'' +
			",vote_average = '" + vote_average + '\'' +
			",popularity = '" + popularity + '\'' + 
			",id = '" + id + '\'' + 
			",adult = '" + adult + '\'' + 
			",vote_count = '" + vote_count + '\'' +
			"}";
		}
}