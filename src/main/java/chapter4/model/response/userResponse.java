package chapter4.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class userResponse {
    private String username;

    private String email;
    private String address;
    private String password;

}


