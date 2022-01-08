package ui.objects;

import lombok.*;

@Data
@Builder
public class Milestone {
    String milestoneName;
    String description;
    String status;
    String dueData;
}
