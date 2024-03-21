package org.taskmanagement401.service;

import org.taskmanagement401.dto.CommentDto;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.dto.error.ErrorDto;
import org.taskmanagement401.entity.Comment;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.CommentRepository;
import org.taskmanagement401.service.validation.CommentValidation;

import java.util.List;

public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    private Comment commentCreate(){
        return null;
    }
    //vernut DTO response
    public ResponseDTO addNewComment(User user, CommentDto commentDto, Task task) {
        CommentValidation validation = new CommentValidation();
        List<ErrorDto> errors =
                validation.checkComment(commentDto);

        if (errors.isEmpty()) {
            commentRepository.add(user, commentDto, task);
            return new ResponseDTO<>(200, "status ok");
        } else {
            return new ResponseDTO<>(400, errors);
        }

       // validaciya na length <10
        //esli ok Comment repositoriyCommentary . method. addComment(comment)
        //else List<Errors> List!!!!!!!!
        //new ResponseDTO<>(400,List!!!!!!!!);


        /*Comment newComment = commentCreate();
        commentRepository.add(newComment);*/

    }}

