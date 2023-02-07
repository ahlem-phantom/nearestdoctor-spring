package tn.pi.server.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Chat implements Serializable {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dateSent", nullable = false, updatable = false)
    @CreationTimestamp
    private Date dateSent;
    @Column(length = 65555)
    private String messageReceived;
    @Column(length = 65555)
    private String messageSent;
    @ManyToOne
    @JsonBackReference
    @ToString.Exclude
	private User user;

    public Chat(String messageSent, String messageReceived, User user) {
        this.messageSent = messageSent;
        this.messageReceived = messageReceived;
        this.user = user;
    }

    public Chat(String messageSent, String messageReceived) {
        this.messageSent = messageSent;
        this.messageReceived = messageReceived;
    }
}
