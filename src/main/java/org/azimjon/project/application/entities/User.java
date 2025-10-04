package org.azimjon.project.application.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.azimjon.project.core.utils.enums.Month;
import org.azimjon.project.core.utils.enums.Title;


@Getter
@Setter
@Builder
@AllArgsConstructor
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Title title;
    private String dayOfBirth;
    private Month monthOfBirth;
    private String yearOfBirth;
    private boolean isNewsletterEnabled;
}
