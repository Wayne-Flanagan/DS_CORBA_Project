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
        ORB orb = ORB.init(args, null);

        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
        NamingContext rootCtx = NamingContextHelper.narrow(objRef);
        NameComponent nc = new NameComponent("Hello", "");
        NameComponent path[] = {nc};
        
        TVMaze tvmaze = TVMazeHelper.narrow(rootCtx.resolve(path));

        Client callback = new Client_Tie(new ClientImpl()) ;

        //Dynamic Invocation
        System.out.println("Retrieving Show info");
        int id = 1;
        Request getShowRequest = tvmaze._request("getShow");
        Any arg1_1 = getShowRequest.add_in_arg().insert_long(id);
        Any arg2_1 = getShowRequest.add_in_arg().insert_Object(callback);
        getShowRequest.set_return_type(orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
        getShowRequest.invoke();

        //Static Invocation
        //tvmaze.getShow(id, callback);

        //Dynamic Invocation
        System.out.println("Retrieving Show Episodes info");
        Request getEpisodesRequest = tvmaze._request("getShowEpisodeList");
        Any arg1_2 = getEpisodesRequest.add_in_arg().insert_long(id);
        Any arg2_2 = getEpisodesRequest.add_in_arg().insert_Object(callback);
        getEpisodesRequest.set_return_type(orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
        getEpisodesRequest.invoke();

        //Static Invocation
        //tvmaze.getShowEpisodeList(id, callback);

        //Dynamic Invocation
        System.out.println("Retrieving Show Seasons info");
        Request getSeasonsRequest = tvmaze._request("getShowSeasonsList");
        Any arg1_3 = getSeasonsRequest.add_in_arg().insert_long(id);
        Any arg2_3 = getSeasonsRequest.add_in_arg().insert_Object(callback);
        getSeasonsRequest.set_return_type(orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
        getSeasonsRequest.invoke();

        //Static Invocation
        //tvmaze.getShowSeasonsList(id, callback);

        //Dynamic Invocation
        System.out.println("Retrieving Show Cast info");
        Request getCastRequest = tvmaze._request("getShowCastList");
        Any arg1_4 = getCastRequest.add_in_arg().insert_long(id);
        Any arg2_4 = getCastRequest.add_in_arg().insert_Object(callback);
        getCastRequest.set_return_type(orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
        getCastRequest.invoke();

        //Static Invocation
        //tvmaze.getShowCastList(id, callback);

        //Dynamic Invocation
        System.out.println("Retrieving Show AKA info");
        Request getAKARequest = tvmaze._request("getShowAKAs");
        Any arg1_5 = getAKARequest.add_in_arg().insert_long(id);
        Any arg2_5 = getAKARequest.add_in_arg().insert_Object(callback);
        getAKARequest.set_return_type(orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
        getAKARequest.invoke();

        //Static Invocation
        //tvmaze.getShowAKAs(id, callback);

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

    public void displayShowAKAs(String info) {
        System.out.println("Message via callBack from server is " + info) ;
    }
}