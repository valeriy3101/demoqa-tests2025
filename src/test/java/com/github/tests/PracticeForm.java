package com.github.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeForm {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize="maximize";
    }

    @Test
    void PtForm(){
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Valeriy");
        $("#lastName").setValue("Romanovskiy");
        $("#userEmail").setValue("trasikVdatsunes@yandex.ru");
        $(".custom-control-label").click();
        $("#userNumber").setValue("3123312333");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1995");
        $(".react-datepicker__month-select").selectOptionByValue("0");
        $(byText("31")).click();
        $("#submit").click();
        //$(".react-datepicker__day react-datepicker__day--031").click();
    }
}
