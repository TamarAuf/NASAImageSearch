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

    public void setNasaImage(String imageLink) throws MalformedURLException {
        URL url = new URL(imageLink);
        imageIcon = new ImageIcon(url);
    }

}
