package io.honorius.api.persistence.controller;

import io.honorius.api.domain.caseuse.CreateUserCaseUse;
import io.honorius.api.persistence.enity.UserPersistence;
import io.honorius.api.persistence.mapper.UserPersistenceMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final CreateUserCaseUse createUserCaseUse;
    private final UserPersistenceMapper userPersistenceMapper;

    public UserController(CreateUserCaseUse createUserCaseUse, UserPersistenceMapper userPersistenceMapper) {
        this.createUserCaseUse = createUserCaseUse;
        this.userPersistenceMapper = userPersistenceMapper;
    }

    @PostMapping("/create")
    public void createUser(@RequestBody UserPersistence userPersistence) {
        createUserCaseUse.execute(userPersistenceMapper.toDomain(userPersistence));
    }
}
