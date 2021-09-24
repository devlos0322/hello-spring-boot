package hello.controller;

import hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {
    // 1. Get mapping의 path를 이용하는 방법
    @GetMapping(path = "/hello") //http://localhost:9090/api/get/hello
    public String getHello(){
        return "get Hello";
    }
    // 2. 예전방식 (Requset mapping -> get mapping으로 변경되었음)
    @RequestMapping(path = "/hi", method = RequestMethod.GET)  //Get 만 사용하도록 설정 // http://localhost:9090/api/get/hi
    public String hi(){
        return "hi";
    }

    // http://localhost:9090/api/get/path-variable/{spring-boot}
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable String name) {
        System.out.println("Path Variable: "+name);
        return name;
    }

    //pathvariable 의 값과 변수값을 통일하지 못할 때
    @GetMapping("/path-variable2/{id}")
    public String pathVariable2(@PathVariable(name="id") String pathName) {
        System.out.println("Path Variable: "+pathName);
        return pathName;
    }

    //쿼리 파라메터 받기
    //http://localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping(path="query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {

        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+ "=" + entry.getValue()+"\n");
        });
        return sb.toString();
    }

    //쿼리 파라메터 받기
    //http://localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name+" "+email+" "+age;
    }
    //현업에서 사용하는방법: DTO 설정 후 파라메터 받기
    //http://localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping("query-param03")
    //객체가 들어오게 되면, 물음표 뒤에 있는 값들을 스프링 부트에서 판단하여 객체의 변수와 이름매칭을 해주게 됨.
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
