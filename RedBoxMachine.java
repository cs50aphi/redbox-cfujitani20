import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class represents a Redbox Machine that allows users
 * to rent and return movies.
 * @author
 * @version 1.0
 */
public class RedBoxMachine
{
   //Create an instance variable to hold all of the DVDs.
   ArrayList<DVD> library = new ArrayList<DVD>();
   private int num;
   /** the list of DVDs */

   /** Constructs a Redbox Machine and fills it with DVDs
    *  Reads the file MovieList.txt so make sure that the
    *  file is in the same folder as the RedboxMachine.class
    *  file.
    */

   public RedBoxMachine()
   {
      // Complete the constructor.
      // Leave this method. It will fill the machine with DVDs.
      fillMachine();
   }

   /** Searches for the movie with the provided title and returns
    *  the position of the DVD in the list if the DVD is found and
    *  -1 if the DVD is not in the list.
    *  @param title the title of the DVD being searched for.
    *  @return the index of the DVD in the list if present and
    *          -1 if the DVD is not in the list.
    */

   public int searchForMovie(String title)
   {
      // for loop to check each index of the array list to search for movie title
      for (int i = 0; i < library.size(); i++ )
      {
         if ( library.get(i).getTitle().equals(title))
         {
            // return movie from index
            return i;
         }
      }
      // return -1 if movie is not in stock
      return -1;
      // Complete the method to search for a movie.
      // If placement is -1, then the movie isn't there.
      // Find the index of i if the movie is there.
   }

   /** Returns the titles of all available DVD's in
    *  the machine.
    *  @return an ArrayList of Strings containing the
    *          titles of all available movies.
    */
   public ArrayList<String> getAvailableMovies()
   {
      // arraylist to scan array list for movie and place in temp to check if it can be removed
      ArrayList<String> temp = new ArrayList<String>();
      for (int p = 0; p < library.size(); p++)
      {
         temp.add(library.get(p).getTitle());
      }
      return temp;
      // Complete the method to get all available movie titles.
   }

   /** Allows a customer to rent a movie. When the movie is rented, the number
    *  of available copies is reduced by 1. If there are 0 copies of the movie left
    *  after the transaction, the movie is removed from the list.
    *  @param title the title of the movie being rented.
    *  @return true if the movie was found and rented successfully, and false
    *  otherwise.
    */
   public boolean rent(String title)
   {
      // for loop to search
      for (int l = 0; l < library.size(); l++)
      {
         if (library.get(l).getTitle().equals(title));
         {
            // if movie is found decrease copies and remove if titles > 0
            library.get(l).decrementCopies();
            if (library.get(l).getNumCopies() == 0)
            {
               library.remove(searchForMovie(title));
            }
            return true;
         }
      }
      // return false if not possible

      return false;
      // Complete the method to rent a movie.
   }

   /** Allows a customer to return a movie. When the movie is returned, the number
    *  of available copies is increased by 1. If the movie was not already in the
    *  machine, then the DVD is added to the list.
    *  @param title the title of the movie being returned.
    *  @return the DVD that was returned by the customer.
    */
   public DVD returnMovie(String title)
   {
      // search for movie and if less than 0 then incrase movie by 1
      if (searchForMovie(title) >= 0)
      {
         library.get(searchForMovie(title)).incrementCopies();
      }
      else
      {
         // if not found before add new title
         library.add(new DVD(title));
      }
      return library.get(searchForMovie(title));
   }
   /** This method fills the machine with movies. You do not have
    *  to do anything to the code in this method.
    */
   private void fillMachine()
   {
      try{
         Scanner sn = new Scanner(new File("MovieList.txt"));
         while(sn.hasNextLine())
            returnMovie(sn.nextLine());

      }catch(FileNotFoundException e){
         String s = "File not found! Make sure that MovieList.txt ";
         s = s + "is in the same folder as the class.";
         System.out.println(s);
      }
   }
}
