package study.web.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import study.domain.member.Member;
import study.domain.member.MemberService;
import study.web.member.form.MemberDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/register")
    public String getRegisterForm(MemberDto memberDto) {
        return "register";
    }

    @PostMapping("/register")
    public String register(MemberDto memberDto) {
        log.info("member register : {}", memberDto.getPassword());
        memberService.save(memberDto);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginForm(MemberDto memberDto) {
        return "login";
    }

    @GetMapping("/main")
    public String main(MemberDto memberDto, Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("name", name);
        return "main";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/login";
    }

    @GetMapping("/user")
    public String user(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("name", name);
        return "user";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("name", name);
        return "admin";
    }
}
