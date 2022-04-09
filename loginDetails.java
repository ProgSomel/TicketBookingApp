//IMPORTING THE LIBRARIES HERE
import java.util.Scanner; 
import java.io.*;



// CLASS LOGIN DETAILS DECLARED HERE !!!!
// *********************** MULTIPLE INHERITANCE ****************************
// Multiple inheritance is done using "implements" keyword

class loginDetails implements  menu_Style , Vechile , tickets_Price_List
{
//buffered reader is used here , we will later use this for file input
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));   
//********************** DATA ENCRYPTION  *****************************
 
    //username and password declared as private members , means this will be accessed under 
    //this class only and the its sub class using getter method
        private String username = null;
        private String password = null;
        int NumOfTickets = 0;
      
    //getter method for the Username 
    public String getUsername() {
        return username;
    }

    //Setter method for the Username
    public void setUsername(String username) {
        this.username = username;
    }

    //getter method for the Password
    public String getPassword() {
        return password;
    }

    //setter method for the password
    public void setPassword(String password) {
        this.password = password;
    }

    //getter method for Choice
    public int getChoice() {
        return choice;
    }

    //constructor
    //a-No-Argument Constructor
    public loginDetails() 
    {
    //using this keyword 
    username = this.username;
    password = this.password;
    
    }

    //setter method for choice
    public void setChoice(int choice) {
        this.choice =  choice;
    }

    //getter method for choice2
    public int getChoice2() {
        return choice2;
    }

    //setter method for Choice2
    public void setChoice2(int choice2) {
        this.choice2 = (char) choice2;
    }
       
        //choice , choice2 declared here
        //choice for choosing whether you are a guest , a regular customer , or you want to quit
        int choice = 0 ;
        //choice2 for choosing the type of vechile for travelling
        char choice2 = 0;
        //the total Amount
        int BalanceAmount = 0;
        //number of tickets user wants to buy
        //int NumOfTickets = 0;
      
        //THE LOGIN METHOD , Along with the throw exception
        public void login() throws IOException
        {
//the do loop , it will break when choice = 1
    do 
        {    
            
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
       //calling a  method starting from menu_Style interface
        starting();
        //reading it throw the buffered stream Reader
        choice2 = (char) in.read();
        //cases are as under
        switch(choice2)
        {
            case 'C' :
            {
        //username entry check here
       System.out.print("Enter your Username :  ");
       username = sc.nextLine();
       
       //if the username starts with & its okay but if its not it will show the username don't exist its wrong
if ( !username.startsWith("&"))
{
    System.out.println("INVALID USERNAME!!");
    choice = 1;
    
    //loop break here
    break;
}
    //password here 
       System.out.print("Enter your Password :  ");
       password = sc.nextLine();
    //calling the proceeding method here from the  interface
       proceeding();
       //enter number of tickets you want to buy
       System.out.print(" How many tickets you want to book  =  ");
       NumOfTickets= sc.nextInt();
       
      
      //calling getDetails method here from interface 
      BalanceAmount = getDetails();
      
      BalanceAmount=BalanceAmount*NumOfTickets;
      //calling getReciept method here
      getReciept();
                break;
            }
            
            //case if the user is a guest , he need to register first
            case 'G':
            {
//calling a method here                
       new_customer(); 
       
       System.out.print("Enter your Username :  ");
       username = sc.next();
       //username check!
      if ( !username.startsWith("&"))
       {
           System.out.println("----------------------------------------------------- ");
           
           System.out.print("WRONG TRY FOR THE USERNAME ENTERED , TRY AGAIN \n ");
           
           System.out.print("USERNAME MUST START WITH '&' \n ");
           
           System.out.println("----------------------------------------------------- ");
           
           break;
       }
             
       System.out.print("Enter your Password :  ");
       password = sc.next();
      
       //password check
       if ( password.length() == 9 ||password.length() == 10 || password.length() == 11  )
       {
             System.out.print("\n ***** Strong Password  ****** \n  ");

       }
       System.out.print(" How many tickets you want to book  =  ");
       NumOfTickets= sc.nextInt();
       //calling a method here
       proceeding();
       //calling getDetails
       BalanceAmount = getDetails();
       BalanceAmount=BalanceAmount*NumOfTickets;
       //calling getReciept
       getReciept();
                break;
            }
            
            //case if he wants to quit without buying
            case 'Q':
            {
                quit();
                choice = 1;
                break;
            }
        
            //default case , invalid entry
            default:
            {
                System.out.println(" INVALID ENTRY DEAR CUSTOMER , TRY AGAIN ");
                break;
            }
        }
    
        
        System.out.print(" Do you want to continue ( 1 if you want to leave ) =  ");
        //try-catch block here
        try
        {
        choice = sc.nextInt();
        }
        catch(Exception c)
        {
            c.printStackTrace();
            System.out.println(" YOU HAVE ENTERED WRONG DATA TYPE ");
        }
        }
        while(choice != 1);
//do while loop here
        }

    //***************************** POLYMORPHISM HERE ******************************
    //OVER-RIDING IS A TYPE OF POLYMORPHISM
        @Override 
    public void starting()
    {
  
        System.out.println(" Enter : \n 'C' if you are a regular customer. \n 'G' If you are a guest. \n 'Q' If you want to Quit.  ");
        System.out.println(" Enter Here : ");
        
    }

     //***************************** POLYMORPHISM HERE ******************************
    //OVER-RIDING IS A TYPE OF POLYMORPHISM
  
    @Override
    public void proceeding()
    {
     
       System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
       System.out.println("                 ---  WE ARE PROCEEDING ---  ");
       System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

    
    }

     //***************************** POLYMORPHISM HERE ******************************
    //OVER-RIDING IS A TYPE OF POLYMORPHISM
  
    @Override
    public void quit()
    {
     
       System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
       System.out.println("                   THANKS FOR VISITING US                            ");
       System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

    
    }
    
    //***************************** POLYMORPHISM HERE ******************************
    //OVER-RIDING IS A TYPE OF POLYMORPHISM
  
    @Override
    public void new_customer() {
 
        System.out.println(" WE WELCOME YOU TO OUR TICKETING SYTEM ");
        System.out.println(" 1. THE USERNAME SHOULD START WITH '&' ");
        System.out.println(" 2. IF USERNAME DON'T START WITH '&' IT WILL SHOW AN ERROR ");
        System.out.println(" 2. THE USERNAME SHOULD BE 10 CHARACTER LONG ONLY ");
        System.out.println(" 3. GOOD PASSSWORD IS 11 CHARCTERS MAXIMUM ");

    }
    
    //***************************** POLYMORPHISM HERE ******************************
    //OVER-RIDING IS A TYPE OF POLYMORPHISM
  
    @Override
    public int getDetails()
    {

        int balance= 0;
        System.out.println("*************************************************************************");
        System.out.println("           Choose the type of Vechile for Travelling : ");
        System.out.println(" 1. BUS \n 2. PLANE \n 3. TRAIN ");
        System.out.println("*************************************************************************");
        
        int Vchoose = 0;
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
                    Vchoose = sc.nextInt();
  //CHOOSE TYPE OF VECHILE HERE 
  // BUS , PLANE , TRAIN 
  
                    //Vchoose = (char) in.read()
            
         int x = 0;
        switch(Vchoose)
        {
            case 1 :
            {
                x =  priceBus(); 
                break;
            }
            case 2:
            {
                x =  pricePlane();
                break;
            }
            case 3:
            {
                x=  priceTrain();
                break;
            }
            default :
            {
                System.out.println(" IN-VALID ENTRY ! ");
                break; 
            }
                 
        }
        return x;
    }

   //***************************** POLYMORPHISM HERE ******************************
    //OVER-RIDING IS A TYPE OF POLYMORPHISM
    
    @Override
    public int priceBus() 
    {

       System.out.println(" So , there are two classes for ticketing in Bus Travel \n 1.First Class \n 2.Upper Class ");
       System.out.println(" 1. First Class ->  Ticket Price = ৳ 5000 /- ");
       System.out.println(" 2. Second Class -> Ticket Price = ৳ 2500 /- ");
       System.out.print  (" Enter your Choice =  ");
       Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
       int var= sc.nextInt();
       switch(var)
       {
           case 1:
           {
                 var = 5000;
                 break;
           }
           case 2:
           {
                var = 2500;
                break;
           }
       }
       return var;
    }

    //***************************** POLYMORPHISM HERE ******************************
    //OVER-RIDING IS A TYPE OF POLYMORPHISM
  
    @Override
    public int pricePlane()
    {
 
       System.out.println(" So , there are two classes for ticketing in Plane Travel \n 1.First Class \n 2.Upper Class ");
       System.out.println(" 1. First Class ->  Ticket Price = ৳ 17000 /- ");
       System.out.println(" 2. Second Class -> Ticket Price = ৳ 10000 /- ");
       Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
       int var= sc.nextInt();
       switch(var)
       {
           case 1:
           {
                 var = 17000;
                 break;
           }
           case 2:
           {
                var = 10000;
                break;
           }
       }
       return var;
    }

    //***************************** POLYMORPHISM HERE ******************************
    //OVER-RIDING IS A TYPE OF POLYMORPHISM
  
    @Override
    public int priceTrain()
    {
 
       System.out.println(" So , there are two classes for ticketing in Train Travel \n 1.First Class \n 2.Second Class ");
       System.out.println(" 1. First Class ->  Ticket Price = ৳ 6000 /- ");
       System.out.println(" 2. Second Class -> Ticket Price = ৳ 3000 /- ");
  Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
       int var= sc.nextInt();
       switch(var)
       {
           case 1:
           {
                 var = 6000;
                 break;
           }
           case 2:
           {
                var = 3000;
                break;
           }
       }
       return var;
    }

    //***************************** POLYMORPHISM HERE ******************************
    //OVER-RIDING IS A TYPE OF POLYMORPHISM
  
    @Override
    public void booked() 
    {
        System.out.println(" THE TICKET HAS BEEN BOOKED SUCCESSFULLY  !!!  " );
        getReciept();
    }

    //***************************** POLYMORPHISM HERE ******************************
    //OVER-RIDING IS A TYPE OF POLYMORPHISM
  
    public void getReciept() 
    {

        System.out.println( "------------------------------------------------------------ ");
        System.out.println( "------------------------------------------------------------ ");
        System.out.println( "              RECIEPT OF OUR TICKETING SYSTEM                ");
        System.out.println( "------------------------------------------------------------ ");

        System.out.println( "------------------------------------------------------------ ");
        System.out.println( "             Username  " +username                            );
        System.out.println( "             Password  ***********                           ");
        System.out.println( "             Number of Tickets :  " +NumOfTickets             );
        System.out.println( "        BalanceAmount =  ৳ " +BalanceAmount                 );
        System.out.println( "------------------------------------------------------------ ");
        System.out.println( "------------------------------------------------------------ ");

        
    } 


}


