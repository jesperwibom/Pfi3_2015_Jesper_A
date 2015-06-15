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
    String webURL;

    public Planet(String name, String info, String radius, String mass, Drawable image, String url) {
        this.name = name;
        this.info = info;
        this.radius = radius;
        this.mass = mass;
        this.webURL = url;
        this.image = image;
    }

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    public String getInfo() { return this.info; }

    public void setInfo(String info) { this.info = info; }

    public String getRadius() { return this.radius; }

    public void setRadius(String radius) { this.radius = radius; }

    public String getMass() { return this.mass; }

    public void setMass(String mass) { this.mass = mass; }

    public String getWebURL() { return this.webURL; }

    public void setWebURL(String url) { this.webURL = url; }

    public Drawable getImage() { return image; }

    public void setImage(Drawable image) { this.image = image; }
}
