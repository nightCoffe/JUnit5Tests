package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

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

    static Stream<Arguments> withMethodTest() {
        return Stream.of(
                Arguments.of("Ладога-РК"),
                Arguments.of("ИПП-ИК-УФ-Ех")
        );
    }

    @MethodSource
    @DisplayName("Поиск в rielta.ru")
    @Tag("blocker")
    @ParameterizedTest(name = "Поиск в rielta.ru слова {0} и {1}")
    void withMethodTest(String searchQuery) {
        openUrl();
        $("#mod-search-searchword147").setValue(searchQuery).pressEnter();
        $(".search-results").shouldHave(Condition.text((searchQuery)));
    }

    @EnumSource(SearchQuery.class)
    @DisplayName("Поиск в rielta.ru")
    @Tag("blocker")
    @ParameterizedTest(name = "Поиск в rielta.ru слова {0} и {1}")
    void withEnumSourceTest(SearchQuery searchQuery) {
        openUrl();
        $("#mod-search-searchword147").setValue(String.valueOf(searchQuery.getValue())).pressEnter();
        $(".search-results").shouldHave(Condition.text(String.valueOf((searchQuery.getValue()))));
    }

    @ArgumentsSource(Params.class)
    @DisplayName("Поиск в rielta.ru")
    @Tag("blocker")
    @ParameterizedTest(name = "Поиск в rielta.ru слова {0} и {1}")
    void withArgumentSourceTest(String searchQuery) {
        openUrl();
        $("#mod-search-searchword147").setValue(searchQuery).pressEnter();
        $(".search-results").shouldHave(Condition.text((searchQuery)));
    }

    static class Params implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of("Ладога-РК"),
                    Arguments.of("ИПП-ИК-УФ-Ех")
            );
        }
    }

    @CsvSource({"Ладога-РК" , "ИПП-ИК-УФ-Ех"})
    @DisplayName("Поиск в rielta.ru")
    @Tag("blocker")
    @ParameterizedTest(name = "Поиск в rielta.ru слова {0} и {1}")
    void withCsvSourceTest(String searchQuery) {
        openUrl();
        $("#mod-search-searchword147").setValue(searchQuery).pressEnter();
        $(".search-results").shouldHave(Condition.text((searchQuery)));
    }

    @CsvFileSource(resources = "/dataValue.csv", numLinesToSkip = 1)
    @DisplayName("Поиск в rielta.ru")
    @Tag("blocker")
    @ParameterizedTest(name = "Поиск в rielta.ru слова {0} и {1}")
    void withCsvFileSourceTest(String searchQuery) {
        openUrl();
        $("#mod-search-searchword147").setValue(searchQuery).pressEnter();
        $(".search-results").shouldHave(Condition.text((searchQuery)));
    }

}
