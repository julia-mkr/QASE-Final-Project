package testData;

import ui.objects.TestSuite;

public interface TestSuiteData {

    TestSuite DATA_FOR_TEST_SUITE_1 = TestSuite.builder()
            .suiteName("Smoke Tests for the app")
            .build();

    TestSuite DATA_FOR_TEST_SUITE_2 = TestSuite.builder()
            .suiteName("Regression Tests")
            .description("Description of the suite")
            .preCondition("Some preconditions for this test suite")
            .build();
}
