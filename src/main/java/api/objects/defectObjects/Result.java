package api.objects.defectObjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

    private String title;
    @JsonProperty("actual_result")
    private String actualResult;
    private String severity;
    private String status;
    @JsonProperty("milestone_id")
    private Integer milestoneId;
}
