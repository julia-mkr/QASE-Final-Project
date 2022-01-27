package testData;

import ui.objects.Milestone;

public interface MilestoneTestData {

    Milestone DATA_FOR_TEST_MILESTONE_1 = Milestone.builder()
            .milestoneName("Release 2.5")
            .description("This is a milestone for Release 2.5. By the end of this term we should finish the sign-out feature.")
            .build();

    Milestone DATA_FOR_TEST_MILESTONE_2  = Milestone.builder()
            .milestoneName("Release 2,3")
            .description("This is a milestone for Release 2.3.")
            .status("Completed")
            .dueDate("2022-01-30")
            .build();
}
