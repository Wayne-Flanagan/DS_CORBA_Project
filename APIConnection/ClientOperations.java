package APIConnection;


/**
* APIConnection/ClientOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from API.idl
* 03 April 2016 19:45:53 o'clock IST
*/

public interface ClientOperations 
{
  void displayShowInfo (String showJsonResponse);
  void displayShowEpisodes (String episodesJsonResponse);
  void displayShowSeasons (String seasonsJsonResponse);
  void displayShowCast (String castJsonResponse);
  void displayShowEpisodesByNum (String epByNumJsonResponse);
} // interface ClientOperations
