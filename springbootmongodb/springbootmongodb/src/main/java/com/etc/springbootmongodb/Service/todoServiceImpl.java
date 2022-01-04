package com.etc.springbootmongodb.Service;

import com.etc.springbootmongodb.exception.todoCollectionException;
import com.etc.springbootmongodb.model.todoDTO;
import com.etc.springbootmongodb.repository.todoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class todoServiceImpl implements todoService{

    @Autowired
    private todoRepository todoRepo;

    @Override
    public void createTodo(todoDTO todo) throws ConstraintViolationException, todoCollectionException {
        Optional<todoDTO> todoOptional = todoRepo.findByNotiMsg(todo.getNotiMsg());
        if(todoOptional.isPresent()){
            throw new todoCollectionException(todoCollectionException.todoAlreadyExists());
        }else {
            todo.setReceiverTime(new Date(System.currentTimeMillis()));
            todoRepo.save(todo);
        }
    }

    @Override
    public List<todoDTO> getAllTodos() {
        List<todoDTO> todos = todoRepo.findAll();
        if(todos.size() > 0){
            return todos;
        }else {
            return new ArrayList<todoDTO>();
        }
    }

    @Override
    public todoDTO getSingleTodo(String userId) throws todoCollectionException {
      Optional<todoDTO> optionalTodo = todoRepo.findById(userId);
      if(!optionalTodo.isPresent()){
          throw new todoCollectionException(todoCollectionException.notFoundException(userId));
      }else{
          return optionalTodo.get();
      }
    }

    @Override
    public void updateTodo(String userId, todoDTO todo) throws todoCollectionException {
        Optional<todoDTO> todoWithId = todoRepo.findById(userId);
        Optional<todoDTO> todoWithSameName = todoRepo.findByNotiMsg(todo.getNotiMsg());

        if(todoWithId.isPresent()){
            if(todoWithSameName.isPresent() && !todoWithSameName.get().getUserId().equals(userId)){
                throw new todoCollectionException(todoCollectionException.todoAlreadyExists());
            }
        todoDTO todoToUpdate = todoWithId.get();

        todoToUpdate.setNotiMsg(todo.getNotiMsg());
        todoToUpdate.setStatus(todo.getStatus());
        todoToUpdate.setChangeTime(new Date(System.currentTimeMillis()));
        todoRepo.save(todoToUpdate);
    }else {
            throw new todoCollectionException(todoCollectionException.notFoundException(userId));
        }
    }

    @Override
    public void deleteTodoById(String userId) throws todoCollectionException {
        Optional<todoDTO> todoOptional = todoRepo.findById(userId);
        if(!todoOptional.isPresent()){
            throw new todoCollectionException(todoCollectionException.notFoundException(userId));
        }else {
            todoRepo.deleteById(userId);
        }
    }


}
