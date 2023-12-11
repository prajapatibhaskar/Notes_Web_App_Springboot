package com.bhaskar.practiceSpring.controller;

import com.bhaskar.practiceSpring.documents.User;
import com.bhaskar.practiceSpring.repositories.NoteRepository;
import com.bhaskar.practiceSpring.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
class UserStatus{
    Integer status;
    String user;
    /**
     * 1 - exist
     * 0 - doesnt exist
     * 2 - created
     */
}

@RestController
@CrossOrigin("http://localhost:3000")
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NoteRepository noteRepository;

    @PostMapping("/login")
    public UserStatus login(@RequestBody User user) {
        User _user = this.userRepository.findbyUseernameAndPassword(user.getUsername(), user.getPassword());
        UserStatus userStatus = new UserStatus(null, user.getUsername());
        if(Objects.nonNull(_user)){
            userStatus.setStatus(1);
        }
        else{
            userStatus.setStatus(0);
        }
        return userStatus;
    }

    @PostMapping("/signup")
    public UserStatus signup(@RequestBody User user) {
        User _user = this.userRepository.findByUsername(user.getUsername());
        UserStatus userStatus = new UserStatus(null, user.getUsername());
        if(Objects.nonNull(_user)) {
            userStatus.setStatus(1);
        }
        else{
            this.userRepository.save(user);
            userStatus.setStatus(2);
        }
        return userStatus;
    }

    @DeleteMapping("/{user}/deleteUser")
    public void deleteUser(@PathVariable String user) {
        this.userRepository.deleteByUsername(user);
        this.noteRepository.deleteAllByUsername(user);
    }
}
