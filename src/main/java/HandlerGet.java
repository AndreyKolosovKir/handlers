import java.io.BufferedOutputStream;

public class HandlerGet implements Handler{
    @Override
    public void handle(Request request, BufferedOutputStream responseStream) {
        System.out.println(1);
    }
}
