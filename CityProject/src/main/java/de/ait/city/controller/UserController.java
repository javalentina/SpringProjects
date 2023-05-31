package de.ait.city.controller;


import de.ait.city.dto.CityRequestDTO;
import de.ait.city.dto.CityResponseDTO;
import de.ait.city.dto.UserRequestDTO;
import de.ait.city.dto.UserResponseDTO;
import de.ait.city.service.CityServiceImpl;
import de.ait.city.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private UserServiceImpl service;

    @GetMapping("")
    public List<UserResponseDTO> listUser() {
        return service.getAllUsers();
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserResponseDTO createUser(@RequestBody UserRequestDTO user) {
        return service.addUser(user);
    }



    @PostMapping("{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserResponseDTO updateCity(@RequestParam("id") long id, @RequestBody UserRequestDTO user) {
        return service.updateUser(id, user);
    }


    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void removeUser(@RequestParam("id") long id) {
        service.removeUser(id);
    }

}
