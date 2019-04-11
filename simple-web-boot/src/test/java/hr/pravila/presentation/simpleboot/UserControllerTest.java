package hr.pravila.presentation.simpleboot;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import hr.pravila.presentation.simpleboot.User;
import hr.pravila.presentation.simpleboot.UserController;
import hr.pravila.presentation.simpleboot.UserNotFoundException;
import hr.pravila.presentation.simpleboot.UserRepository;

/**
 * @author stjep
 */
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserController underTest;
    
    private List<User> userList = new ArrayList<>();
    
    @Before
    public void before() {
        when(userRepository.findAll()).thenReturn(userList);
        when(userRepository.save(any(User.class))).then(AdditionalAnswers.returnsFirstArg());
    }

    @Test
    public void testFindAll() throws Exception {
        assertSame(userList, underTest.findAll());
    }

    @Test
    public void testFindByIdentificationNumber() throws Exception {
        User u = new User();
        when(userRepository.findByIdentificationNumber("1234")).thenReturn(Optional.of(u));
        assertSame(u, underTest.findByIdentificationNumber("1234"));
    }
    
    @Test(expected = UserNotFoundException.class)
    public void testFindByIdentificationNumber_NonExistant() throws Exception {
        when(userRepository.findByIdentificationNumber("12345")).thenReturn(Optional.empty());
        underTest.findByIdentificationNumber("12345");
    }

    @Test
    public void testSaveUser() throws Exception {
        User u = new User();
        assertSame(u, underTest.saveUser(u));
        verify(userRepository).save(u);
    }

}
