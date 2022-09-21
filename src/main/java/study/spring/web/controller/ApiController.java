package study.spring.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.spring.web.domain.Hello;
import study.spring.web.domain.Person;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/now")
    public String now() {
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = dateFormat.format(new Date());

        return now;
    }

    @GetMapping("/person")
    // 파라메터 code = 블라블라 적으면 name으로
    public Person person(@RequestParam("code") String name, @RequestParam("age") int age) {
        Person person = new Person();
        person.setName(name);
        // person.setAge((int)System.currentTimeMillis() % 90 + 10);
        person.setAge(age);

        return person;
    }

    @GetMapping("/hello")
    // required = flase 를 적어주면 값이 있어도 없어도 괜차늠 ㅇㅇ 이라는 뜻
    public String hello(@RequestParam(value = "name", required = false) String name) {
        return "안녕하세요 " + name + "님";
    }

    @GetMapping("/add")
    public String add(@RequestParam(value = "value1", defaultValue = "10") int value1,
                   @RequestParam(value = "value2", defaultValue = "15") int value2) {
        return String.format("%d + %d = %d", value1, value2, value1 + value2);
    }

    @GetMapping("/subtract")
    public String subtract(@RequestParam(value = "value1", defaultValue = "20") int value1,
                      @RequestParam(value = "value2", defaultValue = "15") int value2) {
        return String.format("%d - %d = %d", value1, value2, value1 - value2);
    }
}
