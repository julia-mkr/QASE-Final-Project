package api.adapters;

import api.objects.uploadFileObjects.Result;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class UploadAttachmentAdapter extends BaseAdapter {

    @Step("Upload the '{file}' file using API")
    public String uploadAttachment(String projectCode, String file) {
       return postAttachment(String.format(ATTACHMENT_URI, projectCode), file).body().path("result[0].hash");
    }

    @Step("Verify, that the hash of the attached file: '{hash}' is equal to the uploaded file")
    public boolean isAttachmentUploaded(String hash) {
        Response response = get(String.format(ATTACHMENT_URI, hash));
        return response.body().jsonPath().getObject("result", Result.class).getHash().contains(hash);
    }
}
