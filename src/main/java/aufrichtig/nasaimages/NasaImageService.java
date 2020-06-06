package aufrichtig.nasaimages;

import retrofit2.Call;
import retrofit2.http.*;

public interface NasaImageService {

    @GET("/search?q=apollo%2011&description=moon%20landing&media_type=image")
    Call<NasaImageFeed> getImage();
}