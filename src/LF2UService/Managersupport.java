package LF2UService;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface Managersupport {

   public String getmlist();
   public String getmanager(int mid);
   public String getreplist();
public String getreportt1( int s1,String st1, String st2);
public String getreportt2( int s1, String st1, String st2);
public String getreportt3( int s1, String st1, String st2);
public String addcat(StringBuilder out1);
public String getcatlist();
public boolean update(String s, StringBuilder b) throws JsonParseException, JsonMappingException, IOException;

}
