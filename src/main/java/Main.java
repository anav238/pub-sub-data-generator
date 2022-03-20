import common.JsonWriter;
import publications.Publication;
import publications.PublicationGenerator;
import publications.PublicationGeneratorConfiguration;
import subscriptions.Subscription;
import subscriptions.SubscriptionGenerator;
import subscriptions.SubscriptionGeneratorConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        try {
            Properties properties = getApplicationProperties();
            List<Publication> publications = generatePublications(properties);
            savePublications(publications);
            List<Subscription> subscriptions = generateSubscriptions(properties);
            saveSubscriptions(subscriptions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getApplicationProperties() throws IOException {
        Properties properties = new Properties();
        InputStream is = Main.class.getResourceAsStream("application.properties");
        properties.load(is);
        return properties;
    }

    public static List<Publication> generatePublications(Properties properties) {
        PublicationGeneratorConfiguration configuration = new PublicationGeneratorConfiguration(properties);
        PublicationGenerator publicationGenerator = new PublicationGenerator(configuration);

        return publicationGenerator.generatePublications();
    }

    public static List<Subscription> generateSubscriptions(Properties properties) {
        SubscriptionGeneratorConfiguration configuration = new SubscriptionGeneratorConfiguration(properties);
        SubscriptionGenerator subscriptionGenerator = new SubscriptionGenerator(configuration);

        return subscriptionGenerator.generateSubscriptions();
    }

    public static void savePublications(List<Publication> publications) throws IOException {
        JsonWriter jsonWriter = new JsonWriter();
        String filename = "publications/publications-" + UUID.randomUUID() + ".json";
        jsonWriter.writeObjectAsJsonToFile(new File(filename), publications);
    }

    public static void saveSubscriptions(List<Subscription> subscriptions) throws IOException {
        JsonWriter jsonWriter = new JsonWriter();
        String filename = "subscriptions/subscriptions-" + UUID.randomUUID() + ".json";
        jsonWriter.writeObjectAsJsonToFile(new File(filename), subscriptions);
    }
}
