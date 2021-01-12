package com.thirdfoot.personalNotesManagementSystem.service;

import com.thirdfoot.personalNotesManagementSystem.repository.UserRepository;
import com.thirdfoot.personalNotesManagementSystemModels.Model.User;
import com.thirdfoot.personalNotesManagementSystemModels.ModelDto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private ModelMapper modelMapper;


    private UserRepository userRepository;

    @Autowired
    public  UserServiceImpl(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    @Override
    public void initiate(User userdto) {
        User user= modelMapper.map(userdto,User.class);
        try {
            userRepository.save(user);
        }catch (RuntimeException e){
            throw  new RuntimeException();
        }
    }

    @Override
    public String login(UserDto userDto) {
        Optional<User> user = userRepository.findByUsername(userDto.getUsername());
        user.orElseThrow();
        if (user.get().getPassword().equals(userDto.getPassword()))
            return user.get().getUsername();
      return "";
    }
}
