package com.etc.springbootmongodb.Service;

import com.etc.springbootmongodb.exception.todoCollectionException;
import com.etc.springbootmongodb.model.todoDTO;
import javax.validation.ConstraintViolationException;
import java.util.List;

public interface todoService {
    public void createTodo(todoDTO todo) throws ConstraintViolationException, todoCollectionException;

    public List<todoDTO> getAllTodos();

    public todoDTO getSingleTodo(String userId) throws todoCollectionException;

    public void updateTodo(String userId, todoDTO todo) throws todoCollectionException;

    public void deleteTodoById(String userId) throws todoCollectionException;
}
