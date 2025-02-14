package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.exceptions.BadRequestException;
import academy.devdojo.springboot2.mapper.AnimeMapper;
import academy.devdojo.springboot2.repository.AnimeRepository;
import academy.devdojo.springboot2.requests.AnimePostRequestsBody;
import academy.devdojo.springboot2.requests.AnimePutRequestsBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


@Service
@RequiredArgsConstructor

public class AnimeService {
   private final AnimeRepository animeRepository;



    public List<Anime> listAll() {
        return animeRepository.findAll();

    } public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);

    }

    public Anime findByIdOrThrowBadException(Long id) {
        return animeRepository.findById(id)
                .orElseThrow(()-> new BadRequestException("Anime not found"));

    }
    public Anime save (AnimePostRequestsBody animePostRequestsBody) {
       //Anime anime = Anime.builder().name(animePostRequestsBody.getName()).build();

        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestsBody));

    }
    public void delete (long id){

       animeRepository.delete(findByIdOrThrowBadException(id));
    }

    public void replace (AnimePutRequestsBody animePutRequestsBody) {
        Anime savedAnime = findByIdOrThrowBadException(animePutRequestsBody.getId());

        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestsBody);
        anime.setId(savedAnime.getId());
        animeRepository.save(anime);

    }
}

