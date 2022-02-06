package test_data.apiTestData;

import api.objects.defectObjects.CreateDefect;

public interface ApiDefectData extends ApiConstants {

    CreateDefect API_DEFECT_DATA_1 = CreateDefect.builder()
            .title("The 503 error appears after clicking on 'Proceed to checkout' button")
            .actualResult("After clicking on 'Proceed to checkout' button, the user is getting the 503 error message" +
                    "and after refreshing the page the user is logged out")
            .severity(1)
            .milestone(1)
            .build();

    CreateDefect API_DEFECT_DATA_2 = CreateDefect.builder()
            .title("The 'Contacts' link on the navigation main isn't clickable")
            .actualResult("After clicking on the 'Contact' link, nothing happens")
            .severity(5)
            .milestone(1)
            .build();

    CreateDefect API_DEFECT_DATA_3 = CreateDefect.builder()
            .title("The 'Log out' button in the user menu isn't clickable")
            .actualResult("After clicking on the 'Log out' button, the user is redirected to the homepage")
            .severity(3)
            .milestone(1)
            .build();

    CreateDefect UPDATE_DEFECT_STATUS = CreateDefect.builder()
            .status("in_progress")
            .build();
}
