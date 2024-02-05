package ui_module.constants;

public enum UiEndpoints {
    PITER("https://piter-online.net/");

    private final String url;

    UiEndpoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
