package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByName() {

        User user = new User();
        user.setId(1L);
        user.setName("John");

        userRepository.save(user);

        List<User> users = userRepository.findByName("John");

        assertEquals(1, users.size());

    }

}