package sky.skyweatherapp.datatests;

/**
 * Created by S on 25/04/2016.
 */
public class TestData {

    public static String sampleCityData = "{\"message\":\"like\",\"cod\":\"200\",\"count\":4,\"list\":[{\"id\":5089178,\"name\":\"Manchester\",\"coord\":{\"lon\":-71.454788,\"lat\":42.99564},\"main\":{\"temp\":288.4,\"pressure\":1013,\"humidity\":20,\"temp_min\":286.15,\"temp_max\":290.15},\"dt\":1461613378,\"wind\":{\"speed\":5.7,\"deg\":310,\"gust\":8.2},\"sys\":{\"country\":\"US\"},\"clouds\":{\"all\":1},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Sky is Clear\",\"icon\":\"01d\"}]},{\"id\":2643123,\"name\":\"Manchester\",\"coord\":{\"lon\":-2.23743,\"lat\":53.480949},\"main\":{\"temp\":278.79,\"pressure\":1008,\"humidity\":42,\"temp_min\":275.93,\"temp_max\":282.15},\"dt\":1461613526,\"wind\":{\"speed\":5.1,\"deg\":350},\"sys\":{\"country\":\"GB\"},\"clouds\":{\"all\":20},\"weather\":[{\"id\":521,\"main\":\"Rain\",\"description\":\"shower rain\",\"icon\":\"09n\"}]},{\"id\":4396915,\"name\":\"Manchester\",\"coord\":{\"lon\":-90.509293,\"lat\":38.597},\"main\":{\"temp\":302.22,\"pressure\":1006,\"humidity\":42,\"temp_min\":301.15,\"temp_max\":303.71},\"dt\":1461613491,\"wind\":{\"speed\":5.1,\"deg\":190,\"gust\":8.2},\"sys\":{\"country\":\"US\"},\"clouds\":{\"all\":40},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03d\"}]},{\"id\":4838174,\"name\":\"Manchester\",\"coord\":{\"lon\":-72.521477,\"lat\":41.775928},\"main\":{\"temp\":290.2,\"pressure\":1014,\"humidity\":31,\"temp_min\":287.04,\"temp_max\":293.71},\"dt\":1461612981,\"wind\":{\"speed\":1.5,\"deg\":10},\"sys\":{\"country\":\"US\"},\"clouds\":{\"all\":90},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}]}]}";

    public static String sampleForecastData = "{\n" +
            "city: {},\n" +
            "cod: \"200\",\n" +
            "message: 0.0035,\n" +
            "cnt: 40,\n" +
            "list: [\n" +
            "{},\n" +
            "{},\n" +
            "{\n" +
            "dt: 1461726000,\n" +
            "main: {\n" +
            "temp: 283.88,\n" +
            "temp_min: 283.88,\n" +
            "temp_max: 284.187,\n" +
            "pressure: 1004.19,\n" +
            "sea_level: 1024.03,\n" +
            "grnd_level: 1004.19,\n" +
            "humidity: 98,\n" +
            "temp_kf: -0.31\n" +
            "},\n" +
            "weather: [\n" +
            "{\n" +
            "id: 500,\n" +
            "main: \"Rain\",\n" +
            "description: \"light rain\",\n" +
            "icon: \"10d\"\n" +
            "}\n" +
            "],\n" +
            "clouds: {\n" +
            "all: 92\n" +
            "},\n" +
            "wind: {\n" +
            "speed: 4.17,\n" +
            "deg: 144.003\n" +
            "},\n" +
            "rain: {\n" +
            "3h: 0.3425\n" +
            "},\n" +
            "sys: {\n" +
            "pod: \"d\"\n" +
            "},\n" +
            "dt_txt: \"2016-04-27 03:00:00\"\n" +
            "}]}";
}
