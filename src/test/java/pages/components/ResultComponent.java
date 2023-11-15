package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {
    public ResultComponent checkResult(String value) {
        $(".table-responsive").shouldHave(text(value));
        return this;
    }

    public ResultComponent tableNotAvailable() {
        $(".table-responsive").shouldNotBe(visible);
        return this;
    }
}



