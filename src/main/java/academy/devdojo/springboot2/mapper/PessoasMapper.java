package academy.devdojo.springboot2.mapper;


import academy.devdojo.springboot2.domain.Pessoas;
import academy.devdojo.springboot2.domain.Users;
import academy.devdojo.springboot2.requests.PessoasPostRequestsBody;
import academy.devdojo.springboot2.requests.PessoasPutRequestsBody;
import academy.devdojo.springboot2.requests.UsersPostRequestsBody;
import academy.devdojo.springboot2.requests.UsersPutRequestsBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class PessoasMapper {
    public static final PessoasMapper INSTANCE = Mappers.getMapper(PessoasMapper.class);

    public abstract Pessoas toPessoas(PessoasPostRequestsBody pessoasPostRequestsBody);

    public abstract Pessoas toPessoas(PessoasPutRequestsBody pessoasPutRequestsBody);

}
