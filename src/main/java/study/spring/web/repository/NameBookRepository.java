package study.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.spring.web.Entity.NameBookPostEntity;

import java.util.List;

public interface NameBookRepository extends JpaRepository<NameBookPostEntity, Long> {
}