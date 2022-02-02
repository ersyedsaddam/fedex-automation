package pages;

public class FedexPageFactory {

    public static LoginPage loginPage() {
        return new LoginPage();
    }

    public static LoginPage loginPage(String language) {
        return new LoginPage(language);
    }

    public static SitePopupHandler sitePopupHandler() {
        return new SitePopupHandler();
    }
}
