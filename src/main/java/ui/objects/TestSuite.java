package ui.objects;

import lombok.*;

@Data
@Builder
public class TestSuite {
    private String suiteName;
    private String description;
    private String preCondition;
}
