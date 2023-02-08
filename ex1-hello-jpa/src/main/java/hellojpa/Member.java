package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@SequenceGenerator(
        name = "member_seq_generator",
        sequenceName = "member_seq",
        initialValue = 1, allocationSize = 50
)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    private Long id;

    private Integer age;

    @Column(name = "name", nullable = false)
    private String username;

    @Lob
    private String description;

    private LocalDate createdDate;

    private LocalDate lastModifiedDate;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }
}
