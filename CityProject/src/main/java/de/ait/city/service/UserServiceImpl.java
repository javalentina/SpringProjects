package de.ait.city.service;


import de.ait.city.dto.UserRequestDTO;
import de.ait.city.dto.UserResponseDTO;
import de.ait.city.entity.User;
import de.ait.city.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl {
    private UserRepository repository;

    public List<UserResponseDTO> getAllUsers() {
        List<UserResponseDTO> list = new ArrayList<>();

        repository.findAll().forEach(
                u -> {
                    UserResponseDTO userDTO = new UserResponseDTO(
                            u.getId(),
                            u.getName(),
                            u.getAge()
                    );

                    list.add(userDTO);
                }
        );
        return list;
    }

    public UserResponseDTO addUser(UserRequestDTO user) {
        User u = new User(null, user.getName(), user.getAge());
        repository.save(u);
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        return userResponseDTO;
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO user) {
        User u = new User(id, user.getName(), user.getAge());
        repository.save(u);
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        return userResponseDTO;
    }


    public void removeUser(long id) {
        repository.deleteById(id);
    }
}
