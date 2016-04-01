import APIConnection.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

class TVMApiServant implements TVMazeOperations
{
   	public void getShow(int id, Client callback){
   		try {
   		    String json = sendGet("http://api.tvmaze.com/shows/" + id);
		    callback.displayShowInfo(json);	
   		} catch (Exception e){
   		    //e.printStacktrace();
   		}

   	}

   	public void getShowEpisodeList(int id, Client callback){
   		try {
   		    String json = sendGet("http://api.tvmaze.com/shows/" + id + "/episodes");
		    callback.displayShowEpisodes(json);	
   		} catch (Exception e){
   		    //e.printStacktrace();
   		}

   	}

   	public void getShowSeasonsList(int id, Client callback){
   		try {
   		    String json = sendGet("http://api.tvmaze.com/shows/" + id + "/seasons");
		    callback.displayShowSeasons(json);	
   		} catch (Exception e){
   		    //e.printStacktrace();
   		}

   	}

   	public void getShowCastList(int id, Client callback){
   		try {
   		    String json = sendGet("http://api.tvmaze.com/shows/" + id + "/cast");
		    callback.displayShowCast(json);	
   		} catch (Exception e){
   		    //e.printStacktrace();
   		}

   	}

   	public void getShowAKAs(int id, Client callback){
   		try {
   		    String json = sendGet("http://api.tvmaze.com/shows/" + id + "/akas");
		    callback.displayShowAKAs(json);	
   		} catch (Exception e){
   		    //e.printStacktrace();
   		}

   	}


	private String sendGet(String url) throws Exception {

		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

		conn.setRequestMethod("GET");

		int responseCode = conn.getResponseCode();

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

        return response.toString();
	}
}