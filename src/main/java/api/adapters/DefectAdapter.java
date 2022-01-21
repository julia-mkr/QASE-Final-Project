package api.adapters;

import api.objects.defectObjects.CreateDefect;
import api.objects.defectObjects.Result;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class DefectAdapter extends BaseAdapter {

    @Step("Create a defect with the title: {defect.title} and the actual result: '{defect.actualResult}' " +
            "using the project code: '{projectCode}")
    public int createDefect(String projectCode, CreateDefect defect) {
        return post(String.format(DEFECT_URI, projectCode), converter.toJson(defect, CreateDefect.class))
                .body().path("result.id");
    }

    @Step("Get a specific defect by id: '{id}' using the project code: '{projectCode}")
    public Result getSpecificDefect(String projectCode, int id) {
        Response response = get(String.format(SPECIFIC_DEFECT_URI, projectCode, id));
        return response.body().jsonPath().getObject("result", Result.class);
    }

    @Step("Resolve a specific defect by id: '{id}' using the project code: '{projectCode}")
    public void resolveSpecificDefect(String projectCode, int id) {
        patch(String.format(RESOLVE_SPECIFIC_DEFECT_URI, projectCode, id));
    }

    @Step("Update a defect status with id: '{id}' to '{defect.status}' using the project code: '{projectCode}")
    public void updateSpecificDefectStatus(String projectCode, int id, CreateDefect defect) {
        patch(String.format(UPDATE_SPECIFIC_DEFECT_STATUS_URI, projectCode, id), gson.toJson(defect, CreateDefect.class));
    }
}
