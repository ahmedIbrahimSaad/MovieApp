package git.com.ahmedIbrahimSaad.movieapp.data.retrive_top_rated;



import java.io.IOException;

import git.com.ahmedIbrahimSaad.movieapp.data.APIClient;
import git.com.ahmedIbrahimSaad.movieapp.data.Constants;
import git.com.ahmedIbrahimSaad.movieapp.data.APIError;
import git.com.ahmedIbrahimSaad.movieapp.data.GenerericResponseModel;
import retrofit2.Response;

public class RetriveTopRatedRemoteDataSource implements RetriveTopRatedDataSource{
    @Override
    public void retriveTopRatedMovies(TopRatedMovieCallBack callBack) {
        Response<git.com.ahmedIbrahimSaad.movieapp.data.retrive_top_rated.new_model.Response> getTopRatedMovies= null;
        try {
            getTopRatedMovies = APIClient.getWebService().retriveTopRelatedMovies(Constants.getApiToken()).execute();
            if (getTopRatedMovies.isSuccessful()) {
                callBack.onRetriveSuccess(getTopRatedMovies.body().getResults());
            }else
                callBack.onRetriveError(APIError.parseError(getTopRatedMovies));

        } catch (IOException e) {
            e.printStackTrace();
            GenerericResponseModel generericResponseModel = new GenerericResponseModel();
            generericResponseModel.setMessage(e.getMessage());
            callBack.onRetriveError(generericResponseModel);
        }

}}
