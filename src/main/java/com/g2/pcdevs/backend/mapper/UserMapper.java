package com.g2.pcdevs.backend.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

import com.g2.pcdevs.backend.dto.input.UserInputDTO;
import com.g2.pcdevs.backend.dto.output.UserOutputDTO;
import com.g2.pcdevs.backend.models.User;

@Component
public class UserMapper {
    @Autowired
    private ModelMapper modelMapper;
    public UserOutputDTO converterModelParaOutputDTO(User user) {
        return modelMapper.map(user, UserOutputDTO.class);
    }
    public User converterInputDTOParaModel(UserInputDTO userInput) {
        return modelMapper.map(userInput, User.class);
    }
}
