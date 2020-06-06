package aufrichtig.nasaimages;

import org.junit.Test;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.*;

public class NasaImageControllerTest  {

    @Test
    public void requestImage() {
        // given
        NasaImageService service = mock(NasaImageService.class);
        NasaImageView view = mock(NasaImageView.class);
        Call<NasaImageFeed> call = mock(Call.class);
        doReturn(call).when(service).getImage();
        NasaImageController controller = new NasaImageController(service, view);

        // when
        controller.requestImage();

        // then
        verify(call).enqueue(controller);
    }

    @Test
    public void onResponse() throws MalformedURLException {
        // given
        NasaImageService service = mock(NasaImageService.class);
        NasaImageView view = mock(NasaImageView.class);
        NasaImageController controller = new NasaImageController(service, view);
        Call<NasaImageFeed> call = mock(Call.class);
        Response<NasaImageFeed> response = mock(Response.class);

        String imageLink = mock(String.class);
        NasaImageFeed feed = mock(NasaImageFeed.class);

        doReturn(imageLink).when(feed).getFirstImage();
        doReturn(feed).when(response).body();

        // when
        controller.onResponse(call, response);

        // then
        verify(view).setNasaImage(imageLink);
    }
}