package com.thirdfort.personalNotesManagementSystem.service;

import com.thirdfort.personalNotesManagementSystem.repository.UserRepository;
import com.thirdfort.personalNotesManagementSystemModels.Model.User;
import com.thirdfort.personalNotesManagementSystemModels.ModelDto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.InputMismatchException;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    public  UserServiceImpl(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    @Override
    public void initiate(UserDto userdto) {
        User user= modelMapper.map(userdto,User.class);
        try {
            userRepository.save(user);
        }catch (RuntimeException e){
            throw  new RuntimeException();
        }
    }
}
