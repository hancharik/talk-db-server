package multiserve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class RequestHandler implements Runnable {
  private Socket client;
  ServerSocket serverSocket = null;
  ArrayList<String>commands = new ArrayList();
  private boolean brokenComputer = false;
DBconnector conn;
    public RequestHandler(Socket client) {
      this.client = client;
      fillCommandList();
    }

    @Override
    public void run() {
      try ( BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));) {
	System.out.println("Thread started with name:" + Thread.currentThread().getName());
	String userInput;
	while ((userInput = in.readLine()) != null) {
	  userInput=userInput.replaceAll("[^A-Za-z0-9 ]", "");
          System.out.println("Received message from " + Thread.currentThread().getName() + " : " + userInput);
	  writer.write(response(userInput));
	  writer.newLine();
	  writer.flush();
	}
      } catch (IOException e) {
           System.out.println("I/O exception: " + e);
        } catch (Exception ex) {
	   System.out.println("Exceprion in Thread Run. Exception : " + ex);
	  }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    private String response(String a){
       
      if(multiserve.Server.dbStarted){
          multiserve.Server.dbStarted = false;
        return  "database started" ;  
          
      }
        
        
        Random rand = new Random();
    
        
        if(brokenComputer){
            
           int choice = rand.nextInt(7)+1; 
           
           System.out.println("choice for switch statement line 67 is " + choice);
          switch(choice){
case 1 : return a + "? Why wood you say " + a + "?";
case 2 : return  "How can you say that?" ;
case 3 : return " What do you mean, " + a + "?";
case 4 : return a +" . what is that supposed to mean, " + a + ".";
case 5 : brokenComputer = false; return  " terminating reduced capacity simulation. " +" computer is now running at optimal parameters. " ;


default : return  "Do you even care about me?" ; 

}  
            
            
            
            
            
        }else {
        
            int commandChoice = 99;
            
           for(int e = 0; e < commands.size(); e++){
               if(a.contains(commands.get(e))){
                   commandChoice = e;
               }
           } 
      
        
        switch(commandChoice){
            case 0 :  return "Ship is at x coordinate " + rand.nextInt(100)+1 + ", y coordinate " + rand.nextInt(100)+1 +"";
             case 1 :  return "crew is at " + rand.nextInt(1000)+1 ;
             case 2 :  return "the pleasure is all mine, captain. perhaps we can discuss a promotion at our next meeting."  ;//"you are. welcome. captain"  ;
             case 3 :  return "fires on level " + rand.nextInt(6)+1 ;
             case  4 :  return "our cargo is " + " a load of space widgets " ;
              case 5 :  return "beginning hyperdrive sequence. " + " initializing navigational computer. " ;
              case 6 :  brokenComputer = true;  return "computer is now running at sub optimal parameters. " + " computer will now simulate  reduced capacity  mode. " ;
               case 7 :  return "there are zero space monkeys in this sector"  ;
                case 8 :  return  readCommandList() ;
                case 9 :   return "all systems are functioning at optimal parameters"  ;
                case 10 :   return "scanning sector for suitable planets.  search returned. no acceptable planets. repeat, no, meaning zero, count them, zero acceptable planets are located in this sector."  ;
             case 11 :   conn = new DBconnector(); return "attempting to begin data connection."  ;
             case  12 :  return conn.getDepartment(a);
              case 13 :  return conn.getDepartment(a);
              case  14 : return conn.getDepartment(a);
              case 15 :  return conn.getDepartment(a);
              default :   return "I. did not. understand that request";
        }
    }
        //return "I didn't understand that request";
    }  // end response method
   
    
   private String speakList(ArrayList a){
       String temp = "";
       for(int i = 0; i < a.size(); i ++){
           
           temp = temp + a.get(i);
       }
       System.out.println("temp "+temp);
      return temp; 
   }  
    
    
    
    
    
  private void fillCommandList(){
      
      // if you add a command, add to the end of the list only, and  
      //you will also need to update the normal resonse() switch statement  
      
      
        commands.add("ship");
        commands.add("crew");
        commands.add("thank");
        commands.add("fire");
        commands.add("cargo");
        commands.add("drive");
        commands.add("off");
        commands.add("monkey");
        commands.add("list");
        commands.add("status");
        commands.add("scan");
        commands.add("db");
        commands.add("science");
        commands.add("engineering");
        commands.add("security");
        commands.add("flight crew");
      
      
  }  // end fill command list
    
private String readCommandList(){
    
    String buildList = "I recognize a list of " + commands.size() + " commands. My primary command is " + commands.get(0);
    System.out.println("I recognize a list of " + commands.size() + " commands. \nMy primary command is " + commands.get(0));
      for(int w = 1; w < commands.size(); w++){
              buildList = buildList + ". command number " + (w+1) + " is " + commands.get(w);
              System.out.println(". \ncommand number " + (w+1) + " is " + commands.get(w));
               }
    
    return buildList;
}   // end read command list 
    
    
    
    
} // end class


