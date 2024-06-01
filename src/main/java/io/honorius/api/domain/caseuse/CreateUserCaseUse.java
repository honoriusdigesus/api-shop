package io.honorius.api.domain.caseuse;

import io.honorius.api.data.repository.UserRepository;
import io.honorius.api.domain.entity.UserDomain;
import io.honorius.api.domain.mapper.UserDomainMapper;
import io.honorius.api.exception.exceptions.UserCcException;
import io.honorius.api.exception.exceptions.UserNameException;
import io.honorius.api.utils.Validator;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCaseUse {

    private final UserRepository userRepository;
    private final UserDomainMapper userDomainMapper;
    private final Validator validator;

    public CreateUserCaseUse(UserRepository userRepository, UserDomainMapper userDomainMapper, Validator validator) {
        this.userRepository = userRepository;
        this.userDomainMapper = userDomainMapper;
        this.validator = validator;
    }

    public void execute(UserDomain userDomain) {
        if (validator.isValidCc(userDomain.getCc()) == false){
            throw new UserCcException("Document invalid");
        }
        if (validator.isValidName(userDomain.getName())==false){
            throw new UserNameException("Name invalid");
        }
        userRepository.save(userDomainMapper.toEntity(userDomain));
    }
}
