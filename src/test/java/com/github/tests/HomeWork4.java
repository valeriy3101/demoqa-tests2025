package com.github.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork4 {

    @Test
    void ClickSoftAssertionsCheckJUnitCode(){
        //Открыть страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        //Перейти в раздел WIKI-проекта
        $("#wiki-tab").click();
        //Убедиться, что в списке страниц (Pages) есть страница SoftAssertions
        //$(byText("SoftAssertions")).shouldBe(exist);
        SelenideElement element = $(byText("SoftAssertions")).shouldBe(exist).shouldNotBe(visible); //Этот подход гарантирует, что элемент есть в DOM и при этом не отображается пользователю.
        //Перейти на страницу SoftAssertions;
        $(".wiki-more-pages-link .js-wiki-more-pages-link").click();
        $(byText("SoftAssertions")).click();
        //Убедиться, что внутри есть пример JUnit5 кода
        $("#wiki-content").shouldHave(text("Using JUnit5 extend test class"));
        sleep(5000);
    }
}
