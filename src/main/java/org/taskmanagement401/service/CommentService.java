package org.taskmanagement401.service;

import org.taskmanagement401.dto.ResponseDTO;
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
    //vernut DTO response
    public ResponseDTO addNewComment(String comment){
       // validaciya na length <10
        //esli ok Comment repositoriyCommentary . method. addComment(comment)
        //else List<Errors> List!!!!!!!!
        //new ResponseDTO<>(400,List!!!!!!!!);


        /*Comment newComment = commentCreate();
        commentRepository.add(newComment);*/
        return new ResponseDTO<>(200,"Status ok");
    }}

