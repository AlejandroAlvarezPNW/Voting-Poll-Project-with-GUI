import java.rmi.*;
import java.rmi.server.*;

/**
 * This class implements the remote interface
 *    ProjectTwoInterface.
 * @author M. L. Liu
 */

public class ProjectTwoImpl extends UnicastRemoteObject
     implements ProjectTwoInterface {

   public ProjectTwoImpl() throws RemoteException
   {
      super( );
   }

   public void incrementYes()
      throws java.rmi.RemoteException
   {
      ProjectTwoServer.yesCount++;
   }

   public void incrementNo()
      throws java.rmi.RemoteException
   {
      ProjectTwoServer.noCount++;
   }

   public void incrementDontCareCount()
      throws java.rmi.RemoteException
   {
      ProjectTwoServer.dontCareCount++;
   }

   /*Test Fucntion*/ public String sayHello(String name)
      throws java.rmi.RemoteException
      {
return "Hello, World!" + name;
}

   //get methods impl's [FIX THIS WORDING]

   public int getYesCount()
      throws java.rmi.RemoteException
   {
      return ProjectTwoServer.yesCount;
   }

   public int getNoCount()
      throws java.rmi.RemoteException
   {
      return ProjectTwoServer.noCount;
   }

   public int getDontCareCount()
      throws java.rmi.RemoteException
   {
      return ProjectTwoServer.dontCareCount;
   }

} // end class
