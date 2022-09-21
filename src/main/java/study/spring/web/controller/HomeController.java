package study.spring.web.controller;

// Conmponent의 자식 Controller
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import study.spring.web.domain.Person;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {
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
}
