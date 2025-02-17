package academy.devdojo.springboot2.mapper;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.requests.AnimePostRequestsBody;
import academy.devdojo.springboot2.requests.AnimePutRequestsBody;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-14T16:27:01-0400",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class AnimeMapperImpl extends AnimeMapper {

    @Override
    public Anime toAnime(AnimePostRequestsBody animePostRequestsBody) {
        if ( animePostRequestsBody == null ) {
            return null;
        }

        Anime.AnimeBuilder anime = Anime.builder();

        anime.name( animePostRequestsBody.getName() );

        return anime.build();
    }

    @Override
    public Anime toAnime(AnimePutRequestsBody animePutRequestsBody) {
        if ( animePutRequestsBody == null ) {
            return null;
        }

        Anime.AnimeBuilder anime = Anime.builder();

        anime.id( animePutRequestsBody.getId() );
        anime.name( animePutRequestsBody.getName() );

        return anime.build();
    }
}
