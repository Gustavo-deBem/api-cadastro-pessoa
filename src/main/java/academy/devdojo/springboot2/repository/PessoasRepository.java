package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.Pessoas;
import academy.devdojo.springboot2.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoasRepository extends JpaRepository<Pessoas, Long> {
    List<Pessoas> findByName(String name);
    String name(String name);
}
