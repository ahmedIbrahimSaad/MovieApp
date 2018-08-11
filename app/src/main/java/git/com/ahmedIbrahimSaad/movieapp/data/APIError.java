
package git.com.ahmedIbrahimSaad.movieapp.data;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.IOException;

import retrofit2.Response;

public class APIError {

        public static GenerericResponseModel parseError(Response<?> response) {

            GenerericResponseModel generericResponseModel =null;
            Gson gson = new Gson();
            TypeAdapter<GenerericResponseModel> adapter = gson.getAdapter(GenerericResponseModel.class);
                if (response.errorBody() != null) {
                    try {
                        generericResponseModel = adapter.fromJson(response.raw().body().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                        return generericResponseModel;

                    }

            }

            return generericResponseModel;
        }
    }


