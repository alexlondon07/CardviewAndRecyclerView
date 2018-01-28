package io.github.alexlondon07.cardviewandreciclerview.models;

import java.io.Serializable;

/**
 * Created by alexlondon07 on 1/28/18.
 */

public class Movie  implements Serializable{

    private String name;
    private int poster;

    public Movie() {
    }

    public Movie(String name, int poster) {
        this.name = name;
        this.poster = poster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }
}
