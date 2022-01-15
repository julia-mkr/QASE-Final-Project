package api.objects;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateTestCase {

    private String description;
    private String preconditions;
    private String postconditions;
    @SerializedName("title")
    private String testCaseTitle;
    private Integer priority;
    private Integer type;
    private Integer layer;
    private Integer automation;
}
