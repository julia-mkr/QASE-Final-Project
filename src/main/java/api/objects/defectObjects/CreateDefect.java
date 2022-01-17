package api.objects.defectObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateDefect {

    private String title;
    @SerializedName("actual_result")
    private String actualResult;
    private Integer severity;
    @SerializedName("milestone_id")
    private Integer milestone;
    @Expose
    private String status;
}
