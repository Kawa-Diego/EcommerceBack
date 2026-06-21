package com.ecommerce.demo.service;

import com.ecommerce.demo.dto.UpdateUserRequestDTO;
import com.ecommerce.demo.dto.UserResponseDTO;
import com.ecommerce.demo.exception.ConflictException;
import com.ecommerce.demo.exception.ResourceNotFoundException;
import com.ecommerce.demo.model.User;
import com.ecommerce.demo.repository.UserRepository;
import com.ecommerce.demo.security.SecurityUtils;
import com.ecommerce.demo.validation.CpfValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDTO getCurrentUser() {
        User authenticatedUser = SecurityUtils.getAuthenticatedUser();
        User user = findUserById(authenticatedUser.getId());
        return UserResponseDTO.fromEntity(user);
    }

    public UserResponseDTO updateCurrentUser(UpdateUserRequestDTO request) {
        User authenticatedUser = SecurityUtils.getAuthenticatedUser();
        User user = findUserById(authenticatedUser.getId());

        String normalizedCpf = CpfValidator.normalize(request.cpf());

        if (!user.getCpf().equals(normalizedCpf) && userRepository.existsByCpf(normalizedCpf)) {
            throw new ConflictException("CPF já cadastrado");
        }

        user.setName(request.name().trim());
        user.setCpf(normalizedCpf);
        user.setPassword(passwordEncoder.encode(request.password()));

        User updatedUser = userRepository.save(user);
        return UserResponseDTO.fromEntity(updatedUser);
    }

    private User findUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
    }
}
