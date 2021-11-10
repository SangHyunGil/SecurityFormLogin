package study.domain.member;

import study.web.member.form.MemberDto;

public interface MemberService {
    Member save(MemberDto memberDto);
}
