package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.domain.Users;
import academy.devdojo.springboot2.exceptions.BadRequestException;
import academy.devdojo.springboot2.mapper.AnimeMapper;
import academy.devdojo.springboot2.mapper.UsersMapper;
import academy.devdojo.springboot2.repository.AnimeRepository;
import academy.devdojo.springboot2.repository.UsersRepository;
import academy.devdojo.springboot2.requests.AnimePostRequestsBody;
import academy.devdojo.springboot2.requests.AnimePutRequestsBody;
import academy.devdojo.springboot2.requests.UsersPostRequestsBody;
import academy.devdojo.springboot2.requests.UsersPutRequestsBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    public List<Users> listAll() {
        return usersRepository.findAll();

    }
    public List<Users> findByName(String name) {
        return usersRepository.findByName(name);

    }public Users findByIdOrThrowBadException(Long id) {
        return usersRepository.findById(id)
                .orElseThrow(()-> new BadRequestException("Users not found"));

    }
    public Users save (UsersPostRequestsBody usersPostRequestsBody) {
        //Anime anime = Anime.builder().name(animePostRequestsBody.getName()).build();

        return usersRepository.save(UsersMapper.INSTANCE.toUsers(usersPostRequestsBody));

    }public void delete (long id){

        usersRepository.delete(findByIdOrThrowBadException(id));
    }
    public void replace (UsersPutRequestsBody usersPutRequestsBody) {
        Users savedUsers= findByIdOrThrowBadException(usersPutRequestsBody.getId());

        Users users = UsersMapper.INSTANCE.toUsers(usersPutRequestsBody);
        users.setId(savedUsers.getId());
        usersRepository.save(users);

    }


}
