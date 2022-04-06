import java.io.FileNotFoundException;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-04-06
 * Time:9:54
 */
public class Text7 {
    public void OpenConfig(String filename)throws FileNotFoundException{
        if(filename.equals("config.ini")){
            throw new FileNotFoundException("file name exception");
        }
    }


}
