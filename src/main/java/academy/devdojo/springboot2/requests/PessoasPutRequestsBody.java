package academy.devdojo.springboot2.requests;

import lombok.Data;

@Data
public class PessoasPutRequestsBody {
    private Long id;
    private String name;
    private String email;
    private String cpf;

}
