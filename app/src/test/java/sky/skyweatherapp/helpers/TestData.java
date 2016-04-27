package sky.skyweatherapp.helpers;

/**
 * Created by SMcD on 25/04/2016.
 */
public class TestData {

    public static String sampleCityData = "{\"message\":\"like\",\"cod\":\"200\",\"count\":4,\"list\":[{\"id\":5089178,\"name\":\"Manchester\",\"coord\":{\"lon\":-71.454788,\"lat\":42.99564},\"main\":{\"temp\":288.4,\"pressure\":1013,\"humidity\":20,\"temp_min\":286.15,\"temp_max\":290.15},\"dt\":1461613378,\"wind\":{\"speed\":5.7,\"deg\":310,\"gust\":8.2},\"sys\":{\"country\":\"US\"},\"clouds\":{\"all\":1},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Sky is Clear\",\"icon\":\"01d\"}]},{\"id\":2643123,\"name\":\"Manchester\",\"coord\":{\"lon\":-2.23743,\"lat\":53.480949},\"main\":{\"temp\":278.79,\"pressure\":1008,\"humidity\":42,\"temp_min\":275.93,\"temp_max\":282.15},\"dt\":1461613526,\"wind\":{\"speed\":5.1,\"deg\":350},\"sys\":{\"country\":\"GB\"},\"clouds\":{\"all\":20},\"weather\":[{\"id\":521,\"main\":\"Rain\",\"description\":\"shower rain\",\"icon\":\"09n\"}]},{\"id\":4396915,\"name\":\"Manchester\",\"coord\":{\"lon\":-90.509293,\"lat\":38.597},\"main\":{\"temp\":302.22,\"pressure\":1006,\"humidity\":42,\"temp_min\":301.15,\"temp_max\":303.71},\"dt\":1461613491,\"wind\":{\"speed\":5.1,\"deg\":190,\"gust\":8.2},\"sys\":{\"country\":\"US\"},\"clouds\":{\"all\":40},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03d\"}]},{\"id\":4838174,\"name\":\"Manchester\",\"coord\":{\"lon\":-72.521477,\"lat\":41.775928},\"main\":{\"temp\":290.2,\"pressure\":1014,\"humidity\":31,\"temp_min\":287.04,\"temp_max\":293.71},\"dt\":1461612981,\"wind\":{\"speed\":1.5,\"deg\":10},\"sys\":{\"country\":\"US\"},\"clouds\":{\"all\":90},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}]}]}";

