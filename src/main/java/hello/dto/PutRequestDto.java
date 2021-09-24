package hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
//class전체에 같이 적용
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PutRequestDto {
    private String name;
    private int age;

    private List<CarDto> carList;
    /*
    Json format에 List가 포함 될 경우 DTO를 또 만들면 된다.
    {
        "name": "",
        "age": "",
        "car_list" : [
            {
                "name": "BMW",
                "car_number": ""
            }, {
                "name":""
                "car_number": ""
            }
        ]
    }
     */

}
