package com.thirdfoot.personalNotesManagementSystem.service;

import com.thirdfoot.personalNotesManagementSystemModels.Model.User;
import com.thirdfoot.personalNotesManagementSystemModels.ModelDto.UserDto;

public interface UserService {
    void initiate(User user);

   String login(UserDto userDto);
}
