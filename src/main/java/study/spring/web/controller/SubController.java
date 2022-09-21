package study.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// 아예 @RequestMapping("/sub") 하면 이 밑에 적히는 페이지들은 다 /sub 밑에 애들
@RequestMapping("/sub")
public class SubController {
    @GetMapping("/page-first")
    public String sub1() {
        return "sub/page-1";
    }
}
