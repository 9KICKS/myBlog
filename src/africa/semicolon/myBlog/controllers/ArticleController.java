package africa.semicolon.myBlog.controllers;

import africa.semicolon.myBlog.dtos.requests.CreateArticleRequest;
import africa.semicolon.myBlog.services.ArticleService;
import africa.semicolon.myBlog.services.ArticleServiceImpl;

public class ArticleController {
    private ArticleService articleService = new ArticleServiceImpl();

    public Object createPost(CreateArticleRequest request) {
        return articleService.createNewArticle(request);
    }
    public Object findPost(int id) {
        try {
            return articleService.findArticle(id);
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
    }
}