package africa.semicolon.myBlog.data.repositories;

import africa.semicolon.myBlog.data.models.Article;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepositoryImpl implements ArticleRepository {
    private int count;

    private List<Article> articles = new ArrayList<>();

    @Override
    public Article save(Article article) {
        if (article.getId() == 0) {
            article.setId(idGenerator());
            articles.add(article);
            count++;
        }
        return article;
    }

    private int idGenerator() {
        return count +1;
    }

    @Override
    public Article findById(int id) {
        for (Article article: articles) if (article.getId() == id) return article;
        else {throw new IllegalArgumentException("Id not found....");}
        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public List<Article> findAll() {
        return articles;
    }

    @Override
    public void delete(Article article) {

    }

    @Override
    public void delete(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                articles.remove(article);
                count--;
                break;}}
    }

    @Override
    public void deleteAll() {
        articles.clear();
        count=0;
    }
}