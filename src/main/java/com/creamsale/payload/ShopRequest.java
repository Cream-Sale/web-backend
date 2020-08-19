package com.creamsale.payload;

public class ShopRequest {

    private final String name;
    private final String link;
    private final String imgLink;

    public ShopRequest(String name, String link, String imgLink) {
        this.name = name;
        this.link = link;
        this.imgLink = imgLink;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public String getImgLink() {
        return imgLink;
    }
}
