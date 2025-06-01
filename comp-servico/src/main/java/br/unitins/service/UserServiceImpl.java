package br.unitins.service;

import java.util.List;

import br.unitins.client.EmailGrpcClient;
import br.unitins.dto.UserDTO;
import br.unitins.dto.UserResponseDTO;
import br.unitins.model.User;
import br.unitins.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserServiceImpl implements UserService{

    @Inject
    UserRepository userRepository;

    @Inject
    EmailGrpcClient emailGrpcClient;

    @Override
    @Transactional
    public UserResponseDTO insert(UserDTO userDTO) {
        User user = new User();

        user.setNome(userDTO.nome());
        user.setEmail(userDTO.email());
        user.setSenha(userDTO.senha());
        
        emailGrpcClient.addEmail(userDTO.email());

        userRepository.persist(user);

        return UserResponseDTO.valueOf(user);
    }
    
}
