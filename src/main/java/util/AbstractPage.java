package util;

public class AbstractPage {
    public SeleniumExecutor executor = SeleniumExecutor.getExecutor();
    private String url;

    public AbstractPage() {

    }

    public void openPage() {
        url = SeleniumExecutor.pageDefaultUrl;
        executor.openPage(url);
    }
}
