package hello.controller;

import hello.dto.PostRequestDto;
import hello.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController //Rest controller를 쓰면 Object를 json 포맷으로 자동으로 리턴해줌
@RequestMapping("/api")
public class PutApiController {
    @PutMapping("/put/{userId}")
    public PutRequestDto put(@RequestBody PutRequestDto requestDto, @PathVariable(name = "userId") Long id) {
        System.out.println(id);
        System.out.println(requestDto);
        return requestDto;
    }
}
