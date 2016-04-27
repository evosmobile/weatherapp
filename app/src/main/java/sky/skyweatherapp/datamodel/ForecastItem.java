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


    public String getCardinalDirectionString(double direction) {

        if (direction >= 347.75 || direction < 11.25) {
            return "N";
        } else if (direction >= 11.25 && direction < 33.75) {
            return "NNE";
        } else if (direction >= 33.75 && direction < 56.25) {
            return "NE";
        } else if (direction >= 56.25 && direction < 78.75) {
            return "ENE";
        } else if (direction >= 78.75 && direction < 101.25) {
            return "N";
        } else if (direction >= 101.25 && direction < 123.75) {
            return "ESE";
        } else if (direction >= 123.75 && direction < 146.25) {
            return "SE";
        } else if (direction >= 146.25 && direction < 168.75) {
            return "SSE";
        } else if (direction >= 168.75 && direction < 191.25) {
            return "S";
        } else if (direction >= 191.25 && direction < 213.75) {
            return "SSW";
        } else if (direction >= 213.75 && direction < 236.25) {
            return "SW";
        } else if (direction >= 236.25 && direction < 258.75) {
            return "WSW";
        } else if (direction >= 258.75 && direction < 281.25) {
            return "W";
        } else if (direction >= 281.25 && direction < 303.75) {
            return "WNW";
        } else if (direction >= 303.75 && direction < 326.25) {
            return "NW";
        } else if (direction >= 326.25 && direction < 347.75) {
            return "NNW";
        }
        return "UNK";
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
