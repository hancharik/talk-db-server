/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiserve;



import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author mark
 */
public class User {
    
    
    private String name;
    private int idNumber;
   // private ArrayList<Category> contacts;
    private String picture = "images/tf1.jpg";
    private int colorTheme = 9;
    
    
    
    /////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////
    //////////////   biometric data  /////////////////////
    
        
    int race;// = "human";
    
    Color hair;
    
    int mc1r;  // chromosome responsible for skin color
    Color skin;
    
    
    Color line;
    Color notskin;
    Color shirtout;
    Color shirtfill;

    int headX;
    int headY;
    int skinX;
    int skinY;
    int shirtOutX;
    int shirtOutY;
    int shirtFillX;
    int shirtFillY;
    
    
    
    int headsize;
    int skinsize;
    int hairthickness;
    int mouthThickness;
    int mouthWidth;
    int eyeSize;
    int shirtOutSize;
    int shirtFillSize;
    
    
    
    
    int mouthX;
    int mouthY;
    int eyeRx;
    int eyeRy;
    int eyeLx;
    int eyeLy;
    
    
    int sizeDeterminant;
    
    

    
    ///these are standard values to make the face look right
    
    int mouthXi = 15;
    int mouthYi = 22;
    int eyeRxi = 21;
    int eyeRyi = 17;
    int eyeLxi = 18;
    int eyeLyi = 17;
    
    
    
    
    
    
    //////////////   biometric data  /////////////////////
       /////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public User(String name, int id){
    
       this.name = name; 
        idNumber = id;
        initContacts();
        setBiometricData();
     }  // end constructor
    
    
    
    
        public User(String name, int id, int theme){
    
       this.name = name; 
        idNumber = id;
        this.colorTheme = theme;
        initContacts();
        setBiometricData();
     }  // end constructor
    
        
        
        
        
   private void initContacts(){
       
    //   contacts = new ArrayList();
      // Category tickets = new Category((11 + idNumber),"tickets", idNumber);
       // timesheet should pull up array of tickets actually, you hit the button to start the timer, you hit the button to stop, it brings up comment page
     // Category timesheet = new Category((12 + idNumber),"timesheet", idNumber);
   }
    
     private void setBiometricData(){
       
         Random geneticVariance = new Random(); 
         
         
         
         
         race = 1;  // 1 = human, after that, you have to look at the switch statement in the PicPanel
    
         // black for now, haven't figured this one out
    hair = new Color(10, 10, 10);
    
     // real skin tones
     
     mc1r = 1 + geneticVariance.nextInt(175);
     
       
       
    
    line = new Color(0, 0, 0);
 
    
    Random rand = new Random();
        int r = 1 + rand.nextInt(255);
        int g = 1 + rand.nextInt(255);
        int b = 1 + rand.nextInt(255);
    
    // for now, just set the outline to black
    shirtout = new Color(0,0,0);
    //  and let the fill be random - maybe we can add a stripe to the shirt later
    shirtfill= new Color(r,g,b);
    
    
    
    
    
    
    hairthickness = 10;
     headsize = 100;
     skinsize = headsize - hairthickness;
   
   
      int tenth = (int)Math.ceil(headsize /10);
      int hundredth = (int)Math.ceil(headsize / 100);
     
    mouthWidth = (int)(headsize / 2) + (geneticVariance.nextInt(tenth) - (tenth / 2));
     
     mouthThickness = (int)Math.ceil(hundredth + geneticVariance.nextInt(2 * hundredth));  // mouthThickness  = 1 + rand.nextInt(3) + 1;
     eyeSize = 4 * hundredth;
    headX = headsize / 2;
     headY = headsize / 2;
      mouthX= headX * mouthXi / 10;
     mouthY = headY * mouthYi / 10;
   eyeRx = headX * eyeRxi / 10;
   eyeRy = headY * eyeRyi / 10;
   eyeLx = headX * eyeLxi / 10;
    eyeLy = headY * eyeLyi / 10;
   skinX = headX + (hairthickness / 2);
    skinY = headY + (hairthickness / 2);
    
    
    
    
    shirtOutX = headX - (int)(.48*headsize);
    shirtOutY =  headY + (int)(.80*headsize);
   shirtFillX = skinX  - (int)(.44*headsize);
    shirtFillY = skinY + (int)(.80*headsize);
    
    
    shirtOutSize = headsize*2;
    shirtFillSize =  skinsize*2;
    
    
    
    
  
    
    
    //int sizeDeterminant;
    
    

    
    ///these are standard values to make the face look right
    
    mouthXi = 15;
     mouthYi = 22;
    eyeRxi = 21;
    eyeRyi = 17;
    eyeLxi = 18;
   eyeLyi = 17; 
       
      
   }
   
   
   
   
   
   
   
    public String getName(){
        
        return name;
    }
    
   // public ArrayList getContacts(){
     
    //    return contacts;
    //}
    
     public String getPicture(){
        
        return picture;
    }
    
    public int getTheme(){
        
        
        
        return colorTheme;
    }
     
  // public void addCategory(Category c){
       
     //  contacts.add(c);
       
  // }  
     public int getId(){
         
         return idNumber;
         
     }
     
     
}// end class
