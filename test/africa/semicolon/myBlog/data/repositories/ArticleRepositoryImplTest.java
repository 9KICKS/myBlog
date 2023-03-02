package africa.semicolon.myBlog.data.repositories;

import africa.semicolon.myBlog.data.models.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleRepositoryImplTest {
    private ArticleRepository articleRepository;

    private Article article;

    private Article article2;

    @BeforeEach void setUp() {
        article = new Article();
        article2 = new Article();
        articleRepository = new ArticleRepositoryImpl();
    }

    @Test public void postOneVlog_And_CountIsOne() {
        articleRepository.save(article);
        assertEquals(1, articleRepository.count());
    }

    @Test public void postOneVlog_IdOfVlogIsOne() {
        Article saved = articleRepository.save(article);
        assertEquals(1, saved.getId());
    }

    @Test public void saveOnePost_andGetByIdTest() {
        Article savedArticle = articleRepository.save(article);
        assertEquals(1, articleRepository.count());
        savedArticle.setBody(" ");
        articleRepository.save(article);
        assertEquals(1, articleRepository.count());
    }

    @Test public void savePostAndGetPostWithId() {
        Article saved =articleRepository.save(article);
        assertEquals(1, articleRepository.count());
        Article find = articleRepository.findById(1);
        assertEquals(find, saved);
    }

    @Test public void saveOnePostAndDeletePostWithId() {
        Article saved = articleRepository.save(article);
        assertEquals(1, articleRepository.count());
        articleRepository.delete(1);
        assertEquals(0, articleRepository.count());
    }

    @Test public void saveTwoPosts_DeleteTwoPostsAndCountIsZero() {
        Article saved = articleRepository.save(article);
        Article saved2 = articleRepository.save(article2);
        assertEquals(2, articleRepository.count());
        articleRepository.delete(1);
        articleRepository.delete(2);
        assertEquals(0, articleRepository.count());
    }
}