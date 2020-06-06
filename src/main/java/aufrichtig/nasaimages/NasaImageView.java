package aufrichtig.nasaimages;

import javax.inject.Singleton;
import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;

@Singleton
public class NasaImageView extends JComponent{
    ImageIcon imageIcon;
    String imageLink;

    public void setNasaImage(NasaImageFeed.Link link) throws MalformedURLException {
        imageLink = link.imageLink;
        URL url = new URL(imageLink);
        imageIcon = new ImageIcon(url);
    }

}
