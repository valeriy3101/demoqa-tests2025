package com.github.tests;

//import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import io.github.bonigarcia.wdm.WebDriverManager;

//import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
//import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {
    @BeforeAll
    static void beforeAll(){
        //WebDriverManager.chromedriver().setup();
        Configuration.browserSize="1920x1080";
        Configuration.baseUrl="https://demoqa.com";
    }

    @Test
    void PtForm(){
        open("/automation-practice-form");
        $(byText("Practice Form")).shouldBe(visible, Duration.ofSeconds(10));
        $("#firstName").setValue("Valeriy");
        $("#lastName").setValue("Romanovskiy");
        $("#userEmail").setValue("trasikVdatsunes@yandex.ru");
        $("#genterWrapper").$(byText("Male")).click();
        //$(byText("Other")).parent().click();
        //$(".custom-control-label").click();
        //$("label[for='gender-radio-1']").click();
        //$$("label.custom-contril-label").filter(text("Other")).get(0).click();
        $("#userNumber").setValue("3123312333");
        $("#dateOfBirthInput").click();
        //$(".react-datepicker__year-select").selectOptionByValue("1995");
        $(".react-datepicker__year-select").selectOption("2005");
        //$(".react-datepicker__month-select").selectOptionByValue("0");
        $(".react-datepicker__month-select").selectOption("July");
        //$(byText("31")).click();
        $(".react-datepicker__day--028:not(.react-datepicker__day--outside-month)").click(); // выберет такое число 28, которое не содержит класс "outside-month"
        // $$ - массив элементов, возвращает все элементы
        //$$(".react-datepicker__day--028").filter(not(cssClass("react-datepicker__day--outside-month"))).first().click();
        //$x("//div[contains(@aria-label,\"June 28th, 2005\")]").click(); //*-любой элемент, но напишем div
        // [] означают, что будут указывать атрибут и его значения
        //contains Не работает для css-селекторов, только для xpath

        $("#subjectsInput").setValue("Chemistry").pressEnter();

        //$("label[for='hobbies-checkbox-1']").click();
        $("#hobbiesWrapper").$(byText("Reading")).click();

        $("#uploadPicture").uploadFromClasspath("moon.jpg");
        //$("#uploadPicture").uploadFromClasspath("img/moon.jpg"); если файл в папке
        //$("#uploadPicture").uploadFile(new File("src/test/resources/moon.jpg"));

        $("#currentAddress").setValue("Test");

        $("#react-select-3-input").setValue("NCR").pressEnter();
        //$("#stateCity-wrapper").$(byText("NCR")).click();

        $("#react-select-4-input").setValue("Gurgaon").pressEnter();
        $("#submit").scrollTo().click();

        //$(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text("Valeriy Romanovskiy"), text("trasikVdatsunes@yandex.ru"), text("Male"), text("3123312333"), text("28 July,2005"), text("Chemistry"), text("Reading"), text("moon.jpg"), text("Test"), text("NCR Gurgaon"));
        //$(".table-responsive").$(byText("Student Name")).shouldHave(text("Valeriy Romanovskiy"));
        //$x("//td[text()='Student Name']").parent().shouldHave(text("Valeriy Romanovskiy"));

        $("#closeLargeModal").click();
    }
}
