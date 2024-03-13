package cinema.model;

import lombok.ToString;

import java.util.StringJoiner;

@ToString(of={"title", "year"})
public class Movie {

    private String title;
    private int year;
    private int duration;

    public Movie() {
    }

    public Movie(String title, int year, int duration) {
        this.title = title;
        this.year = year;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("Movie{");
//        sb.append("title='").append(title).append('\'');
//        sb.append(", year=").append(year);
//        sb.append('}');
//        return sb.toString();
//    }
}
