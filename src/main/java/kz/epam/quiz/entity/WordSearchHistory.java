package kz.epam.quiz.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "WORD_SEARCH_HISTORY")
public class WordSearchHistory extends AbstractEntity implements Serializable{

    @Column(name = "time", nullable = false, updatable = false,
            insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    @ManyToOne
    @JoinColumn(name = "WORD_SEARCH_ID", referencedColumnName = "ID")
    private WordSearch wordSearch;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;

    public WordSearchHistory() {
    }

    public WordSearchHistory(WordSearch wordSearch, User user) {
        this.wordSearch = wordSearch;
        this.user = user;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public WordSearch getWordSearch() {
        return wordSearch;
    }

    public void setWordSearch(WordSearch wordSearch) {
        this.wordSearch = wordSearch;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordSearchHistory that = (WordSearchHistory) o;

        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (wordSearch != null ? !wordSearch.equals(that.wordSearch) : that.wordSearch != null) return false;
        return !(user != null ? !user.equals(that.user) : that.user != null);

    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + (wordSearch != null ? wordSearch.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
