package git.com.ahmedIbrahimSaad.movieapp.data.retrive_top_rated;

public class RetriveTopRatedRepo implements RetriveTopRatedDataSource {
    RetriveTopRatedDataSource retriveTopRatedDataSource;

    public RetriveTopRatedRepo(RetriveTopRatedDataSource retriveTopRatedDataSource) {
        this.retriveTopRatedDataSource = retriveTopRatedDataSource;
    }

    @Override
    public void retriveTopRatedMovies(TopRatedMovieCallBack callBack) {
        retriveTopRatedDataSource.retriveTopRatedMovies(callBack);

    }
}
