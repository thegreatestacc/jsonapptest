package net.sovliv.jsontestapp.controllers;

import net.sovliv.jsontestapp.domain.User;
import net.sovliv.jsontestapp.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * User controller
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Просмотр всей информации о всех пользователях
     * @return
     */
    @GetMapping("/list")
    public Iterable<User> list() {
        return userService.list();
    }

    /**
     * Просмотр инофрмации об одном пользователе
     * @param id айди по которому будет
     * @return
     */
    @GetMapping("/list/{id}")
    public User getOneUser(@PathVariable("id") Long id) {
        return userService.getOneUser(id);
    }

    /**
     * Добавление нового пользователя
     * @param newUser новый пользователь
     * @return
     */
    @PostMapping("/list/add")
    public User addUser(@RequestBody User newUser) {
        return userService.create(newUser);
    }

    /**
     * Редактирование информации одного пользователя
     * @param newUser новый пользователь
     * @param id айди редактируемого пользователя
     * @return
     */
    @PutMapping("/list/edit/{id}")
    public User editUser(@RequestBody User newUser, @PathVariable Long id) {
        return userService.update(newUser, id);
    }

    /**
     * Удаление одного пользователя
     * @param id айди по которому будет удален пользователь
     */
    @DeleteMapping("/list/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }

    /**
     * Удаление всех пользователей
     */
    @DeleteMapping("/list/deleteAll")
    public void deleteAllUsers() {
        userService.deleteAllUsers();
    }
}
