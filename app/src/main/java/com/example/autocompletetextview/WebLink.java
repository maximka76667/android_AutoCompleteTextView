package com.example.autocompletetextview;

public class WebLink {

    protected String name, link;

    WebLink(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return name;
    }
}
