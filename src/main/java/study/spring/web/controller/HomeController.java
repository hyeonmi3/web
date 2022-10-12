package study.spring.web.controller;

// Conmponent의 자식 Controller
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import study.spring.web.domain.Member;
import study.spring.web.domain.NameBookPost;
import study.spring.web.domain.Person;
import study.spring.web.service.MemberService;
import study.spring.web.service.MemberServiceImpl;
import study.spring.web.service.NameBookService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
    private MemberService memberService;

    private NameBookService nameBookService;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    // RequestMapping /hello를 요청하면 밑에를 실행
    // method를 넣어서 POST로만 들어올수 있게 함
    // @RequestMapping(value = "/hello", method = RequestMethod.POST)

    // @PostMapping POST로만 받는다
    @GetMapping("/hello")
    public String hello() {
        // 컨트롤러한테 얘 뷰 이름은 hello야 라고 알려주는것.
        // 그러면 templates에서 hello.HTML을 찾아서 return함
        return "hello";
    }

    // value = {"/ad", "/sb" , "/헤헤"} 주소 여러개를 할수 있음
    @RequestMapping(value = {"/hi", "/abcd", "/dgsw.do"})
    public String hi() {
        return "hi";
    }

    @RequestMapping("/clock")
    public ModelAndView clock() {
        ModelAndView mv = new ModelAndView("clock");

        SimpleDateFormat format =
                new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
        String time = format.format(new Date());
        mv.addObject("now", time);

        Person person = new Person();
        person.setName("현미");
        person.setAge(1000);

        mv.addObject("person", person);

        return mv;
    }

    @RequestMapping("/add")
    public String add(@RequestParam("value1") int value1,
                      @RequestParam("value2") int value2) {
        return String.format("%d + %d = %d", value1, value2, value1 + value2);
    }

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }

    @PostMapping("/signin-result")
    public ModelAndView signinResult(
            @RequestParam("id") String id
            , @RequestParam("name") String name
            , @RequestParam("city") String city
    ) {
        ModelAndView mv = new ModelAndView("signin-result");

        /* 데이터베이스에 아이디, 이름, 도시를 저장한다. */

        Member member = new Member();
        member.setId(id);
        member.setName(name);
        member.setCity(city);

        member = memberService.register(member);

        mv.addObject("member", member);

        return mv;
    }

    @GetMapping("/namebook/write")
    public String nameBook() {
        return "namebook/write";
    }

    @PostMapping("/namebook/write-save")
    public String namebookAdd(
            @RequestParam("writer") String writer
            , @RequestParam("content") String content
    ) {
        NameBookPost post = new NameBookPost();
        post.setWriter(writer);
        post.setContent(content);

        nameBookService.add(post);

        return "namebook/write-save";
    }

    @GetMapping("/namebook/list")
    public ModelAndView nameBookList() {
        List<NameBookPost> list = nameBookService.list();

        ModelAndView mv = new ModelAndView("namebook/list");
        mv.addObject("list", list);

        return mv;
    }
}