package api.constants;

import api.utils.PropertyReader;

public interface IConstants {
    String BASE_URL = "https://api.qase.io/v1/";
    String TOKEN = System.getenv().getOrDefault("token", PropertyReader.getProperty("token"));
    String CASE_URI = "case/%s";
    String SPECIFIC_CASE_URI = CASE_URI + "/%d";
    String ATTACHMENT_URI = "attachment/%s";
    String DEFECT_URI = "defect/%s";
    String SPECIFIC_DEFECT_URI = DEFECT_URI + "/%d";
    String RESOLVE_SPECIFIC_DEFECT_URI = DEFECT_URI + "/resolve" + "/%d";
    String UPDATE_SPECIFIC_DEFECT_STATUS_URI = DEFECT_URI + "/status" + "/%d";
    String TEST_PLAN_URI = "plan/%s";
    String SPECIFIC_TEST_PLAN_URI = TEST_PLAN_URI + "/%d";
}
