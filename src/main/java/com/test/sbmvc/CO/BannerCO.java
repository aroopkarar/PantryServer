package com.test.sbmvc.CO;

public class BannerCO {
    private Long id;
    private String name;
    private String imageUrl;
    private boolean enabled;
    private String redirectionUrl;
    private String bannerParam;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRedirectionUrl() {
        return redirectionUrl;
    }

    public void setRedirectionUrl(String redirectionUrl) {
        this.redirectionUrl = redirectionUrl;
    }

    public String getBannerParam() {
        return bannerParam;
    }

    public void setBannerParam(String bannerParam) {
        this.bannerParam = bannerParam;
    }
}
