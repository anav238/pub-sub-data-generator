package publications;

import common.Company;
import common.RandomFieldsUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PublicationGenerator {

    private final PublicationGeneratorConfiguration configuration;

    public PublicationGenerator(PublicationGeneratorConfiguration configuration) {
        this.configuration = configuration;
    }

    public List<Publication> generatePublications() {
        List<Publication> publications = new ArrayList<>();
        for (int i = 0; i < configuration.getPublicationsToGenerate(); i++)
            publications.add(generatePublication());
        return publications;
    }

    private Publication generatePublication() {
        Company company = (Company) RandomFieldsUtils.getRandomFieldValue(PublicationField.COMPANY);
        double value = (double) RandomFieldsUtils.getRandomFieldValue(PublicationField.VALUE);
        double drop = (double) RandomFieldsUtils.getRandomFieldValue(PublicationField.DROP);
        double variation = (double) RandomFieldsUtils.getRandomFieldValue(PublicationField.VARIATION);
        Date date = (Date) RandomFieldsUtils.getRandomFieldValue(PublicationField.DATE);
        Publication publication = new Publication(company, value, drop, variation, date);
        return publication;
    }
}
