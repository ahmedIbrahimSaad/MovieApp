package git.com.ahmedIbrahimSaad.movieapp.data;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;



public class APIClient {
    private static WebSevices webService;
    private static Retrofit retrofit;


    public static WebSevices getWebService(){

           webService = getRetrofit().create(WebSevices.class);

           return webService;
    }

    private static Retrofit getRetrofit() {

        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.getURL())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }
}
