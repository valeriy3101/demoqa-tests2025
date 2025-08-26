package com.github.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import io.github.bonigarcia.wdm.WebDriverManager;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {
    @BeforeAll
    static void beforeAll(){
        //WebDriverManager.chromedriver().setup();
        Configuration.browserSize="maximize";
        Configuration.baseUrl="https://demoqa.com";
    }

    @Test
    void PtForm(){
        open("/automation-practice-form");
        $("#firstName").setValue("Valeriy");
        $("#lastName").setValue("Romanovskiy");
        $("#userEmail").setValue("trasikVdatsunes@yandex.ru");
        $("#genterWrapper").$(byText("Male")).click();
        //$(byText("Other")).parent().click();
        //$(".custom-control-label").click();
        $("#userNumber").setValue("3123312333");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1995");
        $(".react-datepicker__month-select").selectOptionByValue("0");
        $(byText("31")).click();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("moon.jpg");
        $("#currentAddress").setValue("Test");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Gurgaon").pressEnter();
        $("#submit").scrollTo().click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(byText("Student Name")).shouldHave(text("Valeriy Romanovskiy"));
    }
}
