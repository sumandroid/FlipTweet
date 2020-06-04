package exceptions;

public class FollowersAlreadyAddedException extends RuntimeException {

    public FollowersAlreadyAddedException(String message){
        super(message);
    }
}
