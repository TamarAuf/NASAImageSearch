package aufrichtig.nasaimages;

import javax.inject.Singleton;
import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

@Singleton
public class NasaImageView {
    ImageIcon nasaImage;
    String imageLink;

    public void setNasaImage(NasaImageFeed.Link link) throws MalformedURLException {
        this.imageLink = link.imageLink;

        if (imageLink == null) {
            return;
        }

        imageLink = link.imageLink;
        URL url = new URL(imageLink);
        nasaImage = new ImageIcon(url);
    }

}
