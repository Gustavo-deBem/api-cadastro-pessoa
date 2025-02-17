package academy.devdojo.springboot2.mapper;

import academy.devdojo.springboot2.domain.Pessoas;
import academy.devdojo.springboot2.requests.PessoasPostRequestsBody;
import academy.devdojo.springboot2.requests.PessoasPutRequestsBody;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-17T15:44:25-0400",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class PessoasMapperImpl extends PessoasMapper {

    @Override
    public Pessoas toPessoas(PessoasPostRequestsBody pessoasPostRequestsBody) {
        if ( pessoasPostRequestsBody == null ) {
            return null;
        }

        Pessoas.PessoasBuilder pessoas = Pessoas.builder();

        pessoas.name( pessoasPostRequestsBody.getName() );
        pessoas.email( pessoasPostRequestsBody.getEmail() );
        pessoas.cpf( pessoasPostRequestsBody.getCpf() );

        return pessoas.build();
    }

    @Override
    public Pessoas toPessoas(PessoasPutRequestsBody pessoasPutRequestsBody) {
        if ( pessoasPutRequestsBody == null ) {
            return null;
        }

        Pessoas.PessoasBuilder pessoas = Pessoas.builder();

        pessoas.id( pessoasPutRequestsBody.getId() );
        pessoas.name( pessoasPutRequestsBody.getName() );
        pessoas.email( pessoasPutRequestsBody.getEmail() );
        pessoas.cpf( pessoasPutRequestsBody.getCpf() );

        return pessoas.build();
    }
}
