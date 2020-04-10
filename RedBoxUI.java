import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RedBoxUI
{
   public static void main(String [] args)
   {
      RedBoxMachine rm = new RedBoxMachine();
      Scanner sn = new Scanner(System.in);
      int option = 0;
      String title = "";

      System.out.println("Welcome to Redbox!");
      System.out.println("What can I help you with today?");
      System.out.println();

      while(true)
      {
         printMenu();
         option = Integer.parseInt(sn.nextLine());
         if(option == 1)
         {
            //Complete the code to List Available Titles.
            ArrayList<String> availableTitles = new ArrayList<String>();
            availableTitles = rm.getAvailableMovies();
            System.out.println(availableTitles);

            System.out.println("PRESS ENTER TO GO BACK TO THE MENU");
            sn.nextLine();
         }
         else if(option == 2)
         {
            System.out.println("What movie would you like to rent?");
            title = sn.nextLine();
            if (rm.rent(title) == true)
            {
               System.out.println("Rent successful! Thank you for renting " + title);
            }
            else
            {
               System.out.println("Movie is unavailable, select another movie :(");
            }
            // Complete the code to rent a movie. This code should let the user
            // know if the movie was rented successfully or not (not could occur if
            // the movie they enter is not available).
         }
         else if(option == 3)
         {
            System.out.println("What movie would you like to return?");
            title = sn.nextLine();
            rm.returnMovie(title);
            System.out.println("Movie returned!");
            // Complete the code to return a movie. Make sure to include a
            // message after the movie has been returned.

         }
         else if(option == 4)
         {
            System.out.println("What movie would you like to search for?");
            title = sn.nextLine();
            int find = rm.searchForMovie(title);
            if (find != -1 )
            {
               System.out.println("Movie has been found!");
            }
            else
            {
               System.out.println("Movie could not be found in stock :(");
            }
            // Complete the code to search for a movie.  Make sure to include
            // messages that inform the user whether the movie was found or not.

         }
         else if(option == 5)
         {
            System.out.println("Thanks for using Redbox!");
            System.out.println("Have a great day and come back soon!");
            System.exit(0);
         }
         else
         {
            System.out.println("Invalid Option! Please Try Again.");
         }
      }
   }

   //Prints all available options to the console.
   public static void printMenu()
   {
      System.out.println("1-List Available Titles");
      System.out.println("2-Rent Movie");
      System.out.println("3-Return Movie");
      System.out.println("4-Search for Movie");
      System.out.println("5-Quit");
      System.out.println();
   }
}
