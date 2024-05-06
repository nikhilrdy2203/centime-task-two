package com.assignment.tasktwo.exception;

import org.springframework.http.HttpStatus;

public class RelationDataNotException extends RuntimeException {
    public RelationDataNotException(String s) {
        super(s);
    }
}
