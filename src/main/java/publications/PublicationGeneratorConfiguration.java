package publications;

import java.util.Properties;

public class PublicationGeneratorConfiguration {
    private final int publicationsToGenerate;

    public PublicationGeneratorConfiguration(Properties properties) {
        this.publicationsToGenerate = Integer.parseInt(properties.getProperty("NO_OF_PUBLICATIONS"));
    }

    public int getPublicationsToGenerate() {
        return publicationsToGenerate;
    }

}
