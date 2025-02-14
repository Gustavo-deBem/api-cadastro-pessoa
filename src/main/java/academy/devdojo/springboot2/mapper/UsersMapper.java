package academy.devdojo.springboot2.mapper;



import academy.devdojo.springboot2.domain.Users;

import academy.devdojo.springboot2.requests.UsersPostRequestsBody;
import academy.devdojo.springboot2.requests.UsersPutRequestsBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UsersMapper {
    public static final UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);

    public abstract Users toUsers(UsersPostRequestsBody usersPostRequestsBody);

    public abstract Users toUsers(UsersPutRequestsBody UsersPutRequestsBody);

}
