package sky.skyweatherapp.datamodel;

/**
 * Created by S on 25/04/2016.
 */
public class CityData {

    private long id;
    private String name;
    private String country;

    public CityData(long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}
