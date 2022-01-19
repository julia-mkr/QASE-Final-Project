package api.adapters;

import api.objects.defectObjects.CreateDefect;
import api.objects.defectObjects.Result;
import io.restassured.response.Response;

public class DefectAdapter extends BaseAdapter {

    public int createDefect(String projectCode, CreateDefect defect) {
        return post(String.format(DEFECT_URI, projectCode), converter.toJson(defect, CreateDefect.class))
                .body().path("result.id");
    }

    public Result getSpecificDefect(String projectCode, int id) {
        Response response = get(String.format(SPECIFIC_DEFECT_URI, projectCode, id));
        return response.body().jsonPath().getObject("result", Result.class);
    }

    public void resolveSpecificDefect(String projectCode, int id) {
        patch(String.format(RESOLVE_SPECIFIC_DEFECT_URI, projectCode, id));
    }

    public void updateSpecificDefectStatus(String projectCode, int id, CreateDefect defect) {
        patch(String.format(UPDATE_SPECIFIC_DEFECT_STATUS_URI, projectCode, id), gson.toJson(defect, CreateDefect.class));
    }
}
