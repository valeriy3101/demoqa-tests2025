package com.github.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
//import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;


public class SelenideSearch {
    @Test
    void shouldFindSelenideRepositoryPage(){
        //Configuration.browser = "chrome";

        // Открыть страницу github.com;
        open("https://github.com");

        //Первый вариант нажатия кнопки Поиск
        //$(".header-search-button").click();
        //второй вариант нажатия кнопки Поиск. В квадратные скобки [] помещаем тот элемент, который хотим найти
        $("[placeholder='Search or jump to...']").click();

        // Ввести в поле поиска "selenide" и нажать "Enter"
        $("#query-builder-test").setValue("selenide").pressEnter();

        // Нажимаем линк от первого результата поиска;
        $("[data-testid='results-list']").$(".prc-Link-Link-85e08").click();
        sleep(10000);
        // Проверка (check) в заголовке встречается selenide/selenide
        $("#repo-content-pjax-container").should(Condition.text("Concise UI Tests with Java!"));
//        $("h1").should(Condition.text("selenide / selenide"));
        sleep(10000);
    }

}
