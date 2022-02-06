package test_data;

import ui.objects.InvitationOfNewUser;

public interface InvitesTestData {

    String EXPECTED_EMPTY_EMAIL_ERROR = "Sorry, but email can`t be empty";
    String EXPECTED_EMPTY_ROLE_TITLE_ERROR = "Sorry, but role title can`t be empty";
    String EXPECTED_INVALID_EMAIL_ERROR = "Sorry, but this email is not valid";

    InvitationOfNewUser DATA_FOR_INVITATION_OF_NEW_USER_1 = InvitationOfNewUser.builder()
            .email("mel.anderson53@mail.ru")
            .name("Melanie Anderson")
            .roleTitle("Senior QA")
            .build();

    InvitationOfNewUser DATA_FOR_INVITATION_OF_NEW_USER_2 = InvitationOfNewUser.builder()
            .email("")
            .name("Karen Black")
            .roleTitle("")
            .build();

    InvitationOfNewUser DATA_FOR_INVITATION_OF_NEW_USER_3 = InvitationOfNewUser.builder()
            .email("john_doegmail.com")
            .name("John Doe")
            .roleTitle("Senior Java Developer")
            .build();
}
