package git.com.ahmedIbrahimSaad.movieapp.data;

import java.io.IOException;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;



public class HeadersInterceptor implements Interceptor {

    Map<String,String> map ;

    public HeadersInterceptor(Map<String,String> map){

        super();
        this.map = map ;

    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request original = chain.request();

           //static header interceptor

           // Request customization: override request headers
        //   Request.Builder requestBuilder = original.newBuilder().header("X-TOken", "00000")

        //  Request customization: add request headers when multiple headers with the same name are used
        //   Request.Builder requestBuilder = original.newBuilder().addHeader("X-AUTH-TOKEN", "00000");
        //  Request.Builder requestBuilder = original.newBuilder().addHeader("X-AUTH-TOKEN", "xxxxx");

        //dynamic header interceptor
        Request.Builder requestBuilder = null;
        Request request = null ;

        if(map !=null) {

            for (Map.Entry<String, String> entry : map.entrySet()) {

                requestBuilder = original.newBuilder().addHeader(entry.getKey(), entry.getValue());

                System.out.println(entry.getKey() + "/" + entry.getValue());

            }

            request = requestBuilder.build();
            return chain.proceed(request);


        }else{

            return chain.proceed(original);
        }

    }
}
