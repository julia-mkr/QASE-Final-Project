package ui.objects;

import lombok.*;

@Data
@Builder
public class Defect {
    private String defectTitle;
    private String actualResult;
    private String milestones;
    private String severity;
    private String assignee;
}
