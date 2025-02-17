package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Pessoas;
import academy.devdojo.springboot2.domain.Users;
import academy.devdojo.springboot2.exceptions.BadRequestException;
import academy.devdojo.springboot2.mapper.PessoasMapper;
import academy.devdojo.springboot2.mapper.UsersMapper;
import academy.devdojo.springboot2.repository.PessoasRepository;
import academy.devdojo.springboot2.requests.PessoasPostRequestsBody;
import academy.devdojo.springboot2.requests.PessoasPutRequestsBody;
import academy.devdojo.springboot2.requests.UsersPostRequestsBody;
import academy.devdojo.springboot2.requests.UsersPutRequestsBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoasService {
    private final PessoasRepository pessoasRepository;
    public List<Pessoas> listAll() {
        return pessoasRepository.findAll();

    }
    public List<Pessoas> findByName(String name) {
        return pessoasRepository.findByName(name);

    }public Pessoas  findByIdOrThrowBadException(Long id) {
        return pessoasRepository.findById(id)
                .orElseThrow(()-> new BadRequestException("Users not found"));

    }
    public Pessoas save (PessoasPostRequestsBody pessoasPostRequestsBody) {
        //Anime anime = Anime.builder().name(animePostRequestsBody.getName()).build();

        return pessoasRepository.save(PessoasMapper.INSTANCE.toPessoas(pessoasPostRequestsBody));

    }public void delete (long id){

        pessoasRepository.delete(findByIdOrThrowBadException(id));
    }
    public void replace (PessoasPutRequestsBody pessoasPutRequestsBody) {
        Pessoas savedPessoas= findByIdOrThrowBadException(pessoasPutRequestsBody.getId());

        Pessoas pessoas = PessoasMapper.INSTANCE.toPessoas(pessoasPutRequestsBody);
        pessoas.setId(savedPessoas.getId());
        pessoasRepository.save(pessoas);

    }


}
