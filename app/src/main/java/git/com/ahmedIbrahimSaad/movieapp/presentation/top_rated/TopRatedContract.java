package git.com.ahmedIbrahimSaad.movieapp.presentation.top_rated;


import java.util.List;

import git.com.ahmedIbrahimSaad.movieapp.data.retrive_top_rated.new_model.ResultsItem;
import git.com.ahmedIbrahimSaad.movieapp.data.GenerericResponseModel;
import git.com.ahmedIbrahimSaad.movieapp.presentation.base.BasePresenter;
import git.com.ahmedIbrahimSaad.movieapp.presentation.base.BaseView;

public interface TopRatedContract {
    interface TopRatedPresenter extends BasePresenter {
        void retriveTopRatedMovies();
    }
    interface TopRatedView extends BaseView<TopRatedPresenter> {
        void onRetriveTopRatedMoviesSuccess(List<ResultsItem> movies);
        void ononRetriveTopRatedMoviesFail(GenerericResponseModel generericResponseModel);
    }

}
