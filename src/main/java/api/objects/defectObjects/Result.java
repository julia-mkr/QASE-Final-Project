package api.objects.defectObjects;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Result {

    private String title;
    @SerializedName("actual_result")
    private String actualResult;
    private String severity;
    private String status;
    @SerializedName("milestone_id")
    private Integer milestoneId;
}
