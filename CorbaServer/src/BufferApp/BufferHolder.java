package BufferApp;

/**
* BufferApp/BufferHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./Buffer.idl
* martes 2 de mayo de 2023 12H54' CEST
*/

public final class BufferHolder implements org.omg.CORBA.portable.Streamable
{
  public BufferApp.Buffer value = null;

  public BufferHolder ()
  {
  }

  public BufferHolder (BufferApp.Buffer initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = BufferApp.BufferHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    BufferApp.BufferHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return BufferApp.BufferHelper.type ();
  }

}
