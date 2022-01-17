package api.objects.caseObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class CreateTestCase {

    @Expose
    private String description;
    private String preconditions;
    private String postconditions;
    @Expose
    @SerializedName("title")
    private String testCaseTitle;
    @Expose
    private Integer priority;
    private Integer type;
    private Integer layer;
    private Integer automation;
    @SerializedName("is_flaky")
    private int isFlaky;
    private int behavior;
    @SerializedName("milestone_id")
    private int milestoneId;
    @Expose
    private ArrayList<String> attachments;
}
