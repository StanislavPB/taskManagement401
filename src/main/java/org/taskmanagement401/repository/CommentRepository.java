package org.taskmanagement401.repository;

import org.taskmanagement401.entity.Comment;
import org.taskmanagement401.entity.User;

import java.util.List;
import java.util.Optional;

public class CommentRepository
//        implements CommentInterface
{

    private List<Comment> commentList;
    private int id = 1;

    public CommentRepository(List<Comment> commentList) {
        this.commentList = commentList;
    }

  //  @Override
    public void add(String newComment) {
        //Commant commet= create(newComment);
        //commentList.add(commet)


        /*newComment.setId(id++);
        commentList.add(newComment);
        return newComment;*/
    }
    //private Comment method create (comment)
    //id
    //@Override
    public List<Comment> findAll() {
        return commentList;
    }

    //@Override
    public Optional<Comment> findBySender(User sender) {
        for (Comment comment:commentList){
            if (comment.getUser().equals(sender)){
                return Optional.of(comment);
            }
        }

        return Optional.empty();
    }

    //@Override
    public Optional<Comment> findByRecipient(User recipient) {
        for (Comment comment:commentList){
            if (comment.getUser().equals(recipient)){
                return Optional.of(comment);
            }
        }

        return Optional.empty();
    }
}
