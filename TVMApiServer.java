import java.io.*;
import org.omg.CORBA.*;
import APIConnection.*;
import org.omg.CosNaming.* ;
import org.omg.CosNaming.NamingContextPackage.*;

public class TVMApiServer {

	public static void main (String args[]) {
		try{

			// create and initialize the ORB
	   		ORB orb = ORB.init(args, null);
	   		//Instantiating the Servant
			TVMaze helloRef = new TVMaze_Tie(new TVMApiServant());
			orb.connect(helloRef);

			//Getting the object reference to the Name Service held in the ORB
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			//Narrowing the object reference to point to the root of the name service
			NamingContext rootCtx = NamingContextHelper.narrow(objRef);
			//Creating a new name component that contains the object reference to the instantiated servant
			NameComponent nc = new NameComponent("Hello", "");
			NameComponent path[] = {nc};
			//Binding the name to an object that is stored in the Name Service
			rootCtx.rebind(path, helloRef);

			//Print a message to notify that the server is running
			System.out.println("Server has been started ...");

			// wait for invocations from clients
			orb.run();

		} catch (Exception e) {
			System.err.println("Error: "+e);
			e.printStackTrace(System.out);
		}

	}
}