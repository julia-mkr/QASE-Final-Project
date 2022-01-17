package api.objects.caseObjects;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Root {

    private Boolean status;
    @Expose
    private Result result;
}
