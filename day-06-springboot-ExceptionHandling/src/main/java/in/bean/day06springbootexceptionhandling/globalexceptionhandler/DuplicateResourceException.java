package in.bean.day06springbootexceptionhandling.globalexceptionhandler;

public class DuplicateResourceException extends RuntimeException{
    public DuplicateResourceException(String message){
        super(message);

    }
}
