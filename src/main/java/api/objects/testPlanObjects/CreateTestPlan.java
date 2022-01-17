package api.objects.testPlanObjects;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class CreateTestPlan {

    private String title;
    private String description;
    private ArrayList<Integer> cases;
}
