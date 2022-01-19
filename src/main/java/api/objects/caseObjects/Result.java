package api.objects.caseObjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

    private int id;
    private String title;
    private String description;
    private String preconditions;
    @JsonProperty("postconditions")
    private String postConditions;
    private int severity;
    private int priority;
    private int type;
    private int layer;
    @JsonProperty("is_flaky")
    private int isFlaky;
    private int behavior;
    private int automation;
    @JsonProperty("milestone_id")
    private int milestoneId;
}
