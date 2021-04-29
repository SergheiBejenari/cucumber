package enums;

import utils.PropertyReader;

public enum Pages {

    HOME_PAGE("Home Page", PropertyReader.applicationProperties().getProperty("base.url")),
    ABOUT_THE_BANK("About The Bank", HOME_PAGE.getUrl() + "desre-banca/"),
    LOGIN_PAGE("Log In Page" ,HOME_PAGE.getUrl() + "BankFlexPB/(S(v34rnp3gj4n20to2ccwzhg4k))/Login.aspx?locale=en-EN"),
    P2P_PAGE("P2P", "https://p2p.maib.md/en"),
    INTERNET_BANKING_PAGE("Internet banking", "https://personal.maib.md/BankFlexPB/(S(0zmuyiwyqzg51etlu2gxpdik))/Login.aspx?locale=ro-RO"),
    ACCOUNT_STATEMENT_PAGE("Account statement", "https://personal.maib.md/BankFlexPB/(S(w0esisalsnmusi511c1nummu))/home");

    private final String pageName;

    private final String url;

    Pages(final String pageName, final String page) {
        this.pageName = pageName;
        this.url = page;
    }

    public static String getUrlByPageName(String name) {
        for (Pages page : values()) {
            if (page.getPageName().equals(name)) {
                return page.getUrl();
            }
        }
        return null;
    }

    public String getPageName() {
        return pageName;
    }

    public String getUrl() {
        return url;
    }
}
