import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestCard {

    @Test
    void shouldSubmitRequest() {
        open("http://localhost:9999");
        $("[data-test-id = name] input").setValue("Иванов-Петров Иван");
        $("[data-test-id = phone] input").setValue("+79204444444");
        $("[class = checkbox__box]").click();
        $("[role = button]").click(); //
        $("[data-test-id = order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами " +
                "в ближайшее время."));
    }

    @Test
    void shouldWarningNotValidNameInput() {
        open("http://localhost:9999");
        $("[data-test-id = name] input").setValue("Ivanov Ivan");
        $("[data-test-id = phone] input").setValue("+79204444444");
        $("[class = checkbox__box]").click();
        $("[role = button]").click();
        //$("[data-test-id = name], [class = input_sub]").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только " +
        $(byText("Имя и Фамилия указаные неверно. Допустимы только " +
                "русские буквы, пробелы и дефисы.")).shouldBe(visible);
    }

    @Test
    void shouldWarningNotValidPhoneInput() {
        open("http://localhost:9999");
        $("[data-test-id = name] input").setValue("Иванов Иван");
        $("[data-test-id = phone] input").setValue("+7920444444488");
        $("[class = checkbox__box]").click();
        $("[role = button]").click();
        $(byText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.")).shouldBe(visible);
    }
}
