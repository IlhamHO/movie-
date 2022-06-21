package eu.epfc.movie.entities;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "MOVIE_SEQ", sequenceName = "MOVIE_SEQ", allocationSize = 1)
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MOVIE_SEQ")
    private Long id;
    private String name;
    private String summary;
    private int date;
    private String actors;
    private String authors;

    public Movie() {
    }

    public Movie(Long id, String name, String summary, int date, String actors, String authors) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.date = date;
        this.actors = actors;
        this.authors = authors;
    }

    public Movie(String name, String summary, int date, String actors, String authors) {
        this.name = name;
        this.summary = summary;
        this.date = date;
        this.actors = actors;
        this.authors = authors;
    }

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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }
}
