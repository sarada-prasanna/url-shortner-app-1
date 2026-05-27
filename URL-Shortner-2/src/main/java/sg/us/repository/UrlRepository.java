package sg.us.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sg.us.entity.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long>{
	Optional<Url> findByShortCode(String shortCode);

}
