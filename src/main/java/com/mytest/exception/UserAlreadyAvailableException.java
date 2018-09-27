package com.mytest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "User already available.")
public class UserAlreadyAvailableException extends Exception
{
    
	private static final long serialVersionUID = 3859780152447089226L;


	public UserAlreadyAvailableException(String message)
    {
        super(message);
    }

}
