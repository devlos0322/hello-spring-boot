package hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //해당 class는 Rest API를 처리하는 컨트롤러로 자동 인식됨
@RequestMapping("/api") //RequestMapping URI를 지정해주는 Annotation
public class ApiController {

    @GetMapping("/hello")   // http://localhost:9090/api/hello
    public String hello (){
        return "hello spring boot!";
    }
}
