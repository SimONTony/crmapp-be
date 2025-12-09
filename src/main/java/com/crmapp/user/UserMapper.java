package com.crmapp.user;

import com.crmapp.securiry.jwt.JwtUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserRecord entityToRecord(UserEntity user);

    UserEntity recordToEntity(UserRecord userRecord);

    UserEntity recordToEntity(CreateUserRecord userRecord);

    UserEntity recordToEntity(EditUserRecord userRecord);

    List<UserRecord> entityListToRecordList(List<UserEntity> userList);

    List<UserEntity> recordListToEntityList(List<UserRecord> userRecordList);

    @Mapping(target = "role", source = "authorities", qualifiedByName = "mapAuthoritiesToRole")
    @Mapping(target = "status", expression = "java(jwtUser.isEnabled() ? UserStatus.ACTIVE : UserStatus.INACTIVE)")
    @Mapping(target = "email", source = "username")
    CurrentUserRecord toCurrentUserRecord(JwtUser jwtUser);

    @Named("mapAuthoritiesToRole")
    default UserRole mapAuthoritiesToRole(Collection<? extends GrantedAuthority> authorities) {
        if (authorities == null || authorities.isEmpty()) {
            return null;
        }

        String roleString = ((List<?>) authorities).getFirst().toString();

        try {
            return UserRole.valueOf(roleString);
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("Role not found for authority: " + roleString);
        }
    }

    default Page<UserRecord> entityPageToRecordPage(Page<UserEntity> value) {
        return value.map(UserMapper.INSTANCE::entityToRecord);
    }
}
