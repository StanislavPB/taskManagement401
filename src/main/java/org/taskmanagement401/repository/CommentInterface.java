package org.taskmanagement401.repository;

import org.taskmanagement401.entity.Comment;
import org.taskmanagement401.entity.User;

import java.util.List;
import java.util.Optional;

public interface CommentInterface {
    public Comment add(Comment newComment);

    List<Comment> findAll();
    public Optional<Comment>findBySender(User sender);
    public Optional<Comment>findByRecipient(User recipient);


}
