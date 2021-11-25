package tests;

public enum SearchQuery {
    FIRST("Ладога-РК"),
    SECOND("ИПП-ИК-УФ-Ех");

    private final String value;

    SearchQuery(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
