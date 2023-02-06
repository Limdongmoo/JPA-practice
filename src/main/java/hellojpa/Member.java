package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Member {

    @Id
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
}
