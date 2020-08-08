package net.sovliv.jsontestapp.controllers;

import net.sovliv.jsontestapp.domain.User;
import net.sovliv.jsontestapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public Iterable<User> list() {
        return userService.list();
    }

    @GetMapping("/list/{id}")
    public Optional<User> getOneUser(@PathVariable("id") Long id, String name) {
        for (User user : list()) {
            if(user.getId().equals(id)) {
                name = user.getName();
            }
        }
        logger.info("you get info about user with name " + name);
        return userService.getOneUser(id);
    }

    @DeleteMapping("/list/delete/{id}")
    public void deleteUser(@PathVariable("id") User user) {
        userService.deleteUser(user);
        logger.info("user deleted");

    }

    @DeleteMapping("/list/delete")
    public void deleteAllUsers() {
        userService.deleteAllUsers();
        logger.info("all users deleted");
    }
}
