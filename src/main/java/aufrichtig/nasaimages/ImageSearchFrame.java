package aufrichtig.nasaimages;

import com.google.inject.Guice;
import com.google.inject.Injector;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class ImageSearchFrame extends JFrame {

    private JTextField searchField;
    private JLabel instruct;
    private JButton searchButton;


    public ImageSearchFrame() {
        setSize(400, 300);
        setTitle("Image Search Frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        instruct = new JLabel("These are it");

        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(160, 40));
        searchButton = new JButton("Search");

        searchButton.addActionListener(actionEvent -> {
            try {
                Injector injector = Guice.createInjector(new NasaImageFrameModule());
                NasaImageFrame frame = injector.getInstance(NasaImageFrame.class);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        add(instruct);
        add(searchField);
        add(searchButton);

    }

    public static void main(String[] args) {
        new ImageSearchFrame().setVisible(true);
    }
}