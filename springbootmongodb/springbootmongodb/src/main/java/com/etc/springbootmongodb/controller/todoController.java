package com.etc.springbootmongodb.controller;

import com.etc.springbootmongodb.Service.todoService;
import com.etc.springbootmongodb.exception.todoCollectionException;
import com.etc.springbootmongodb.model.todoDTO;
import com.etc.springbootmongodb.repository.todoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class todoController {

    @Autowired
    private todoRepository todoRepo;

    @Autowired
    private todoService todoServ;

    @GetMapping("/notification_inbox_collection")
    public ResponseEntity<?> getAllTodos(){
        List<todoDTO> todos = todoServ.getAllTodos();
        return new ResponseEntity<>(todos, todos.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);

    }

    @PostMapping("/notification_inbox_collection")
    public ResponseEntity<?> createTodo(@RequestBody todoDTO todo){
        try{
            todoServ.createTodo(todo);
            return new ResponseEntity<todoDTO>(todo, HttpStatus.OK);
        }catch(ConstraintViolationException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }catch(todoCollectionException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/notification_inbox_collection/{userId}")
    public ResponseEntity<?> getSingleTodo(@PathVariable("userId") String userId){
        try{
            return new ResponseEntity<>(todoServ.getSingleTodo(userId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/notification_inbox_collection/{userId}")
    public ResponseEntity<?> updateById(@PathVariable("userId") String userId, @RequestBody todoDTO todo){
        try{
            todoServ.updateTodo(userId, todo);
            return new ResponseEntity<>("Update notiMsg with userId" + userId, HttpStatus.OK);
        }catch(ConstraintViolationException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }catch (todoCollectionException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/notification_inbox_collection/{userId}")
    public ResponseEntity<?> deleteById(@PathVariable("userId") String userId){
        try{
            todoServ.deleteTodoById(userId);
            return new ResponseEntity<>("Successfully deleted with userId" + userId, HttpStatus.OK);
        }catch (todoCollectionException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
