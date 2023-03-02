package africa.semicolon.myBlog.data.repositories;

import africa.semicolon.myBlog.data.models.Article;
import java.util.List;

public interface ArticleRepository {
    Article save(Article article);

    Article findById(int id);

    long count();

    List<Article> findAll();

    void delete(Article article);

    void delete(int id);

    void deleteAll();
}