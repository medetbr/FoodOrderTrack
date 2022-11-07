package com.mdt.orderTrack.service;

import com.mdt.orderTrack.entity.User;
import com.mdt.orderTrack.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
