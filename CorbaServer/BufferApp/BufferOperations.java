package BufferApp;


/**
* BufferApp/BufferOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./Buffer.idl
* martes 2 de mayo de 2023 12H58' CEST
*/

public interface BufferOperations 
{
  int num_elementos ();
  boolean put (String elemento);
  boolean get (org.omg.CORBA.StringHolder elemento);
  boolean read (org.omg.CORBA.StringHolder elemento);
  boolean readAll (org.omg.CORBA.StringHolder elemento);
  void shutdown ();
} // interface BufferOperations
