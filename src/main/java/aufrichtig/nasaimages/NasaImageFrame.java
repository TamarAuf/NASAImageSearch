package aufrichtig.nasaimages;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

public class NasaImageFrame extends JFrame {

    private JFrame frame;
    private JTextField searchField;
    private JLabel instruct;
    private JButton searchButton;
    String textInput;
    private ImageIcon imageIcon;
    private JLabel imageLabel;
    private JTextArea descrip;

    @Inject
    public NasaImageFrame(NasaImageView view, NasaImageController controller) {
        setSize(400, 300);
        setTitle("Image Search Frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        instruct = new JLabel("Search for NASA images by entering keywords");

        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(160, 40));
        searchButton = new JButton("Search");

        searchButton.addActionListener(actionEvent -> {
            textInput = searchField.getText();

            controller.requestImage(textInput);
        });

        add(instruct);
        add(searchField);
        add(searchButton);

    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new NasaImageFrameModule());

        NasaImageFrame frame = injector.getInstance(NasaImageFrame.class);

        frame.setVisible(true);
    }
}
