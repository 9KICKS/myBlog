package africa.semicolon.myBlog.services;

import africa.semicolon.myBlog.data.models.Article;
import africa.semicolon.myBlog.dtos.requests.CreateArticleRequest;
import africa.semicolon.myBlog.dtos.requests.RegisterRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArticleServiceImplTest {
    ArticleService articleService;

    UserService userService;

    Article savedArticle;

    CreateArticleRequest createArticleRequest;

    @BeforeEach public void setUp() {
        articleService = new ArticleServiceImpl();
        CreateArticleRequest createArticleRequest = new CreateArticleRequest();
        createArticleRequest.setBody("My Body");
        createArticleRequest.setTitle("My Title");
        createArticleRequest.setAuthorId(1);
        userService = new UserServiceImpl();

    }

    @Test public void saveNewArticle_noOfArticlesIsOneTest() {
        articleService = new ArticleServiceImpl();
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("Firstname");
        var response = userService.register(request);
        System.out.println(response.getFirstName());
        System.out.println(response.getId());
        var ourSavedUser = userService.findUser(1);
        System.out.println(ourSavedUser);
        CreateArticleRequest createArticleRequest = new CreateArticleRequest();
        createArticleRequest.setBody("My Body");
        createArticleRequest.setTitle("My Title");
        createArticleRequest.setAuthorId(1);
        savedArticle = articleService.createNewArticle(createArticleRequest);
        assertEquals(1, articleService.count());
    }

    @Test public void shouldThrowException_ifAuthorIdIsInvalid() {
        articleService = new ArticleServiceImpl();
        CreateArticleRequest createArticleRequest = new CreateArticleRequest();
        createArticleRequest.setBody("My Body");
        createArticleRequest.setTitle("My Title");
        createArticleRequest.setAuthorId(1);
        assertThrows(IllegalArgumentException.class, ()-> articleService.createNewArticle(createArticleRequest));
        try{
            articleService.createNewArticle(createArticleRequest);
        }
        catch (IllegalArgumentException ex){
            assertEquals("Author with id 1 does not exist", ex.getMessage());
        }
    }

    @Test public void savePost_postIdIsNotZero() {
        assertTrue(savedArticle.getId() != 0);
    }

    @Test public void findPostWithId() {
        Article found = articleService.findArticle(1);
        assertEquals("Felix...", found.getTitle());
    }

    @Test public void ThrowExceptionWhenWrongIdIsFound() {
        assertThrows(IllegalArgumentException.class, ()-> articleService.findArticle(2));
    }
}