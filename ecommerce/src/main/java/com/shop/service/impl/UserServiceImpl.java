package com.shop.service.impl;

import com.shop.domain.dto.request.UserLoginRequest;
import com.shop.domain.dto.user.UserCreateDto;
import com.shop.domain.dto.user.UserUpdateDto;
import com.shop.domain.entity.RoleEntity;
import com.shop.domain.entity.UserEntity;
import com.shop.domain.exceptions.ClassicModelException;
import com.shop.repository.RoleRepository;
import com.shop.repository.UserRepository;
import com.shop.service.UserService;
import com.shop.util.SecurityContextHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

import static com.shop.domain.mapper.UserMapper.USER_MAPPER;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private SecurityContextHelper securityContextHelper;

    @Override
    public Optional<UserEntity> findUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional<UserEntity> findUserByEmail(String email) {
        return userRepository.findByEmailAndEnabledIsTrue(email);
    }

    @Override
    public void createUser(UserCreateDto userCreateDTO) {

        var email = userCreateDTO.getEmail();
        Optional<UserEntity> userExists = userRepository.findByEmail(email);

        RoleEntity userRole = roleRepository.findByRole("user")
                .orElseThrow(() -> new ClassicModelException("Role 'user' not found"));

        if (userExists.isPresent() && (userExists.get().isEnabled())) {
            throw new ClassicModelException("User with email " + email + " already exists");
        }

        UserEntity userToCreate = USER_MAPPER.toEntityCreate(userCreateDTO);
        userToCreate.setRole(userRole);
        if (userExists.isPresent() && !userExists.get().isEnabled()) {
            userToCreate.setId(userExists.get().getId());
            userToCreate.setEmail(userExists.get().getEmail());
            userToCreate.setEnabled(true);
            userToCreate.setModifiedAt(LocalDateTime.now());
            userToCreate.setCreatedAt(userExists.get().getCreatedAt());
            userToCreate.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));
        } else {
            userToCreate.setCreatedAt(LocalDateTime.now());
            userToCreate.setEmail(userCreateDTO.getEmail());
            userToCreate.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));
        }

        userRepository.save(userToCreate);
    }

    @Override
    public Authentication login(UserLoginRequest userLoginRequest) {

        Optional<UserEntity> userToLogin = userRepository.findByEmailAndEnabledIsTrue(userLoginRequest.getEmail());

        if (userToLogin.isPresent()) {
            UserEntity user = userToLogin.get();
            if (passwordEncoder.matches(userLoginRequest.getPassword(), user.getPassword())) {
                Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
                return new UsernamePasswordAuthenticationToken(user.getEmail(), null, authorities);
            } else {

                throw new ClassicModelException("Password does not match");
            }
        } else {
            throw new ClassicModelException("User not found");
        }
    }

    @Override
    public void updateUser(UserUpdateDto userUpdateDto) {
        String email = securityContextHelper.getCurrentUserEmail();
        Optional<UserEntity> optionalUser = userRepository.findByEmailAndEnabledIsTrue(email);

        if (optionalUser.isEmpty()) {
            throw new ClassicModelException("User not found!");
        }

        UserEntity userToUpdate = USER_MAPPER.toEntityUpdate(userUpdateDto);
        userToUpdate.setId(optionalUser.get().getId());
        userToUpdate.setEmail(optionalUser.get().getEmail());
        userToUpdate.setEnabled(true);
        userToUpdate.setRole(optionalUser.get().getRole());
        userToUpdate.setModifiedAt(LocalDateTime.now());
        userToUpdate.setCreatedAt(optionalUser.get().getCreatedAt());
        userToUpdate.setPassword(passwordEncoder.encode(userUpdateDto.getPassword()));
        userRepository.save(userToUpdate);
    }
}
