package org.taskmanagement401.service;

import org.taskmanagement401.entity.Comment;
import org.taskmanagement401.repository.CommentRepository;

public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    private Comment commentCreate(){
        return null;
    }
    public void addNewComment(){
        Comment newComment = commentCreate();
        commentRepository.add(newComment);
    }
}
