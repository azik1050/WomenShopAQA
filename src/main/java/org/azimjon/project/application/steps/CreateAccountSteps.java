package org.azimjon.project.application.steps;

import io.qameta.allure.Step;
import org.azimjon.project.application.entities.User;
import org.azimjon.project.application.pages.CreateAccountPage;
import org.azimjon.project.application.pages.MyAccountPage;
import org.azimjon.project.core.utils.enums.Title;

public class CreateAccountSteps {
    private CreateAccountPage createAccountPage;

    public CreateAccountSteps() {
        createAccountPage = new CreateAccountPage();
    }

    @Step("Choose {title} title")
    public CreateAccountSteps chooseTitle(Title title) {
        switch (title) {
            case MRS:
                createAccountPage.clickFemaleRadioButton();
                break;
            case MR:
                createAccountPage.clickMaleRadioButton();
            default:
                break;
        }
        return this;
    }

    @Step("Fill first name with {user.getFirstName()}, " +
            "last name with {user.getLastName()} " +
            "password with {user.getPassword()}")
    public CreateAccountSteps fillUserDetails(User user) {
        createAccountPage
                .fillFirstNameInput(user.getFirstName())
                .fillLastNameInput(user.getLastName())
                .fillPasswordInput(user.getPassword());
        return this;
    }

    @Step("Select {user.getDayOfBirth()}/user.getMonthOfBirth()/user.getYearOfBirth() as date of birth")
    public CreateAccountSteps selectUserDOB(User user) {
        createAccountPage
                .selectBirthDay(user.getDayOfBirth())
                .selectBirthMonth(user.getMonthOfBirth().getIndex())
                .selectBirthYear(user.getYearOfBirth());
        return this;
    }

    @Step("Click registration button")
    public MyAccountPage clickRegisterButton() {
        createAccountPage.clickRegisterButton();
        return new MyAccountPage();
    }

    public CreateAccountSteps enableNewsletter(boolean isEnabled) {
        return this;
    }

    @Step("Register user {user.getFirstName()}")
    public MyAccountPage registerUser(User user) {
        return this.chooseTitle(user.getTitle())
                .fillUserDetails(user)
                .selectUserDOB(user)
                .enableNewsletter(user.isNewsletterEnabled())
                .clickRegisterButton();
    }

}
