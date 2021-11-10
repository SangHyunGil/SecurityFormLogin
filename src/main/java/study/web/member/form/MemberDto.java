package study.web.member.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import study.domain.member.RoleType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    public String username;
    public String password;
    public RoleType roleType;
}
