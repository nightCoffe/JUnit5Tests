package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;

public class JUnitAnnotationTests extends TestBase {

    @ValueSource(strings = {"Ладога-РК", "ИПП-ИК-УФ-Ех"})
    @DisplayName("Поиск в rielta.ru")
    @Tag("blocker")
    @ParameterizedTest(name = "Поиск в rielta.ru слова {0} и {1}")
    void withValueSourceTest(String searchQuery) {
        openUrl();
        $("#mod-search-searchword147").setValue(searchQuery).pressEnter();
        $(".search-results").shouldHave(Condition.text(searchQuery));
    }

    static Stream<Arguments> withMethodSourceTest() {
        return Stream.of(
                Arguments.of("Ладога-РК"),
                Arguments.of("ИПП-ИК-УФ-Ех")
        );
    }

    @MethodSource
    @DisplayName("Поиск в rielta.ru")
    @Tag("blocker")
    @ParameterizedTest(name = "Поиск в rielta.ru слова {0} и {1}")
    void withMethodSourceTest(String searchQuery) {
        openUrl();
        $("#mod-search-searchword147").setValue(searchQuery).pressEnter();
        $(".search-results").shouldHave(Condition.text((searchQuery)));
    }

}
