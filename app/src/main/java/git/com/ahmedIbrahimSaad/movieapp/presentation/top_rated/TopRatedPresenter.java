package git.com.ahmedIbrahimSaad.movieapp.presentation.top_rated;



import git.com.ahmedIbrahimSaad.movieapp.domain.RetriveMoviesUsecase;
import git.com.ahmedIbrahimSaad.movieapp.domain.base.UseCase;
import git.com.ahmedIbrahimSaad.movieapp.domain.base.UseCaseHandler;

public class TopRatedPresenter implements TopRatedContract.TopRatedPresenter {
    RetriveMoviesUsecase retriveMoviesUsecase;
    UseCaseHandler useCaseHandler;
    TopRatedContract.TopRatedView view;

    public TopRatedPresenter(RetriveMoviesUsecase retriveMoviesUsecase, UseCaseHandler useCaseHandler, TopRatedContract.TopRatedView view) {
        this.retriveMoviesUsecase = retriveMoviesUsecase;
        this.useCaseHandler = useCaseHandler;
        this.view = view;
    }

    @Override
    public void retriveTopRatedMovies() {
        RetriveMoviesUsecase.RequestValues requestValues=new RetriveMoviesUsecase.RequestValues();
        useCaseHandler.execute(retriveMoviesUsecase, requestValues, new UseCase.UseCaseCallback<RetriveMoviesUsecase.ResponseValue>() {
            @Override
            public void onSuccess(RetriveMoviesUsecase.ResponseValue response) {
                view.onRetriveTopRatedMoviesSuccess(response.getMovieList());
            }

            @Override
            public void onError(RetriveMoviesUsecase.ResponseValue response) {
                view.ononRetriveTopRatedMoviesFail(response.getResponseModel());

            }
        });

    }

    @Override
    public void start() {

    }
}
