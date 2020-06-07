package aufrichtig.nasaimages;

import javax.inject.Singleton;
import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

@Singleton
public class NasaImageView extends JFrame{
    private ImageIcon nasaImage;
    private String imageLink;
    private String title;
    private String description;
    private ImageIcon imageIcon;
    private JLabel imageLabel;
    private JTextArea descrip;
    NasaImageFeed.Link link;
    NasaImageFeed.Data datum;

    public void setNasaImage(NasaImageFeed.Link link, NasaImageFeed.Data datum) throws MalformedURLException {

        imageLink = link.imageLink;
        title = datum.title;
        description = datum.description;

        if (imageLink == null) {
            return;
        }

        URL url = new URL(imageLink);
        nasaImage = new ImageIcon(url);

        JFrame imageFrame = new JFrame();
        imageFrame.setSize(600, 600);

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        imageLabel = new JLabel();
        descrip = new JTextArea();

        imageFrame.setTitle(title);
        imageIcon = nasaImage;

        imageLabel.setIcon(imageIcon);
        descrip.setText(description);

        topPanel.add(imageLabel);
        bottomPanel.add(descrip);

        imageFrame.add(topPanel, BorderLayout.NORTH);
        imageFrame.add(bottomPanel, BorderLayout.SOUTH);

        imageFrame.setVisible(true);
    }

}
