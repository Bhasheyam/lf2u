package LF2UService;

import java.io.InputStream;

public interface Managersupport {

   public String getmlist();
   public String getmanager(int mid);
   public String getreplist();
public String getreportt1(String s, String s1);
public String getreportt2(String s, String s1, String st1, String st2);
public String getreportt3(String s, String s1, String st1, String st2);
public String addcat(StringBuilder out1);
public String getcatlist();
public boolean update(String s, StringBuilder b);
}
