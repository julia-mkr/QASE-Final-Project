package ui.objects;

import lombok.*;

@Data
@Builder
public class TestSuite {
    String suiteName;
    String description;
    String preCondition;
}
