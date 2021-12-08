import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

//taken and elaborated from Klump's notes
public class PictureDataWriter {

    public static boolean writeToFile(ArrayList<PictureData> picdata, String fileName){
         if (fileName.endsWith(".txt")){
             return writeToTextFile(picdata,fileName);
            } else {
                return false;
            }
        }
//again, Jake taught me how to change the textfile if the user decides to edit anything
    public static boolean writeToTextFile (ArrayList<PictureData> picdata, String fileName){
    try {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        for (PictureData picdat: picdata) {
            pw.printf("%s\t%s\t%s\n",picdat.getPic(), picdat.getNum(), picdat.getPicdes());
            
        }
        pw.close();
        return true;
    } catch(Exception ex){
        return false;
        }
    }
}