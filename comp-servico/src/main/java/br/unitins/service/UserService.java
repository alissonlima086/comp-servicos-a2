package br.unitins.service;

import java.util.List;

import br.unitins.dto.UserDTO;
import br.unitins.dto.UserResponseDTO;

public interface UserService {

    public UserResponseDTO insert(UserDTO userDTO);
    
}
