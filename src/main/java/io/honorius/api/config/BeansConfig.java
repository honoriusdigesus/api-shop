package io.honorius.api.config;

import io.honorius.api.data.repository.UserRepository;
import io.honorius.api.domain.caseuse.CreateUserCaseUse;
import io.honorius.api.domain.mapper.UserDomainMapper;
import io.honorius.api.utils.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public CreateUserCaseUse createUserCaseUse(UserRepository userRepository, UserDomainMapper userDomainMapper, Validator validator){
        return new CreateUserCaseUse(userRepository, userDomainMapper, validator);
    }
}
