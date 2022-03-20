package publications;

import java.util.Properties;

public class PublicationGeneratorConfiguration {
    private final int subscriptionsToGenerate;

    public PublicationGeneratorConfiguration(Properties properties) {
        this.subscriptionsToGenerate = Integer.parseInt(properties.getProperty("NO_OF_PUBLICATIONS"));
    }

    public int getPublicationsToGenerate() {
        return subscriptionsToGenerate;
    }

}
