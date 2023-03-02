package africa.semicolon.myBlog.services;

import africa.semicolon.myBlog.data.models.Article;
import africa.semicolon.myBlog.dtos.requests.CreateArticleRequest;

public interface ArticleService {
    Article createNewArticle(CreateArticleRequest createArticleRequest);

    Article findArticle(int id);

    long count();
}