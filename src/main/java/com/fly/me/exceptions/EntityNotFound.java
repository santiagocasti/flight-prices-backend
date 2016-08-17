package com.fly.me.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)  // 404
public class EntityNotFound extends RuntimeException {

    public EntityNotFound(String entityType, String entityName) {
        super(String.format("%s [%s] not found ",entityType, entityName));
    }

}
