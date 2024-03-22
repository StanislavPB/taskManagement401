package org.taskmanagement401.repository;

import org.taskmanagement401.dto.CommentDto;
import org.taskmanagement401.entity.Comment;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommentRepository
//        implements CommentInterface
{

    private List<Comment> commentList;
    private int id = 1;

    public CommentRepository() {
        this.commentList = new ArrayList<>();
    }

  private Comment create ( CommentDto commentDto,User user){
        return new Comment(user,commentDto.getComment());
  }
    public Comment add(User user, CommentDto commentDto, Task task) {

      return create(commentDto,user);

    }


}
