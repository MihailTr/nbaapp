package com.tm.nbaapp.service;

import com.tm.nbaapp.model.Role;
import com.tm.nbaapp.model.User;
import com.tm.nbaapp.repository.RoleRepository;
import com.tm.nbaapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Objects;

@Service
public class UserService  {
//public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username).orElseThrow();
//
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        return user;
//    }

    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public User findUserByUsername(String user) {
        User userFromDb = userRepository.findByUsername(user);
        return userFromDb;
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return user;
        }

        user.setRoles(Collections.singleton(new Role(2L, "USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        var newUser = userRepository.save(user);
        return newUser;
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}
