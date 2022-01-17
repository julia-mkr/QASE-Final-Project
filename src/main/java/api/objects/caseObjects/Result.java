package api.objects.caseObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Result {

    @Expose
    private int id;
    @Expose
    private String title;
    @Expose
    private String description;
    @Expose
    private String preconditions;
    @Expose
    @SerializedName("postconditions")
    private String postConditions;
    @Expose
    private int severity;
    @Expose
    private int priority;
    @Expose
    private int type;
    @Expose
    private int layer;
    @Expose
    @SerializedName("is_flaky")
    private int isFlaky;
    @Expose
    private int behavior;
    @Expose
    private int automation;
    @Expose
    @SerializedName("milestone_id")
    private int milestoneId;
}
