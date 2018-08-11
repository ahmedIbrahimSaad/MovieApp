package git.com.ahmedIbrahimSaad.movieapp.data.retrive_top_rated;



import java.util.List;

import git.com.ahmedIbrahimSaad.movieapp.data.retrive_top_rated.new_model.ResultsItem;
import git.com.ahmedIbrahimSaad.movieapp.data.GenerericResponseModel;

public interface RetriveTopRatedDataSource {
    interface TopRatedMovieCallBack{
        void onRetriveSuccess(List<ResultsItem> movieList);
        void onRetriveError(GenerericResponseModel responseModel);
    }
    void retriveTopRatedMovies(TopRatedMovieCallBack callBack);
}
