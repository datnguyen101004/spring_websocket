package com.dat.websocket.Service;

import com.dat.websocket.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    void disconnect(User user);
    List<User> findConnectedUsers();
}
