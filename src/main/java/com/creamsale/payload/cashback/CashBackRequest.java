package com.creamsale.payload.cashback;

public class CashBackRequest {

    private final String name;
    private final String link;
    private final String imgLink;

    public CashBackRequest(String name, String link, String imgLink) {
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
