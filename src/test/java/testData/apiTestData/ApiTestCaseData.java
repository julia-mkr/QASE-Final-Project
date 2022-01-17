package testData.apiTestData;

import api.objects.caseObjects.CreateTestCase;

import java.util.ArrayList;
import java.util.Collections;

public interface ApiTestCaseData extends ApiConstants {

    CreateTestCase API_CASE_DATA_1 = CreateTestCase.builder()
            .testCaseTitle("Register a new account as an admin")
            .description("Register a new account using a providing admin data")
            .preconditions("1. Go to the www.test-website;" +
                    " 2. Click on the 'Sign up' button and enter email: joe.smith@mail.com / password: qwerty;")
            .postconditions("Log out")
            .priority(1)
            .type(1)
            .layer(2)
            .behavior(2)
            .isFlaky(1)
            .milestoneId(2)
            .automation(1)
            .build();

    CreateTestCase API_CASE_DATA_2 = CreateTestCase.builder()
            .testCaseTitle("Register a new account as a customer")
            .description("Register a new account using a providing customer data")
            .preconditions("1. Go to the www.test-website;" +
                    " 2. Click on the 'Sign up' button and enter email: martha_white@mail.com / password: qwerty;")
            .postconditions("Log out")
            .priority(1)
            .attachments(new ArrayList<>(Collections.singletonList("727f126d0be04084428ca75872e5973a3c790d6a")))
            .build();
}
