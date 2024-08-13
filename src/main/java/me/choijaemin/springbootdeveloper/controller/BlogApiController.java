package me.choijaemin.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.choijaemin.springbootdeveloper.domain.Article;
import me.choijaemin.springbootdeveloper.dto.AddArticleRequest;
import me.choijaemin.springbootdeveloper.dto.ArticleResponse;
import me.choijaemin.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.servlet.function.ServerResponse.status;

@RequiredArgsConstructor
@RestController
public class BlogApiController {
    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
        Article savedArticle = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){
        List<ArticleResponse> articles = blogService.findAll()
                .stream().map(ArticleResponse::new).toList();

        return ResponseEntity.ok().body(articles);
    }

}
