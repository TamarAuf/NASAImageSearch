package aufrichtig.nasaimages;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.swing.*;
import java.awt.*;

public class NasaImageFrame extends JFrame {

    @Inject
    public NasaImageFrame(NasaImageView view, NasaImageController controller) {
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("NASA Image");
        setLayout(new BorderLayout());

        add(view, BorderLayout.CENTER);
        controller.requestImage();
    }



}