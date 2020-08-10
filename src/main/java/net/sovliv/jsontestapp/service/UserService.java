package net.sovliv.jsontestapp.service;

import net.sovliv.jsontestapp.domain.User;
import net.sovliv.jsontestapp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> list() {
        logger.info("all users found");
        return userRepository.findAll();
    }

    public User getOneUser(Long id) {
        Optional<User> optional = userRepository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("user not found");
        }
        logger.info("info about one user");
        return optional.get();
    }

    public User create(User user) {
        logger.info("user created");
        return userRepository.save(user);
    }
    
    public User update(User user, Long id) {
        Optional<User> optional = userRepository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("user not found");
        }
        user.setId(id);
        logger.info("user updated");
        return userRepository.save(user);
    }

    public Iterable<User> saveAll(List<User> users) {
        logger.info("all users saved");
        return userRepository.saveAll(users);
    }

    public void deleteUserById(Long id) {
        logger.info("user deleted");
        userRepository.deleteById(id);
    }

    public void deleteAllUsers() {
        logger.info("all users deleted");
        userRepository.deleteAll();
    }
}
