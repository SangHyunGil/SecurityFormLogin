package study.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.web.member.form.MemberDto;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MemberRepository memberRepository;

    @Override
    @Transactional
    public Member save(MemberDto memberDto) {
        return memberRepository.save(
                Member.builder()
                        .username(memberDto.username)
                        .password(passwordEncoder.encode(memberDto.getPassword()))
                        .roleType(memberDto.getRoleType())
                        .build());
    }
}
