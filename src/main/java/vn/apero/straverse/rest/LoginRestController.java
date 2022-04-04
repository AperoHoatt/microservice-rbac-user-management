package vn.apero.straverse.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.apero.straverse.rest.users.dtos.UserDTO;
import vn.apero.straverse.rest.users.dtos.requests.LoginRequestDTO;
import vn.apero.straverse.rest.users.entities.User;
import vn.apero.straverse.rest.users.services.UserService;

@RestController
@RequestMapping(value = "/login")
public class LoginRestController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        User user = userService.login(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());
        return ResponseEntity.ok(new UserDTO(user));
    }

}
