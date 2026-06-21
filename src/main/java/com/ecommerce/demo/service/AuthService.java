package com.ecommerce.demo.service;

import com.ecommerce.demo.dto.AuthResponseDTO;
import com.ecommerce.demo.dto.LoginReqDTO;
import com.ecommerce.demo.dto.RegisterRequestDTO;
import com.ecommerce.demo.dto.RegisterResponseDTO;
import com.ecommerce.demo.exception.ConflictException;
import com.ecommerce.demo.exception.UnauthorizedException;
import com.ecommerce.demo.model.User;
import com.ecommerce.demo.repository.UserRepository;
import com.ecommerce.demo.security.JwtService;
import com.ecommerce.demo.validation.CpfValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponseDTO login(LoginReqDTO request) {
        User user = userRepository.findByEmail(request.email().trim().toLowerCase())
                .orElseThrow(() -> new UnauthorizedException("E-mail ou senha inválidos"));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new UnauthorizedException("E-mail ou senha inválidos");
        }

        String token = jwtService.generateToken(user);
        return new AuthResponseDTO(user.getName(), token);
    }

    public RegisterResponseDTO register(RegisterRequestDTO request) {
        String normalizedEmail = request.email().trim().toLowerCase();
        String normalizedCpf = CpfValidator.normalize(request.cpf());

        if (userRepository.existsByEmail(normalizedEmail)) {
            throw new ConflictException("E-mail já cadastrado");
        }

        if (userRepository.existsByCpf(normalizedCpf)) {
            throw new ConflictException("CPF já cadastrado");
        }

        User user = new User();
        user.setName(request.name().trim());
        user.setEmail(normalizedEmail);
        user.setCpf(normalizedCpf);
        user.setPassword(passwordEncoder.encode(request.password()));

        userRepository.save(user);

        return new RegisterResponseDTO("Cadastro realizado com sucesso");
    }
}
