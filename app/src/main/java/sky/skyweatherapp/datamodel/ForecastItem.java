package sky.skyweatherapp.datamodel;

/**
 * Created by SMcDMcD on 26/04/16.
 */
public class ForecastItem {

    private final long datetime;
    private final double speed;

    public double getDirection() {
        return direction;
    }

    public double getSpeed() {
        return speed;
    }

    public long getDatetime() {
        return datetime;
    }

    private final double direction;


    public ForecastItem(long datetime, double speed, double direction) {
        this.datetime = datetime;
        this.speed = speed;
        this.direction = direction;
    }
}