    public static String sampleForecastData = "\n" +
            "{\"city\":{\"id\":524901,\"name\":\"Moscow\",\"coord\":{\"lon\":37.615555,\"lat\":55.75222},\"country\":\"RU\",\"population\":0,\"sys\":{\"population\":0}},\"cod\":\"200\",\"message\":0.0031,\"cnt\":40,\"list\":[{\"dt\":1461704400,\"main\":{\"temp\":284.45,\"temp_min\":284.026,\"temp_max\":284.45,\"pressure\":1002.42,\"sea_level\":1021.94,\"grnd_level\":1002.42,\"humidity\":97,\"temp_kf\":0.42},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":5.95,\"deg\":127.001},\"rain\":{\"3h\":1.965},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2016-04-26 21:00:00\"},{\"dt\":1461715200,\"main\":{\"temp\":284.37,\"temp_min\":283.971,\"temp_max\":284.37,\"pressure\":1002.83,\"sea_level\":1022.53,\"grnd_level\":1002.83,\"humidity\":98,\"temp_kf\":0.4},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":5.32,\"deg\":137.001},\"rain\":{\"3h\":1.435},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2016-04-27 00:00:00\"},{\"dt\":1461726000,\"main\":{\"temp\":284.57,\"temp_min\":284.187,\"temp_max\":284.57,\"pressure\":1004.19,\"sea_level\":1024.03,\"grnd_level\":1004.19,\"humidity\":98,\"temp_kf\":0.38},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":4.17,\"deg\":144.003},\"rain\":{\"3h\":0.3425},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-04-27 03:00:00\"},{\"dt\":1461736800,\"main\":{\"temp\":285.93,\"temp_min\":285.571,\"temp_max\":285.93,\"pressure\":1005.68,\"sea_level\":1025.34,\"grnd_level\":1005.68,\"humidity\":99,\"temp_kf\":0.36},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":88},\"wind\":{\"speed\":3.57,\"deg\":138.007},\"rain\":{\"3h\":0.315},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-04-27 06:00:00\"},{\"dt\":1461747600,\"main\":{\"temp\":286.84,\"temp_min\":286.507,\"temp_max\":286.84,\"pressure\":1006.96,\"sea_level\":1026.61,\"grnd_level\":1006.96,\"humidity\":99,\"temp_kf\":0.33},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":80},\"wind\":{\"speed\":3.97,\"deg\":122.501},\"rain\":{\"3h\":0.2425},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-04-27 09:00:00\"},{\"dt\":1461758400,\"main\":{\"temp\":287.69,\"temp_min\":287.381,\"temp_max\":287.69,\"pressure\":1008.1,\"sea_level\":1027.72,\"grnd_level\":1008.1,\"humidity\":93,\"temp_kf\":0.31},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":80},\"wind\":{\"speed\":4,\"deg\":115.001},\"rain\":{\"3h\":0.0825},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-04-27 12:00:00\"},{\"dt\":1461769200,\"main\":{\"temp\":287.27,\"temp_min\":286.979,\"temp_max\":287.27,\"pressure\":1009.08,\"sea_level\":1028.65,\"grnd_level\":1009.08,\"humidity\":91,\"temp_kf\":0.29},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":4.06,\"deg\":112.001},\"rain\":{\"3h\":0.195},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-04-27 15:00:00\"},{\"dt\":1461780000,\"main\":{\"temp\":286.36,\"temp_min\":286.095,\"temp_max\":286.36,\"pressure\":1010.1,\"sea_level\":1029.9,\"grnd_level\":1010.1,\"humidity\":90,\"temp_kf\":0.27},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":4.02,\"deg\":108.003},\"rain\":{\"3h\":0.165},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2016-04-27 18:00:00\"},{\"dt\":1461790800,\"main\":{\"temp\":285.28,\"temp_min\":285.03,\"temp_max\":285.28,\"pressure\":1011.12,\"sea_level\":1030.9,\"grnd_level\":1011.12,\"humidity\":89,\"temp_kf\":0.25},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":76},\"wind\":{\"speed\":4.36,\"deg\":114.501},\"rain\":{\"3h\":0.03},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2016-04-27 21:00:00\"},{\"dt\":1461801600,\"main\":{\"temp\":284.03,\"temp_min\":283.803,\"temp_max\":284.03,\"pressure\":1011.55,\"sea_level\":1031.56,\"grnd_level\":1011.55,\"humidity\":85,\"temp_kf\":0.22},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}],\"clouds\":{\"all\":36},\"wind\":{\"speed\":4.36,\"deg\":102.502},\"rain\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2016-04-28 00:00:00\"},{\"dt\":1461812400,\"main\":{\"temp\":282.73,\"temp_min\":282.531,\"temp_max\":282.73,\"pressure\":1012.35,\"sea_level\":1032.35,\"grnd_level\":1012.35,\"humidity\":82,\"temp_kf\":0.2},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02d\"}],\"clouds\":{\"all\":24},\"wind\":{\"speed\":4.96,\"deg\":97.5021},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-04-28 03:00:00\"},{\"dt\":1461823200,\"main\":{\"temp\":284.99,\"temp_min\":284.816,\"temp_max\":284.99,\"pressure\":1012.77,\"sea_level\":1032.55,\"grnd_level\":1012.77,\"humidity\":74,\"temp_kf\":0.18},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":56},\"wind\":{\"speed\":5.82,\"deg\":101.003},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-04-28 06:00:00\"},{\"dt\":1461834000,\"main\":{\"temp\":287.11,\"temp_min\":286.956,\"temp_max\":287.11,\"pressure\":1013.1,\"sea_level\":1032.74,\"grnd_level\":1013.1,\"humidity\":68,\"temp_kf\":0.16},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03d\"}],\"clouds\":{\"all\":44},\"wind\":{\"speed\":6.16,\"deg\":100.501},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-04-28 09:00:00\"},{\"dt\":1461844800,\"main\":{\"temp\":288.3,\"temp_min\":288.166,\"temp_max\":288.3,\"pressure\":1012.94,\"sea_level\":1032.59,\"grnd_level\":1012.94,\"humidity\":63,\"temp_kf\":0.13},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":56},\"wind\":{\"speed\":6.11,\"deg\":102.001},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-04-28 12:00:00\"},{\"dt\":1461855600,\"main\":{\"temp\":287.24,\"temp_min\":287.133,\"temp_max\":287.24,\"pressure\":1013.32,\"sea_level\":1032.93,\"grnd_level\":1013.32,\"humidity\":61,\"temp_kf\":0.11},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":68},\"wind\":{\"speed\":5.3,\"deg\":102.5},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-04-28 15:00:00\"},{\"dt\":1461866400,\"main\":{\"temp\":284.94,\"temp_min\":284.846,\"temp_max\":284.94,\"pressure\":1014.28,\"sea_level\":1034.18,\"grnd_level\":1014.28,\"humidity\":59,\"temp_kf\":0.09},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":76},\"wind\":{\"speed\":5.22,\"deg\":97.5013},\"rain\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2016-04-28 18:00:00\"},{\"dt\":1461877200,\"main\":{\"temp\":282.3,\"temp_min\":282.232,\"temp_max\":282.3,\"pressure\":1015.68,\"sea_level\":1035.61,\"grnd_level\":1015.68,\"humidity\":60,\"temp_kf\":0.07},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":5.56,\"deg\":101.502},\"rain\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2016-04-28 21:00:00\"},{\"dt\":1461888000,\"main\":{\"temp\":280.04,\"temp_min\":279.999,\"temp_max\":280.04,\"pressure\":1016.47,\"sea_level\":1036.6,\"grnd_level\":1016.47,\"humidity\":64,\"temp_kf\":0.04},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":4.81,\"deg\":101.5},\"rain\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2016-04-29 00:00:00\"},{\"dt\":1461898800,\"main\":{\"temp\":279.41,\"temp_min\":279.389,\"temp_max\":279.41,\"pressure\":1017.1,\"sea_level\":1037.32,\"grnd_level\":1017.1,\"humidity\":67,\"temp_kf\":0.02},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":4.37,\"deg\":95.0008},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-04-29 03:00:00\"},{\"dt\":1461909600,\"main\":{\"temp\":283.08,\"temp_min\":283.08,\"temp_max\":283.08,\"pressure\":1017.52,\"sea_level\":1037.53,\"grnd_level\":1017.52,\"humidity\":66,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":5.15,\"deg\":101.503},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-04-29 06:00:00\"},{\"dt\":1461920400,\"main\":{\"temp\":285.442,\"temp_min\":285.442,\"temp_max\":285.442,\"pressure\":1017.37,\"sea_level\":1037.13,\"grnd_level\":1017.37,\"humidity\":65,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":5.36,\"deg\":101.501},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-04-29 09:00:00\"},{\"dt\":1461931200,\"main\":{\"temp\":286.193,\"temp_min\":286.193,\"temp_max\":286.193,\"pressure\":1016.84,\"sea_level\":1036.6,\"grnd_level\":1016.84,\"humidity\":59,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":4.97,\"deg\":96.5001},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-04-29 12:00:00\"},{\"dt\":1461942000,\"main\":{\"temp\":285.518,\"temp_min\":285.518,\"temp_max\":285.518,\"pressure\":1016.6,\"sea_level\":1036.45,\"grnd_level\":1016.6,\"humidity\":55,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":4.07,\"deg\":90.0013},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-04-29 15:00:00\"},{\"dt\":1461952800,\"main\":{\"temp\":281.247,\"temp_min\":281.247,\"temp_max\":281.247,\"pressure\":1017.47,\"sea_level\":1037.6,\"grnd_level\":1017.47,\"humidity\":57,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":3.65,\"deg\":78.5009},\"rain\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2016-04-29 18:00:00\"},{\"dt\":1461963600,\"main\":{\"temp\":278.582,\"temp_min\":278.582,\"temp_max\":278.582,\"pressure\":1017.98,\"sea_level\":1038.18,\"grnd_level\":1017.98,\"humidity\":62,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":3.1,\"deg\":87.0026},\"rain\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2016-04-29 21:00:00\"},{\"dt\":1461974400,\"main\":{\"temp\":275.555,\"temp_min\":275.555,\"temp_max\":275.555,\"pressure\":1018.21,\"sea_level\":1038.67,\"grnd_level\":1018.21,\"humidity\":69,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":1.22,\"deg\":56.5017},\"rain\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2016-04-30 00:00:00\"},{\"dt\":1461985200,\"main\":{\"temp\":275.738,\"temp_min\":275.738,\"temp_max\":275.738,\"pressure\":1018.72,\"sea_level\":1039.27,\"grnd_level\":1018.72,\"humidity\":66,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":2.3,\"deg\":33.0081},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-04-30 03:00:00\"},{\"dt\":1461996000,\"main\":{\"temp\":283.458,\"temp_min\":283.458,\"temp_max\":283.458,\"pressure\":1019.31,\"sea_level\":1039.31,\"grnd_level\":1019.31,\"humidity\":70,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":1.76,\"deg\":43.5003},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-04-30 06:00:00\"},{\"dt\":1462006800,\"main\":{\"temp\":285.504,\"temp_min\":285.504,\"temp_max\":285.504,\"pressure\":1018.76,\"sea_level\":1038.59,\"grnd_level\":1018.76,\"humidity\":68,\"temp_kf\":0},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02d\"}],\"clouds\":{\"all\":20},\"wind\":{\"speed\":1.97,\"deg\":37.5003},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-04-30 09:00:00\"},{\"dt\":1462017600,\"main\":{\"temp\":286.478,\"temp_min\":286.478,\"temp_max\":286.478,\"pressure\":1017.61,\"sea_level\":1037.39,\"grnd_level\":1017.61,\"humidity\":60,\"temp_kf\":0},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03d\"}],\"clouds\":{\"all\":36},\"wind\":{\"speed\":2.4,\"deg\":356.003},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-04-30 12:00:00\"},{\"dt\":1462028400,\"main\":{\"temp\":286.207,\"temp_min\":286.207,\"temp_max\":286.207,\"pressure\":1016.76,\"sea_level\":1036.54,\"grnd_level\":1016.76,\"humidity\":54,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":56},\"wind\":{\"speed\":2.87,\"deg\":0.00140381},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-04-30 15:00:00\"},{\"dt\":1462039200,\"main\":{\"temp\":283.081,\"temp_min\":283.081,\"temp_max\":283.081,\"pressure\":1017.04,\"sea_level\":1037.1,\"grnd_level\":1017.04,\"humidity\":57,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":68},\"wind\":{\"speed\":2.97,\"deg\":356.002},\"rain\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2016-04-30 18:00:00\"},{\"dt\":1462050000,\"main\":{\"temp\":280.75,\"temp_min\":280.75,\"temp_max\":280.75,\"pressure\":1016.96,\"sea_level\":1037.31,\"grnd_level\":1016.96,\"humidity\":62,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"02n\"}],\"clouds\":{\"all\":8},\"wind\":{\"speed\":3.03,\"deg\":349.501},\"rain\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2016-04-30 21:00:00\"},{\"dt\":1462060800,\"main\":{\"temp\":278.546,\"temp_min\":278.546,\"temp_max\":278.546,\"pressure\":1016.68,\"sea_level\":1037.04,\"grnd_level\":1016.68,\"humidity\":63,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":3.12,\"deg\":325.002},\"rain\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2016-05-01 00:00:00\"},{\"dt\":1462071600,\"main\":{\"temp\":279.347,\"temp_min\":279.347,\"temp_max\":279.347,\"pressure\":1016.38,\"sea_level\":1036.77,\"grnd_level\":1016.38,\"humidity\":65,\"temp_kf\":0},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02d\"}],\"clouds\":{\"all\":24},\"wind\":{\"speed\":3.61,\"deg\":329.506},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-05-01 03:00:00\"},{\"dt\":1462082400,\"main\":{\"temp\":284.671,\"temp_min\":284.671,\"temp_max\":284.671,\"pressure\":1016.26,\"sea_level\":1036.13,\"grnd_level\":1016.26,\"humidity\":66,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":56},\"wind\":{\"speed\":3.21,\"deg\":343.001},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-05-01 06:00:00\"},{\"dt\":1462093200,\"main\":{\"temp\":287.477,\"temp_min\":287.477,\"temp_max\":287.477,\"pressure\":1015.72,\"sea_level\":1035.44,\"grnd_level\":1015.72,\"humidity\":61,\"temp_kf\":0},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03d\"}],\"clouds\":{\"all\":36},\"wind\":{\"speed\":4.66,\"deg\":3.50116},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-05-01 09:00:00\"},{\"dt\":1462104000,\"main\":{\"temp\":288.187,\"temp_min\":288.187,\"temp_max\":288.187,\"pressure\":1014.84,\"sea_level\":1034.52,\"grnd_level\":1014.84,\"humidity\":59,\"temp_kf\":0},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03d\"}],\"clouds\":{\"all\":48},\"wind\":{\"speed\":5.07,\"deg\":358.504},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-05-01 12:00:00\"},{\"dt\":1462114800,\"main\":{\"temp\":287.688,\"temp_min\":287.688,\"temp_max\":287.688,\"pressure\":1014.01,\"sea_level\":1033.8,\"grnd_level\":1014.01,\"humidity\":56,\"temp_kf\":0},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02d\"}],\"clouds\":{\"all\":20},\"wind\":{\"speed\":4.56,\"deg\":353.506},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2016-05-01 15:00:00\"},{\"dt\":1462125600,\"main\":{\"temp\":284.053,\"temp_min\":284.053,\"temp_max\":284.053,\"pressure\":1014.55,\"sea_level\":1034.43,\"grnd_level\":1014.55,\"humidity\":56,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":4.11,\"deg\":2.50037},\"rain\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2016-05-01 18:00:00\"}]}\n";
}