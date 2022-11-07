package com.mdt.orderTrack.service;

import com.mdt.orderTrack.dto.user.UserLoginDto;
import com.mdt.orderTrack.dto.user.UserRegisterDto;
import com.mdt.orderTrack.dto.user.UserResponseDto;
import com.mdt.orderTrack.entity.User;
import com.mdt.orderTrack.exception.RegisterException;
import com.mdt.orderTrack.exception.UserLoginException;
import com.mdt.orderTrack.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }
    public void insert(UserRegisterDto userRegisterDto) {
        try {
            User findUserByUsername = userRepository.findByUsername(userRegisterDto.getUsername());
            User findUserByEmail = userRepository.findByEmail(userRegisterDto.getEmail());
            if (findUserByUsername!=null) throw new RegisterException("Bu kullanıcı adına sahip zaten bir kullanıcı var");
            if (findUserByEmail!=null) throw new RegisterException("Bu Email hesabına sahip zaten bir kullanıcı var");
                User user = createNewUser(userRegisterDto);
            userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private User createNewUser(UserRegisterDto userRegisterDto) {
        User user = new User();
        user.setName(userRegisterDto.getName());
        user.setSurname(userRegisterDto.getSurname());
        user.setUsername(userRegisterDto.getUsername());
        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        user.setIsCustomer(userRegisterDto.getIsCustomer());
        user.setEmail(userRegisterDto.getEmail());
        return user;
    }
    public UserResponseDto login(UserLoginDto userLoginDto) {
            User findUser = userRepository.findByUsername(userLoginDto.getUsername());
            if(findUser!=null){
                boolean isPasswordCorrect = passwordEncoder.matches(userLoginDto.getPassword(),findUser.getPassword());
                if(isPasswordCorrect){
                    return modelMapper.map(findUser,UserResponseDto.class);
                }
            }
            throw new UserLoginException("Kullanıcı adı ya da şifre hatalı");
    }
}
