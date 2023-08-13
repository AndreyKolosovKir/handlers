import java.io.BufferedOutputStream;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class Main {
    final static int CountThreads = 64;

    public static void main(String[] args) {
        //        Server.start(CountThreads);
        Server server = new Server();
        HandlerGet handlerGet = new HandlerGet();
        String[] get = server.getParts();
        server.addHandler(get[0], get[1], new Handler() {
            @Override
            public void handle(Request request, BufferedOutputStream responseStream) {
                System.out.println(1);
            }
        });
        server.start(CountThreads);
    }
}



