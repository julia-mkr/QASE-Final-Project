package ui.objects;

import lombok.*;

@Data
@Builder
public class TestCase {
    private String title;
    private String status;
    private String description;
    private String suite;
    private String priority;
    private String type;
    private String layer;
    private String isFlaky;
    private String milestone;
    private String behavior;
    private String automationStatus;
    private String preConditions;
    private String postConditions;
    private String action;
    private String inputData;
    private String expectedResult;
}
