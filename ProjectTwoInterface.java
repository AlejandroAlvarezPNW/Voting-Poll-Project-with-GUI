// A simple RMI interface file - M. Liu
import java.rmi.*;

/**
 * This is a remote interface.
 * @author M. L. Liu
 */

public interface ProjectTwoInterface extends Remote
{

   void incrementYes()
      throws java.rmi.RemoteException;
   /**
    *
    * This remote method increments the yesCount vote
    */

   void incrementNo()
      throws java.rmi.RemoteException;
   /**
    *
    * This remote method increments the noCount vote
    */

   void incrementDontCareCount()
      throws java.rmi.RemoteException;
   /**
    *
    * This remote method increments the yesCount vote
    */

/*get methods signatures*/
   int getYesCount()
      throws java.rmi.RemoteException;
   /**
    * This remote method returns the current total yesCounts.
    * @return a int value.
    */

   int getNoCount()
      throws java.rmi.RemoteException;
   /**
    * This remote method returns the current total noCounts.
    * @return a int value.
    */
   int getDontCareCount()
      throws java.rmi.RemoteException;


} //end interface

