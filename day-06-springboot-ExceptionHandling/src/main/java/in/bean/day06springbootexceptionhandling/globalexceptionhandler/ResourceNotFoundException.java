package in.bean.day06springbootexceptionhandling.globalexceptionhandler;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }
}
