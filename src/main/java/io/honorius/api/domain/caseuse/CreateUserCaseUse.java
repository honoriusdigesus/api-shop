package io.honorius.api.domain.caseuse;

import io.honorius.api.data.repository.UserRepository;
import io.honorius.api.domain.entity.UserDomain;
import io.honorius.api.domain.mapper.UserDomainMapper;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCaseUse {

    private final UserRepository userRepository;
    private final UserDomainMapper userDomainMapper;

    public CreateUserCaseUse(UserRepository userRepository, UserDomainMapper userDomainMapper) {
        this.userRepository = userRepository;
        this.userDomainMapper = userDomainMapper;
    }

    public void execute(UserDomain userDomain) {
        userRepository.save(userDomainMapper.toEntity(userDomain));
    }
}
