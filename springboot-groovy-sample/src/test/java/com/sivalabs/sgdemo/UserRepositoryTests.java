package com.sivalabs.sgdemo;

import com.sivalabs.sgdemo.entities.User;
import com.sivalabs.sgdemo.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

/**
 * Created by user on 18-12-2014.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTests {

    @Mock
    UserRepository userRepository;

    @Test
    public void test_findUsers()
    {
        when(userRepository.findAll()).thenThrow(new RuntimeException("How is it??"));
        List<User> users = userRepository.findAll();
        System.out.println(users);
    }
}
