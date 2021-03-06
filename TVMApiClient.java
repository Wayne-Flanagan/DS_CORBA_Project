import java.io.*;
import java.lang.*;
import org.omg.CORBA.*;
import APIConnection.*;
import org.omg.CosNaming.* ;
import org.omg.CosNaming.NamingContextPackage.*;

import java.net.*;

public class TVMApiClient
{
    public static void main(String args[])
    {
    try{
        // create and initialize the ORB
        ORB orb = ORB.init(args, null);

        //Obtaining the object reference to the Name Service
        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
        //Narrowing the object reference of the Name Service to the correct Type
        NamingContext rootCtx = NamingContextHelper.narrow(objRef);
        //Creating a name of the desired object that we want to get the object reference of, from the name server
        NameComponent nc = new NameComponent("Hello", "");
        NameComponent path[] = {nc};
        
        //Instantiate an instance of the TVMaze interface for accessing its methods
        TVMaze tvmaze = TVMazeHelper.narrow(rootCtx.resolve(path));

        //Instantiate an instance of the Client class for accessing its  callback methods
        Client callback = new Client_Tie(new ClientImpl()) ;

        //5 methods to retrieve data from the server after it has requested it from the TVMaze API

        //Dynamic Invocation
        System.out.println("Retrieving Show info");
        int id = 1;
        Request getShowRequest = tvmaze._request("getShow");
        Any arg1_1 = getShowRequest.add_in_arg();
        Any arg2_1 = getShowRequest.add_in_arg();
        arg1_1.insert_long(id);
        arg2_1.insert_Object(callback);
        getShowRequest.set_return_type(orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
        getShowRequest.invoke();

        //Static Invocation
        //tvmaze.getShow(id, callback);

        //Dynamic Invocation
        System.out.println("Retrieving Show Episodes info");
        Request getEpisodesRequest = tvmaze._request("getShowEpisodeList");
        Any arg1_2 = getEpisodesRequest.add_in_arg();
        Any arg2_2 = getEpisodesRequest.add_in_arg();
        arg1_2.insert_long(id);
        arg2_2.insert_Object(callback);
        getEpisodesRequest.set_return_type(orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
        getEpisodesRequest.invoke();

        //Static Invocation
        //tvmaze.getShowEpisodeList(id, callback);

        //Dynamic Invocation
        System.out.println("Retrieving Show Seasons info");
        Request getSeasonsRequest = tvmaze._request("getShowSeasonsList");
        Any arg1_3 = getSeasonsRequest.add_in_arg();
        Any arg2_3 = getSeasonsRequest.add_in_arg();
        arg1_3.insert_long(id);
        arg2_3.insert_Object(callback);
        getSeasonsRequest.set_return_type(orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
        getSeasonsRequest.invoke();

        //Static Invocation
        //tvmaze.getShowSeasonsList(id, callback);

        //Dynamic Invocation
        System.out.println("Retrieving Show Cast info");
        Request getCastRequest = tvmaze._request("getShowCastList");
        Any arg1_4 = getCastRequest.add_in_arg();
        Any arg2_4 = getCastRequest.add_in_arg();
        arg1_4.insert_long(id);
        arg2_4.insert_Object(callback);
        getCastRequest.set_return_type(orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
        getCastRequest.invoke();

        //Static Invocation
        //tvmaze.getShowCastList(id, callback);

        //Dynamic Invocation
        System.out.println("Retrieving Episode by number info");
        Request getEpByNumRequest = tvmaze._request("getShowEpisodesByNum");
        Any arg1_5 = getEpByNumRequest.add_in_arg();
        Any arg2_5 = getEpByNumRequest.add_in_arg();
        Any arg3_5 = getEpByNumRequest.add_in_arg();
        Any arg4_5 = getEpByNumRequest.add_in_arg();
        arg1_5.insert_long(id);
        arg2_5.insert_long(id);
        arg3_5.insert_long(id);
        arg4_5.insert_Object(callback);
        getEpByNumRequest.set_return_type(orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
        getEpByNumRequest.invoke();

        //Static Invocation
        //tvmaze.getEpisodesByNum(id, callback);

    } catch (Exception e) {
           e.printStackTrace();
    }
}
}

class ClientImpl implements ClientOperations {
    
    public void displayShowInfo(String info) {
        System.out.println("Message via callBack from server is " + info) ;
    }

    public void displayShowEpisodes(String info) {
        System.out.println("Message via callBack from server is " + info) ;
    }
    
    public void displayShowSeasons(String info) {
        System.out.println("Message via callBack from server is " + info) ;
    }

    public void displayShowCast(String info) {
        System.out.println("Message via callBack from server is " + info) ;
    }

    public void displayShowEpisodesByNum(String info) {
        System.out.println("Message via callBack from server is " + info) ;
    }
}