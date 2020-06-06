package aufrichtig.nasaimages;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NasaImageServiceFactory {

    public NasaImageService getInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://images-api.nasa.gov/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NasaImageService service = retrofit.create(NasaImageService.class);
        return service;
    }

}
