package publications;

import common.Company;

import java.util.Date;

public class Publication {
    private final Company company;
    private final double value;
    private final double drop;
    private final double variation;
    private final Date date;

    public Publication(Company company, double value, double drop, double variation, Date date) {
        this.company = company;
        this.value = value;
        this.drop = drop;
        this.variation = variation;
        this.date = date;
    }

    public Company getCompany() {
        return company;
    }

    public double getValue() {
        return value;
    }

    public double getDrop() {
        return drop;
    }

    public double getVariation() {
        return variation;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "company=" + company +
                ", value=" + value +
                ", drop=" + drop +
                ", variation=" + variation +
                ", date=" + date +
                '}';
    }
}
