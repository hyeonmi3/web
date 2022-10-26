package study.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.spring.web.domain.Song;
import study.spring.web.Entity.SongEntity;

import java.util.List;

public interface SongRepository extends JpaRepository<SongEntity, Long> {

    public List<SongEntity> findByTitle(String title);

    public List<SongEntity> findByYear(int year);
}