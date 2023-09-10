import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.net.*;
import java.io.*;

/**
 * This class represents the object server for a distributed
 * object of class Hello, which implements the remote interface
 * HelloInterface.
 * @author M. L. Liu
 */

public class ProjectTwoServer
{
   static int yesCount = 0;
   static int noCount = 0;
   static int dontCareCount = 0;
   public static void main(String[] args)
   {
      InputStreamReader is = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(is);
      String portNum;
      String registryURL;
      try
      {
         System.out.println("Enter the RMIregistry port number:");
         portNum = (br.readLine()).trim();
         int RMIPortNum = Integer.parseInt(portNum);
         startRegistry(RMIPortNum);
         ProjectTwoImpl exportedObj = new ProjectTwoImpl();
         registryURL = "rmi://localhost:" + portNum + "/hello";
         Naming.rebind(registryURL, exportedObj);
/**/     System.out.println
/**/        ("Server registered.  Registry currently contains:");
/**/     // list names currently in the registry
/**/     listRegistry(registryURL);
         System.out.println("Voting Server ready.");
      }// end try
      catch (Exception re)
      {
         System.out.println("Exception in ProjectTwoServer.main: " + re);
      } // end catch
  } // end main

   // This method starts a RMI registry on the local host, if it
   // does not already exists at the specified port number.
   private static void startRegistry(int RMIPortNum)
      throws RemoteException{
      try
      {
         Registry registry = LocateRegistry.getRegistry(RMIPortNum);
         registry.list( );  // This call will throw an exception
                            // if the registry does not already exist
      }
      catch (RemoteException e)
      {
         // No valid registry at that port.
/**/     System.out.println
/**/        ("RMI registry cannot be located at port "
/**/        + RMIPortNum);
            LocateRegistry.createRegistry(RMIPortNum);
/**/        System.out.println(
/**/           "RMI registry created at port " + RMIPortNum);
      }
   } // end startRegistry

  // This method lists the names registered with a Registry object
  private static void listRegistry(String registryURL)
     throws RemoteException, MalformedURLException
     {
       System.out.println("Registry " + registryURL + " contains: ");
       String [ ] names = Naming.list(registryURL);
         for (String name : names) System.out.println(name);
      } //end listRegistry

} // end class
