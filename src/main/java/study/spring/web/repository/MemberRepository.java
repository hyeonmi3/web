package study.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.spring.web.Entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {
}