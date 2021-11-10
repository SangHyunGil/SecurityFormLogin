package study.domain.member;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name = "MEMBER_GENERATOR",
        sequenceName = "MEMBER_SEQ"
)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "member_id")
    private Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Builder
    public Member(String username, String password, RoleType roleType) {
        this.username = username;
        this.password = password;
        this.roleType = roleType;
    }
}