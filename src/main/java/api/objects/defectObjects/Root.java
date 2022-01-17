package api.objects.defectObjects;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Root {

    @Expose
    private Boolean status;
    private Result result;
}
