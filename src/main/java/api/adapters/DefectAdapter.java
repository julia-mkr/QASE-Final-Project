package api.adapters;

import api.objects.defectObjects.CreateDefect;
import api.objects.defectObjects.Result;
import api.objects.defectObjects.Root;

public class DefectAdapter extends BaseAdapter {

    public int createDefect(String projectCode, CreateDefect defect) {
        return post(String.format(DEFECT_URI, projectCode), converter.toJson(defect, CreateDefect.class))
                .body().path("result.id");
    }

    public Result getSpecificDefect(String projectCode, int id) {
        String body = get(String.format(SPECIFIC_DEFECT_URI, projectCode, id));
        Root root = converter.fromJson(body, Root.class);
        return root.getResult();
    }

    public void resolveSpecificDefect(String projectCode, int id) {
        patch(String.format(RESOLVE_SPECIFIC_DEFECT_URI, projectCode, id));
    }

    public void updateSpecificDefectStatus(String projectCode, int id, CreateDefect defect) {
        patch(String.format(UPDATE_SPECIFIC_DEFECT_STATUS_URI, projectCode, id), gson.toJson(defect, CreateDefect.class));
    }
}
