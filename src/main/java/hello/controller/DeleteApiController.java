package hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeleteApiController {
    @DeleteMapping("/delete/{userId}")
    public  void delete(@PathVariable String userId, @RequestParam String account) {
        System.out.println(userId);
        System.out.println(account);

        //Delete -> 리소스가 없을 경우에도 200 OK 리턴. 없다는 사실의 멱등성
    }
}
