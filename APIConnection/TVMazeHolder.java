package APIConnection;

/**
* APIConnection/TVMazeHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from API.idl
* 03 April 2016 19:45:53 o'clock IST
*/

public final class TVMazeHolder implements org.omg.CORBA.portable.Streamable
{
  public APIConnection.TVMaze value = null;

  public TVMazeHolder ()
  {
  }

  public TVMazeHolder (APIConnection.TVMaze initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = APIConnection.TVMazeHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    APIConnection.TVMazeHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return APIConnection.TVMazeHelper.type ();
  }

}
