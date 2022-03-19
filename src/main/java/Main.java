import common.JsonWriter;
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

    public static List<Subscription> generateSubscriptions(Properties properties) {
        SubscriptionGeneratorConfiguration configuration = new SubscriptionGeneratorConfiguration(properties);
        SubscriptionGenerator subscriptionGenerator = new SubscriptionGenerator(configuration);

        return subscriptionGenerator.generateSubscriptions();
    }

    public static void saveSubscriptions(List<Subscription> subscriptions) throws IOException {
        JsonWriter jsonWriter = new JsonWriter();
        String filename = "subscriptions/subscriptions-" + UUID.randomUUID() + ".json";
        jsonWriter.writeObjectAsJsonToFile(new File(filename), subscriptions);
    }
}
