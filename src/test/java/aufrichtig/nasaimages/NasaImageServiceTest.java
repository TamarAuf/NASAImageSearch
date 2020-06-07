package aufrichtig.nasaimages;

import org.junit.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class NasaImageServiceTest {

    @Test
    public void getImages() throws IOException {

        // given
        NasaImageService service = new NasaImageServiceFactory().getInstance();

        // when
        Response<NasaImageFeed> response = service.getImage("moon").execute();

        //then
        assertTrue(response.toString(), response.isSuccessful());
        NasaImageFeed feed = response.body();
        assertNotNull(feed);

        NasaImageFeed.Collection collection = feed.collection;
        assertNotNull(collection);

        ArrayList<NasaImageFeed.Item> items = collection.items;
        assertFalse(items.isEmpty());

        NasaImageFeed.Item item = items.get(0);

        ArrayList<NasaImageFeed.Data> data = item.data;
        assertFalse(data.isEmpty());

        ArrayList<NasaImageFeed.Link> links = item.links;
        assertFalse(links.isEmpty());

        NasaImageFeed.Data datum = data.get(0);
        NasaImageFeed.Link link = links.get(0);

        assertNotNull(datum.description);
        assertNotNull(datum.title);
        assertNotNull(link.imageLink);

        System.out.println("Description: " + datum.description);
        System.out.println("Title: " + datum.title);
        System.out.println("ImageLink: " + link.imageLink);
    }
}
