package academy.devdojo.springboot2.requests;

import lombok.Data;

@Data
public class PessoasPostRequestsBody {
    private String name;
    private String email;
    private  String cpf;
}
