package com.vikas.udemy.mysqldataapp.controller;

import com.vikas.udemy.mysqldataapp.dto.UserDto;
import com.vikas.udemy.mysqldataapp.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "CRUD REST API for User management",
        description = "Create, Read, Update, Delete REST APIs regarding User"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;
    @Operation(
            summary = "Create User REST API",
            description = "This API used to create the user in system"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 Created"
    )
    @PostMapping("/user")
    public ResponseEntity<UserDto> crateUser(@RequestBody @Valid UserDto userDto) {
        return new ResponseEntity<>(userService.saveUser(userDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{user-id}")
    public void deleteUser(@PathVariable(name = "user-id") long userId) {
        userService.deleteUser(userId);
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "user-id") long userId){
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @PutMapping()
    public ResponseEntity<UserDto> updateUser(@RequestBody @Valid UserDto user){
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }
}
