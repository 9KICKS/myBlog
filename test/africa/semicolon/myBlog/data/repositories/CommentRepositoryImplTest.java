package africa.semicolon.myBlog.data.repositories;

import africa.semicolon.myBlog.data.models.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommentRepositoryImplTest {
    private CommentRepository commentRepository;

    private Comment comment;

    private Comment comment2;

    @BeforeEach void setUp() {
        comment = new Comment();
        comment2 = new Comment();
        commentRepository = new CommentRepositoryImpl();
    }

    @Test public void saveOneComment_CountIsOne() {
        Comment comment = new Comment();
        commentRepository.save(comment);
        assertEquals(1, commentRepository.count());
    }

    @Test public void saveOneComment_IdOfCommentIsOne() {
        Comment savedComment = commentRepository.save(comment);
        assertEquals(1, savedComment.getId());
    }

    @Test public void saveComment_commentIdDidNotChangeTest() {
        Comment savedComment = commentRepository.save(comment);
        assertEquals(1, savedComment.getId());
        savedComment.setComment("::: Sha, i don tire..");
        commentRepository.save(savedComment);
        assertEquals(1, commentRepository.count());
    }

    @Test public void saveOneComment_andGetByIdTest() {
        Comment savedComment = commentRepository.save(comment);
        assertEquals(1, commentRepository.count());
        savedComment.setComment("Hard....");
        commentRepository.save(savedComment);
        assertEquals(1, commentRepository.count());
    }

    @Test public void saveCommentAndGetCommentWithId() {
        Comment saved = commentRepository.save(comment);
        assertEquals(1, commentRepository.count());
        Comment find = commentRepository.findById(1);
        assertEquals(find, saved);
    }

    @Test public void saveOneCommentAndDeleteCommentWithId() {
        Comment saved = commentRepository.save(comment);
        assertEquals(1, commentRepository.count());
        commentRepository.delete(1);
        assertEquals(0, commentRepository.count());
    }

    @Test public void saveTwoComments_DeleteTwoCommentAndCountIsZero() {
        Comment saved = commentRepository.save(comment);
        Comment saved2 = commentRepository.save(comment2);
        assertEquals(2, commentRepository.count());
        commentRepository.delete(1);
        commentRepository.delete(2);
        assertEquals(0, commentRepository.count());
    }
}