package git.com.ahmedIbrahimSaad.movieapp.domain;



import java.util.List;

import git.com.ahmedIbrahimSaad.movieapp.data.retrive_top_rated.new_model.ResultsItem;
import git.com.ahmedIbrahimSaad.movieapp.data.GenerericResponseModel;
import git.com.ahmedIbrahimSaad.movieapp.data.retrive_top_rated.RetriveTopRatedDataSource;
import git.com.ahmedIbrahimSaad.movieapp.data.retrive_top_rated.RetriveTopRatedRepo;
import git.com.ahmedIbrahimSaad.movieapp.domain.base.UseCase;

public class RetriveMoviesUsecase extends UseCase<RetriveMoviesUsecase.RequestValues,RetriveMoviesUsecase.ResponseValue> {
    RetriveTopRatedRepo repo;

    public RetriveMoviesUsecase(RetriveTopRatedRepo repo) {
        this.repo = repo;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        repo.retriveTopRatedMovies(new RetriveTopRatedDataSource.TopRatedMovieCallBack() {
            @Override
            public void onRetriveSuccess(List<ResultsItem> movieList) {
                ResponseValue responseValue=new ResponseValue(movieList);
                getUseCaseCallback().onSuccess(responseValue);
            }

            @Override
            public void onRetriveError(GenerericResponseModel responseModel) {
                ResponseValue responseValue = new ResponseValue(responseModel);
                getUseCaseCallback().onError(responseValue);

            }
        });

    }

    public static class RequestValues implements UseCase.RequestValues {

    }
    public class ResponseValue implements UseCase.ResponseValue{
        GenerericResponseModel responseModel;
        public ResponseValue(GenerericResponseModel responseModel) {
            this.responseModel = responseModel;
        }

        public GenerericResponseModel getResponseModel() {
            return responseModel;
        }
        List<ResultsItem>movieList;

        public ResponseValue(List<ResultsItem> movieList) {
            this.movieList = movieList;
        }

        public List<ResultsItem> getMovieList() {
            return movieList;
        }
    }
}
