package aufrichtig.nasaimages;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class NasaImageFrameTest {

    @Test
    public void requestImage() {
        // given
        NasaImageView view = new NasaImageView();
        NasaImageController controller = mock(NasaImageController.class);

        // when
        //NasaImageFrame frame = new NasaImageFrame(view, controller);

        // then
        verify(controller).requestImage("moon");
    }

}
