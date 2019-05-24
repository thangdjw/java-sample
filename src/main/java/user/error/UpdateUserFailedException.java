package user.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class UpdateUserFailedException extends IllegalStateException {
    public UpdateUserFailedException(String message){
        super("Can not create or update user : "+message);
    }
}
