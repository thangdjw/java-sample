package user.controller;

import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import user.error.UpdateUserFailedException;
import user.error.UserNotFoundException;
import user.model.UserEntity;
import user.service.UserService;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api/user")
public class UserManager {
    @Autowired
    private UserService userService;

    @PostMapping
    @ExceptionHandler({UpdateUserFailedException.class})
    public boolean createUser(@ModelAttribute UserEntity user) {
        String uid = Hashing.crc32().hashString(
                user.getFullName() + user.getBirthDay().toString(),
                StandardCharsets.UTF_8).toString();
        user.setId(uid);
        userService.addUser(user);
        return true;
    }

    @PutMapping("/{id}")
    @ExceptionHandler({UpdateUserFailedException.class})
    public boolean updateUser(@ModelAttribute UserEntity user) {
        System.out.println("---> id : "+user.getId());
        userService.updateUser(user);
        return true;
    }

    @GetMapping("/{id}")
    @ExceptionHandler({UserNotFoundException.class})
    public UserEntity getUser(@PathVariable("id") String id) throws UserNotFoundException {
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    @ExceptionHandler({UserNotFoundException.class})
    public boolean deleteUser(@PathVariable("id") String id) {
        return userService.deleteUser(id);
    }


}
