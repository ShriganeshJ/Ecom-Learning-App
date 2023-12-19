package com.ecom.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document("SDVS")
public class AccountDataResponse {


    @Id
    private String id;

    private String session;
    private String platform;
    private UserInfo userInfo;

    @Override
    public String toString() {
        return "AccountDataResponse{" +
                "id='" + id + '\'' +
                ", session='" + session + '\'' +
                ", platform='" + platform + '\'' +
                ", userInfo=" + userInfo +
                ", pricePanelTabs=" + pricePanelTab +
                '}';
    }

    private List<PricePanelTab> pricePanelTab;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<PricePanelTab> getPricePanelTabs() {
        return pricePanelTab;
    }

    public void setPricePanelTabs(List<PricePanelTab> pricePanelTabs) {
        this.pricePanelTab = pricePanelTabs;
    }


}
