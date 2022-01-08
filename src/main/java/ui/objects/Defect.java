package ui.objects;

import lombok.*;

@Data
@Builder
public class Defect {
    String defectTitle;
    String actualResult;
    String milestones;
    String severity;
    String assignee;
}
