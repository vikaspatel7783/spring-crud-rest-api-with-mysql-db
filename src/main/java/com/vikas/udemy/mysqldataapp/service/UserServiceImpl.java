package com.vikas.udemy.mysqldataapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vikas.udemy.mysqldataapp.dto.UserDto;
import com.vikas.udemy.mysqldataapp.entity.Address;
import com.vikas.udemy.mysqldataapp.entity.User;
import com.vikas.udemy.mysqldataapp.exception.EmailAlreadyExistException;
import com.vikas.udemy.mysqldataapp.exception.UserNotFoundException;
import com.vikas.udemy.mysqldataapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ObjectMapper objectMapper;

    private UserDto toUserDto(User user) {
        return objectMapper.convertValue(user, UserDto.class);
    }

    private User toUser(UserDto userDto) {
        return objectMapper.convertValue(userDto, User.class);
    }

    public UserDto saveUser(UserDto userDto) {
        Optional<User> userWithSameEmail = userRepository.findByEmail(userDto.getEmail());
        if (userWithSameEmail.isPresent()) {
            throw new EmailAlreadyExistException("This email already exist. Please use other one");
        }
        User userEntity = toUser(userDto);
        User savedEntityUser = userRepository.save(userEntity);
        return toUserDto(savedEntityUser);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserDto getUser(Long userId) {
        return toUserDto(userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException(userId)
        ));
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> allUserEntity = userRepository.findAll();
        return allUserEntity.stream().map(this::toUserDto).toList();
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow(
                () -> new UserNotFoundException(user.getId())
        );
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setAddress(new Address(user.getAddress().getLine1(), user.getAddress().getLine2()));
        return toUserDto(userRepository.save(existingUser));
    }
//    @ExceptionHandler(UserNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleUserNotFoundException(UserNotFoundException userNotFoundException, WebRequest webRequest) {
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                userNotFoundException.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//
//    }
}
