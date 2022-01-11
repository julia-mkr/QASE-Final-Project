package ui.objects;

import lombok.*;

@Data
@Builder
public class InvitationOfNewUser {
    private String email;
    private String name;
    private String roleTitle;
}
