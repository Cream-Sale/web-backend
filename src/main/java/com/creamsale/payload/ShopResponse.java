package com.creamsale.payload;

public class ShopResponse {

    private final Long id;
    private final String name;
    private final String link;
    private final String imgLink;

    public ShopResponse(Long id, String name, String link, String imgLink) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.imgLink = imgLink;
    }

    public Long getId() {
        return id;
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
