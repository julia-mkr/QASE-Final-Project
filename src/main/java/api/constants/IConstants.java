package api.constants;

import api.utils.PropertyReader;

public interface IConstants {
    String BASE_URL = "https://api.qase.io/v1/";
    String TOKEN = System.getProperty("token", PropertyReader.getProperty("token"));
    String CASE_URI = "case/%s/";
    String SPECIFIC_CASE_URI = CASE_URI + "%d";
}
