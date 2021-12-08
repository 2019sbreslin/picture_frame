
// where that data from the text file are read into the program
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class PictureDataReader {

        public static ArrayList<PictureData> readPictureDataFromFile(String fileName){      
        try {   
            ArrayList<PictureData> pd = new ArrayList<PictureData>(); 
            Scanner fsc = new Scanner(new File(fileName)); 
            String pic;
            String num;
            String picdes;
            String line;
            String[] parts;
            PictureData picData; //object
            while (fsc.hasNextLine()) {
                line = fsc.nextLine().trim();
                if (line.length()>0) {
                    parts = line.split("\t"); //splitting the textfile so each category is filled
                    pic = parts[0];
                    num = parts[1];
                    picdes = parts[2];
                    picData = new PictureData(pic, num, picdes);
                    pd.add(picData);
                }
            } return pd;
        } catch (Exception ex) {
            //ex.printStackTrace();     
            return null;
        }
    }
}
