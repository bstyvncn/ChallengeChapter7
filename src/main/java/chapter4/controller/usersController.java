package chapter4.controller;

import chapter4.model.response.userResponse;
import chapter4.model.users;
import chapter4.service.IUsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RestController
@RequestMapping("/user")
public class usersController {

    @Autowired
    IUsersService usersService;

//    Menambahkan User (POST)
//7. Mengupdate user (PUT)
//8. Menghapus User (DELETE)

    @Operation(summary = "untuk menambahkan user baru ke dalam sistem")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "return success",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = userResponse.class))})
    })
    @PostMapping("/public/new-user")
    public ResponseEntity newUser(@RequestParam("username") String username,
                                  @RequestParam("email") String email, @RequestParam("address") String address,
                                  @RequestParam("password") String password) {
        Map<String, Object> resp = new HashMap<>();
        resp.put("message", "insert success!");

        try {
            users users = new users();
            users.setUsername(username);
            users.setEmail(email);
            users.setPassword(password);
            users.setAddress(address);
            usersService.newUsers(users);
            return new ResponseEntity(resp, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            resp.put("message", "insert gagal!, dikarenakan : " + e.getMessage());
            return new ResponseEntity(resp, HttpStatus.BAD_GATEWAY);
        }


    }

    @Operation(summary = "untuk update user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "return success",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = userResponse.class))})
    })
    @PutMapping("/customer/update-user")
    public ResponseEntity updateUser(@RequestParam("usernameFrom") String usernameFrom, @RequestParam("usernameTo") String usernameTo) {
        Map<String, Object> resp = new HashMap<>();
        resp.put("message", "update success!");

        try {
            usersService.updateUsers(usernameFrom, usernameTo);
            return new ResponseEntity(resp, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            resp.put("message", "update gagal!, dikarenakan : " + e.getMessage());
            return new ResponseEntity(resp, HttpStatus.BAD_GATEWAY);
        }


    }

    @Operation(summary = "untuk delete user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "return success",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = userResponse.class))})
    })
    @PutMapping("/customer/delete-user")
    public ResponseEntity deleteUser(@RequestParam("username") String username) {
        Map<String, Object> resp = new HashMap<>();
        resp.put("message", "delete success!");

        try {
            users users = new users();
            users.setUsername(username);
            usersService.deleteUsers(users);
            return new ResponseEntity(resp, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            resp.put("message", "update gagal!, dikarenakan : " + e.getMessage());
            return new ResponseEntity(resp, HttpStatus.BAD_GATEWAY);
        }


    }
}


