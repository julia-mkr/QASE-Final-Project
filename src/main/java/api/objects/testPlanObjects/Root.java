package api.objects.testPlanObjects;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Root {

    @Expose
    private Boolean status;
    private Result result;
}
