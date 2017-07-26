package com.miramicodigo.demolitho.model;

import java.io.Serializable;

/**
 *
 * @author Gustavo Lizárraga
 * @date 25-07-17
 *
 */

public class Pokemon implements Serializable{
    private String title;
    private String subtitle;
    private int image;

    public Pokemon() {
    }

    public Pokemon(String title, String subtitle, int image) {
        this.title = title;
        this.subtitle = subtitle;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
