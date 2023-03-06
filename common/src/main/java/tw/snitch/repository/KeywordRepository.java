package tw.snitch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tw.snitch.entity.Keyword;

/**
 *
 * @author CTO
 */
@org.springframework.stereotype.Repository
public interface KeywordRepository extends JpaRepository<Keyword, Short> {
}
