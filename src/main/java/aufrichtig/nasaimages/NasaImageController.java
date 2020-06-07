package aufrichtig.nasaimages;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.inject.Inject;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class NasaImageController implements Callback<NasaImageFeed>{
    private NasaImageService service;
    private NasaImageView view;

    @Inject
    public NasaImageController(NasaImageService service, NasaImageView view) {
        this.service = service;
        this.view = view;
    }

    public void requestImage(String textInput) {
        service.getImage(textInput).enqueue(this);
    }

    @Override
    public void onResponse(Call<NasaImageFeed> call, Response<NasaImageFeed> response) {
        NasaImageFeed.Link link = response.body().getFirstLink();
        NasaImageFeed.Data datum = response.body().getFirstDatum();

        try {
            view.setNasaImage(link, datum);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(Call<NasaImageFeed> call, Throwable t) {
        t.printStackTrace();
    }

}
