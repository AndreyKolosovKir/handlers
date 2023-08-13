import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class Server {
    protected static String[] parts;

    protected static Map<String, Map<String, Handler>> handlers;

    public Server (){
        handlers = new HashMap<>();
    }

    public static void start(int countThread) {
        Settings settings = new Settings();
        ResponsText respons = new ResponsText();
        ResponseProcessor logicResponse = new ResponseProcessor();
        ExecutorService threadPool = Executors.newFixedThreadPool(countThread);

        try (ServerSocket serverSocket = new ServerSocket(settings.port())) {
            while (true) {
                Socket socket = serverSocket.accept();

                threadPool.execute(() -> {
                    try {
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());

                        String requestLine = in.readLine();
                        parts = requestLine.split(" ");

                        if (parts.length != 3) {
                            threadPool.shutdown();
                        }

                        //TODO

//                        String path = parts[1];
//                        logicResponse.responsLogic(path, out, respons); //по сути сервер до этого момента принимает станджартные запросы, а работает

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public String[] getParts (){
        return parts;
    }

    public void addHandler(String method, String messages, Handler handler) {
        Map<String, Handler> handlersMethod = new HashMap<>();
        handlersMethod.put(messages, handler);
        handlers.put(method, handlersMethod);
    }
}

