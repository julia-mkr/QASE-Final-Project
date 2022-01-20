package ui.objects;

import lombok.*;

@Data
@Builder
public class Milestone {
    private String milestoneName;
    private String description;
    private String status;
    private String dueDate;
}
