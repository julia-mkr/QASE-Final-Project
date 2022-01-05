package ui.objects;

import lombok.*;

@Data
@Builder
public class TestCase {
    String title;
    String status;
    String description;
    String suite;
    String priority;
    String type;
    String layer;
    String isFlaky;
    String milestone;
    String behavior;
    String automationStatus;
    String preConditions;
    String postConditions;
    String action;
    String inputData;
    String expectedResult;
}
