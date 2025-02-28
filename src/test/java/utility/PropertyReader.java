package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * // TODO Comment
 */
public class PropertyReader {

  public static Properties prop;

  public PropertyReader(String filePath) {
    prop = new Properties();
    InputStream input = null;

    try {
      //System.out.println("Working Directory = " + System.getProperty("user.dir"));
      String filename = System.getProperty("user.dir") + filePath;
      prop.load(new FileInputStream(filename.trim()));

    } catch (IOException ex) {
      ex.printStackTrace();
    } finally {
      if (input != null) {
        try {
          input.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }


  public void printThemAll(){

    try {
      Enumeration<?> e = prop.propertyNames();
      while (e.hasMoreElements()) {
        String key = (String) e.nextElement();
        String value = prop.getProperty(key);
        System.out.println("Key : " + key + ", Value : " + value);
      }

    } catch (Exception ex) {
          ex.printStackTrace();
    }


  }
  public String get(String key){
    String env=prop.getProperty("env");

    if(key.trim().equalsIgnoreCase("ENV"))
      return env;
    else
      return prop.getProperty(env+"."+key);

  }

/*  public static void main (String[]args){
    PropertyReader pReader = new PropertyReader("/resources/config-files/merchandising-config.properties");
    pReader.printThemAll();
    //System.out.println(pReader.prop.get("share-stage.url"));
    System.out.println(pReader.get("merch-test.s3url"));
  }*/

}
