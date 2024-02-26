package com.dat.websocket.Service.Impl;

import com.dat.websocket.Repository.UserRepository;
import com.dat.websocket.Service.UserService;
import com.dat.websocket.entity.Status;
import com.dat.websocket.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public void saveUser(User user){
        User newUser = new User();
        newUser.setFullname(user.getFullname());
        newUser.setUsername(user.getUsername());
        newUser.setStatus(Status.ONLINE);
        userRepository.save(newUser);
    }

    public void disconnect(User user){
        var storedUser = userRepository.findByUsername(user.getUsername()).orElseThrow(null);
        if (storedUser != null){
            storedUser.setStatus(Status.OFFLINE);
            userRepository.save(storedUser);
        }
    }

    public List<User> findConnectedUsers(){
        List<User> listUserOnline = userRepository.findAllByStatus(Status.ONLINE);
        return listUserOnline;
    }
}
