package com.github.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fullFormTest() {
        String permanentAddress = "Russia";

        open("https://demoqa.com/text-box");
        $("#userName").setValue("Romanovskiy Valeriy Dmitrievich");
        $("#userEmail").setValue("valeriy@yandex.ru");
        $("#currentAddress").setValue("Yaroslavl, Trufanova street");
        $("#permanentAddress").setValue("Russia");
        $("#submit").click();

        $("#output #name").shouldHave(text("Romanovskiy Valeriy Dmitrievich"));
        $("#output #email").shouldHave(text("valeriy@yandex.ru"));
        $("#output #currentAddress").shouldHave(text("Yaroslavl, Trufanova street"));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));
    }
}
