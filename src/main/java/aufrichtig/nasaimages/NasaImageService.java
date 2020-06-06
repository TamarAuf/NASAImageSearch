package aufrichtig.nasaimages;

import retrofit2.Call;
import retrofit2.http.*;

public interface NasaImageService {

    @GET("/search?&media_type=image")
    Call<NasaImageFeed> getImage(@Query("q") String textInput);
}