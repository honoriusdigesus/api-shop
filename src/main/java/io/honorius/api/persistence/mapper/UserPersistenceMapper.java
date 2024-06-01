package io.honorius.api.persistence.mapper;

import io.honorius.api.domain.entity.UserDomain;
import io.honorius.api.persistence.enity.UserPersistence;
import org.springframework.stereotype.Component;

@Component
public class UserPersistenceMapper {

    public UserDomain toDomain(UserPersistence user) {
        return new UserDomain(user.getCc(), user.getName(), user.getLastname());
    }

    public UserPersistence toPersistence(UserDomain userDomain) {
        return new UserPersistence(userDomain.getCc(), userDomain.getName(), userDomain.getLastname());
    }
}
