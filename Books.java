import java.awt.print.Book;
import java.util.Objects;

public class Books {
    private  int id;
    private String name;
    private String author_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author_name='" + author_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Books)) return false;
        Books books = (Books) o;
        return getId() == books.getId() && getName().equals(books.getName()) && getAuthor_name().equals(books.getAuthor_name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAuthor_name());
    }
}
