package hr.pravila.presentation.simpleboot;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * @author stjep
 */
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    
    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }
    
    @GetMapping("/search")
    public User findByIdentificationNumber(@RequestParam String identificationNumber) {
        return userRepository.findByIdentificationNumber(identificationNumber).orElseThrow(UserNotFoundException::new);
    }
    
    @PostMapping
    public User saveUser(@RequestBody @Valid User user) {
        return userRepository.save(user);
    }
}
