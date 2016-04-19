package multiserve;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    
    
    public static boolean dbStarted = false;
    
    
    
  public static void main(String[] args) throws IOException {
    System.out.println("ok, lets try this thing...");
    if (args.length < 1) {
      System.err.println("port number : ");
      System.exit(1);
    }
    int portNumber = Integer.parseInt(args[0]);
    ExecutorService executor = null;
    try (ServerSocket serverSocket = new ServerSocket(portNumber);) {
      executor = Executors.newFixedThreadPool(5);
      System.out.println("good to go, waiting on clients");
      while (true) {
        Socket clientSocket = serverSocket.accept();
        Runnable worker = new RequestHandler(clientSocket);
        executor.execute(worker);
      }
    }catch (IOException e) {
       System.out.println("problem with port " + portNumber + " (or listening for a connection)");
       System.out.println(e.getMessage());
    } finally {
        if (executor != null) {
	executor.shutdown();
	}
    }
  }
}

