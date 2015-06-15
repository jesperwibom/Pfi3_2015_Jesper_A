package se.mah.idk.assignment_4;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by Jesper on 2015-06-15.
 */
public class Planet implements Serializable {
    String name;
    String info;
    String radius;
    String mass;
    Drawable image;

    public Planet(String name, String info, String radius, String mass, Drawable image) {
        this.name = name;
        this.info = info;
        this.radius = radius;
        this.mass = mass;
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String isbn) {
        this.info = isbn;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
