package io.honorius.api.domain.mapper;

import io.honorius.api.data.enttity.User;
import io.honorius.api.domain.entity.UserDomain;
import org.springframework.stereotype.Component;

@Component
public class UserDomainMapper {

    public UserDomain toDomain(User user) {
        return new UserDomain(
                user.getCc(),
                user.getName(),
                user.getLastname());
    }

    public User toEntity(UserDomain userDomain) {
        return new User(
                userDomain.getCc(),
                userDomain.getName(),
                userDomain.getLastname());
    }
}
