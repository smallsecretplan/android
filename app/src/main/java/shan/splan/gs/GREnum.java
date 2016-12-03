package shan.splan.gs;

/**
 * Created by chrisweng on 2016/12/3.
 */

public enum GREnum {

    a("113婦女保護專線", "113"),
    b("家庭暴力防治網", "http://www.tapdv.tw/"),
    c("自殺防治安心專線", "0800788955"),
    d("張老師專線", "1980"),
    e("生命線", "1995"),
    f("勵馨基金會", "https://www.goh.org.tw/tc/index.asp");

    private final String title;
    private final String url;

    GREnum(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
