package com.etc.springbootmongodb.exception;

public class todoCollectionException extends Exception{


    private static final long serialVersionUID = 1L;

    public todoCollectionException(String message){
        super(message);
    }

    public static String notFoundException(String userId){
        return "NotiMsg with" + userId +"not found";
    }

    public static String todoAlreadyExists(){
        return "NotiMsg with given name already exists";
    }
}
