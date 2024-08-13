package me.choijaemin.springbootdeveloper.repository;

import me.choijaemin.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BlogRepository extends JpaRepository<Article, Long> {
}
