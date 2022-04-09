//IMPORTING THE LIBRARIES HERE
//this library is used for the scanner statement
import java.util.*;
//this library is used for input/output , file streams
import java.io.*  ;

//Main Class
//******************** INHERITANCE IS USED HERE ****************
//                      Using extends keyword
// TicketBookingSystem = Parent Class
// loginDetails = Sub-class
public class TicketBookingSystem extends loginDetails {

    public static void main(String[] args)throws IOException
        { 
 
       
//WELCOME SCREEN
        System.out.println("***************************************************************************\n");
        System.out.println("***************************************************************************\n");
        System.out.println("                   WELCOME TO TICKET BOOKING SYSTEM                        \n");
        System.out.println("***************************************************************************\n");
        System.out.println("***************************************************************************\n");
        
//INSTRUCTIONS FOR THE CODE RUNNING        
        System.out.println("***************************************************************************\n");
        System.out.println(" Instructions :  \n 1. Enter 1 to quit the ticket booking system    \n ");
        System.out.println("***************************************************************************\n");
 
//CREATING object for the LoginDetails
    loginDetails obj = new loginDetails();
//calling the method login in loginDetails Class
    obj.login();
    
    }
    
}
