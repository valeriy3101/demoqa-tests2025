package com.github.tests;

import com.codeborne.selenide.*;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Snippets {

    void browser_command_example(){

        open("https://yandex.ru");
        open("/customer/orders"); // в том случае, если используется несколько сред для тестирования, где url будет одинаковый в начале
        open("/", AuthenticationType.BASIC, "user", "password");

        Selenide.back(); //имитирует нажатие кнопки Назад в браузере
        Selenide.refresh(); //обновляет страницу

        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();

        Selenide.closeWebDriver(); // close browser completely
        Selenide.closeWindow(); // close active tab (окно)

        Selenide.confirm(); // для нажатия "Ok" в Alert-окнах ON in alert dialogs
        Selenide.dismiss(); // Cancel in alert dialogs

        Selenide.switchTo().frame("new"); //переключает нас во frame
        Selenide.switchTo().defaultContent(); //вернуться к странице по умолчанию из фрейма

        Selenide.switchTo().window("The internet"); // для перехода в другое окно браузера. Например, в тесте нажимаем кнопку и появилось окно, и нам нужно перейти в него
    }

    void selector_examples(){

        $("div").click(); //по умолчанию ищем 1-ый div
        element("div").click(); // синоним $

        $("div", 2).click(); // ищет определённый div в зависимости от индекса

        $x("//h1/div").click();//поиск по x-path
        $(byXpath("//h1/div")).click();

        $(byText("full text")).click();
        $(withText("ull tex")).click();

        $("").parent();
        $("").sibling(1);
        $("").preceding(2);

        $("div").$("h1").find(byText("abc")).click();

        //very optional
        $(byAttribute("abc", "x")).click();
        //то же самое, что
        $("[abc=x").click();

        $("[abc^=x").click(); // ^ - символ говорит о том, что элемент, который начинается с ABC называется X

        $(byId("mytext")).click();
        $("#mytext").click();

        $(byClassName("red")).click();
        $(".red").click();
    }

    void actions_examples(){
        $("").click();
        $("").doubleClick();
        $("").contextClick(); //клик правой кнопкой мыши

        $("").setValue("text"); //вводит текст
        $("").setValue(""); // очищает поле
        $("").clear(); // похоже на команду выше, но хуже, могут быть баги

        $("").hover();
        $("").append("text_add"); // добавляет текст в поле, в котором уже что-то написано

        // скролл команда используется, когда необходимо использовать какой-то внутренний скролл, а не общий по странице
        $("").scrollTo();

        // Для работы с горячими клавишами

        $("div").sendKeys("c");
        actions().sendKeys("c").perform();
        actions().sendKeys(Keys.chord(Keys.CONTROL, "f")).perform(); // CTRL+F
        $("html").sendKeys(Keys.chord(Keys.CONTROL, "f"));

        $("").pressEnter();
        $("").pressEscape();
        $("").pressTab();

        $("").dragAndDrop($(""));

        actions().moveToElement($("div")).clickAndHold().moveByOffset(300,200).release().perform();
        //к примеру, когда нужно зажать мышку и зажатой повести её вправо (x),затем опустить вниз (y) и отпустить мышку (выделение области, к примеру)

        $("").selectOption("dropdown_option");
        $("").selectRadio("radio_options");
    }

    void assertions_examples(){
        $("").shouldBe(visible);
        $("").should(Condition.appear);
        $("").shouldHave(Condition.text("abc")); // should и shouldHave одно и то же
        $("").shouldNotBe(visible);
        $("").shouldNotHave(Condition.text("abc"));
        $("").shouldNot(appear);

        // С длинными тайм-аутами
        $("").shouldBe(visible, Duration.ofSeconds(30));
    }

    //CTRL+SHIFT+"-" / "+"

    void conditions_examples(){
        $("").shouldBe(visible);
        $("").shouldBe(hidden);

        $("").shouldHave(text("abc")); // проверяет на вхождение и игнорирует CaseCamel
        $("").shouldHave(exactText("abc")); // точный текст, совпадение один в один
        $("").shouldHave(textCaseSensitive("abc")); //регистр должен совпадать
        $("").shouldHave(exactTextCaseSensitive("abc")); //и текст, и регистр
        $("").should(matchText("[0-9]abc$"));

        $("").shouldHave(cssClass("red"));
        $("").shouldHave(cssValue("font-size", "12")); //проверяет реальные свойства объекта

        $("").shouldHave(value("25"));
        $("").shouldHave(exactValue("25"));
        $("").shouldBe(value(empty)); //проверка, что ничего не находится

        $("").shouldHave(attribute("disabled"));
        $("").shouldHave(attribute("disabled", "example"));
        $("").shouldHave(attributeMatching("disabled", "[0-9]abc$"));

        $("").shouldBe(checked); // for checkboxes

        //Warning! Only check if it is in DOM, not if it is visible! You don't need it in most tests!
        $("").should(exist);

        //Warning! Checks only the "disabled" attribute! Will not work with many modern frameworks
        $("").shouldBe(disabled);
        $("").shouldBe(enabled);
    }

    void collections_examples(){
        $$("div");

        //selections

        $$("div").filterBy(text("123")).shouldHave(size(1));
        $$("div").excludeWith(text("123")).shouldHave(size(1)); //выкидывает те элементы, в которых есть 123

        $$("div").first().click();
        elements("div").first().click();
        $$("div").last().click();
        $$("div").get(1).click(); // the second! (start with 0);
        $$("div").findBy(text("123")).click(); //finds first

        //assertions
        $$("").shouldHave(size(0));
        $$("").shouldBe(empty); //the same

        $$("").shouldHave(texts("Alfa", "Beta", "Gamma")); // проверяет на точное совпадение по названиям и кол-ву элементов
        $$("").shouldHave(exactTexts("Alfa", "Beta", "Gamma"));

        $$("").shouldHave(textsInAnyOrder("Alfa", "Beta", "Gamma"));
        $$("").shouldHave(exactTextsCaseSensitiveInAnyOrder("Alfa", "Beta", "Gamma"));

        $$("").shouldHave(itemWithText("Alfa")); //ищет только один текст

        //когда нужны проверки на то, что когда-то было такое-то кол-во элементов, и оно либо осталось, либо нет

        $$("").shouldHave(sizeGreaterThan(0));
        $$("").shouldHave(sizeGreaterThanOrEqual(1));
        $$("").shouldHave(sizeLessThan(3));
        $$("").shouldHave(sizeLessThanOrEqual(2));
    }

    void file_operation_examples(){
        File file1 = $("a.fileLink").download(); //only for <a href="..">Links
        File file2 = $("div").download(DownloadOptions.using(FileDownloadMode.FOLDER));

        File file = new File ("src/test/resources/readme.txt");
        $("#file-upload").uploadFile(file);
        $("$#file-upload").uploadFromClasspath("readme.txt");
        //don't forget to submit!
        $("uploadButton").click();
    }

    void javascript_examples(){
        executeJavaScript("alert('selenide')");
        executeJavaScript("alert(arguments[B]+arguments[1])", "abc", 12);
        long fortytwo = executeJavaScript("return arguments[0]*arguments[1];",6,7);
    }
}
