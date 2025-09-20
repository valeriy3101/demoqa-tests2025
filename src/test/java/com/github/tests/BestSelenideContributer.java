package com.github.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BestSelenideContributer {

    @Test
    void andreiSolntsevBestContributer(){
        //Открыть нужную страницу с проектом Selenide
        open("https://github.com/selenide/selenide");
        //Навести курсор на первый элемент в области Contributers
        $(".BorderGrid").$(byText("Contributors")).closest("div").$("ul li").hover();
//        $(".Popover-message").should(Condition.text("Andrei Solntsev"));
        //Второй вариант через shouldHave
        $(".Popover-message").shouldHave(Condition.text("Andrei Solntsev"));
        sleep(10000);
    }
}