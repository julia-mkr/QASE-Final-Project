package api.adapters;

import api.objects.uploadFileObjects.Root;

public class UploadAttachmentAdapter extends BaseAdapter {

    public String uploadAttachment(String projectCode, String file) {
       return postAttachment(String.format(ATTACHMENT_URI, projectCode), file).body().path("result[0].hash");
    }

    public boolean isAttachmentUploaded(String hash) {
        String body = get(String.format(ATTACHMENT_URI, hash));
        Root root = converter.fromJson(body, Root.class);
        return root.getResult().getHash().contains(hash);
    }
}
