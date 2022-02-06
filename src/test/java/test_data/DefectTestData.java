package test_data;

import ui.objects.Defect;

public interface DefectTestData {

    String RESOLVED_DEFECT_STATUS = "Resolved";

    Defect DATA_FOR_TEST_DEFECT_1 = Defect.builder()
            .defectTitle("The Search field does not search anything")
            .actualResult("Nothing happens after typing a word into the Search field and pressing Enter")
            .build();

    Defect DATA_FOR_TEST_DEFECT_2 = Defect.builder()
            .defectTitle("There is a 504 error after clicking on the button Login")
            .actualResult("The user can not log in to the website")
            .milestones("Release 2.9")
            .severity("Blocker")
            .assignee("Maya")
            .build();

    Defect DATA_FOR_TEST_DEFECT_3 = Defect.builder()
            .defectTitle("There is a typo on the homepage")
            .actualResult("The word Desssert is misspelled")
            .build();

    Defect DATA_FOR_TEST_DEFECT_4 = Defect.builder()
            .defectTitle("The user can not register using Gmail emails")
            .actualResult("The user gets the error warning that uses an invalid email")
            .severity("Critical")
            .build();
}
