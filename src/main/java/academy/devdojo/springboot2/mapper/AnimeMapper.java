package academy.devdojo.springboot2.mapper;


import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.requests.AnimePostRequestsBody;
import academy.devdojo.springboot2.requests.AnimePutRequestsBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {

    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract Anime toAnime(AnimePostRequestsBody animePostRequestsBody);

    public abstract Anime toAnime(AnimePutRequestsBody animePutRequestsBody);
}
