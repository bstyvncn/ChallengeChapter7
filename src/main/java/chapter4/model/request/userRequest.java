package chapter4.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class userRequest {
    private String username;

    private String email;
    private String address;
    private String password;
}
