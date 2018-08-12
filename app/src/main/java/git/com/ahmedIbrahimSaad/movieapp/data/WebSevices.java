package git.com.ahmedIbrahimSaad.movieapp.data;


import git.com.ahmedIbrahimSaad.movieapp.data.retrive_top_rated.new_model.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebSevices {
    @GET("top_rated?api_key=c3757a2fa6f856cf857f86b6376c5396")
    Call<Response>retriveTopRelatedMovies();
}
