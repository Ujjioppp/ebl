package org.ebl.domain;

/**
 * Created by yeli on 07/07/2017.
 */
//@Component
//@ConfigurationProperties(prefix = "webConfig")
public class WebConfig {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
