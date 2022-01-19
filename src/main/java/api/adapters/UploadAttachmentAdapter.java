package api.adapters;

import api.objects.uploadFileObjects.Result;
import io.restassured.response.Response;

public class UploadAttachmentAdapter extends BaseAdapter {

    public String uploadAttachment(String projectCode, String file) {
       return postAttachment(String.format(ATTACHMENT_URI, projectCode), file).body().path("result[0].hash");
    }

    public boolean isAttachmentUploaded(String hash) {
        Response response = get(String.format(ATTACHMENT_URI, hash));
        return response.body().jsonPath().getObject("result", Result.class).getHash().contains(hash);
    }
}
