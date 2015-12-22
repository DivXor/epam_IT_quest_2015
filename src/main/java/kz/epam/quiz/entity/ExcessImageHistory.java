package kz.epam.quiz.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "excess_image_history")
public class ExcessImageHistory extends AbstractEntity implements Serializable {

    @Column(name = "time", nullable = false, updatable = false,
            insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "excess_image_id")
    private ExcessImage excessImage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    //region Getters and Setters
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public ExcessImage getExcessImage() {
        return excessImage;
    }

    public void setExcessImage(ExcessImage excessImage) {
        this.excessImage = excessImage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    //endregion

    //region Equals and Hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExcessImageHistory that = (ExcessImageHistory) o;

        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (excessImage != null ? !excessImage.equals(that.excessImage) : that.excessImage != null) return false;
        return !(user != null ? !user.equals(that.user) : that.user != null);

    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + (excessImage != null ? excessImage.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
    //endregion

    @Override
    public String toString() {
        return "ExcessImageHistory{" +
                "time=" + time +
                ", excessImage=" + excessImage +
                ", user=" + user +
                "} " + super.toString();
    }
}
