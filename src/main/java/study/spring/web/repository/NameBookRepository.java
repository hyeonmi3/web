package study.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.spring.web.Entity.NameBookPostEntity;

public interface NameBookRepository extends JpaRepository<NameBookPostEntity, Long> {
}