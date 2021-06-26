package Models;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {
    private String text;
    private Date date;

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", date=" + date +
                '}';
    }

    public Article(String text, Date date) {
        this.text = text;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }
}