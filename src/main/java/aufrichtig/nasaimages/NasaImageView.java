package aufrichtig.nasaimages;

import javax.inject.Singleton;
import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

@Singleton
public class NasaImageView {
    ImageIcon nasaImage;
    NasaImageFeed.Link link;
    NasaImageFeed.Data datum;
    String imageLink;
    String title;
    String description;

    public void setNasaImage(NasaImageFeed.Link link, NasaImageFeed.Data datum) throws MalformedURLException {
        this.link = link;
        this.datum = datum;

        imageLink = link.imageLink;
        title = datum.title;
        description = datum.description;

        if (imageLink == null) {
            return;
        }

        imageLink = link.imageLink;
        URL url = new URL(imageLink);
        nasaImage = new ImageIcon(url);
    }

}
