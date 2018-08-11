package git.com.ahmedIbrahimSaad.movieapp;



import git.com.ahmedIbrahimSaad.movieapp.domain.RetriveMoviesUsecase;
import git.com.ahmedIbrahimSaad.movieapp.data.retrive_top_rated.RetriveTopRatedRemoteDataSource;
import git.com.ahmedIbrahimSaad.movieapp.data.retrive_top_rated.RetriveTopRatedRepo;
import git.com.ahmedIbrahimSaad.movieapp.domain.base.UseCaseHandler;

public class Injection {
    public static RetriveTopRatedRepo injectRetriveTopRatedRepo (){
        return new RetriveTopRatedRepo(new RetriveTopRatedRemoteDataSource());
    }
    public static RetriveMoviesUsecase injectRetriveMoviesUsecase(){
        return new RetriveMoviesUsecase(injectRetriveTopRatedRepo());
    }
    public static UseCaseHandler provideUseCaseHandler() {

        return UseCaseHandler.getInstance();
    }
}
