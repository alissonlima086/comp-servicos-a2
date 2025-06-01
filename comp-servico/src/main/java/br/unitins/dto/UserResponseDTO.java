package br.unitins.dto;

import br.unitins.model.User;

public record UserResponseDTO(
    String nome,
    String email
) {
    public static UserResponseDTO valueOf(User user){
        return new UserResponseDTO(user.getNome(), user.getEmail());
    }
}
