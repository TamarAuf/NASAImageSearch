package aufrichtig.nasaimages;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class NasaImageFrameModule extends AbstractModule {

        @Provides
        static NasaImageService providesNeoService() {
            return new NasaImageServiceFactory().getInstance();
        }

    }
