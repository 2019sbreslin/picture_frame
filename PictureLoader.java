import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.io.File;
public class PictureLoader { //DO NOT TOUCH---written by Xavior because he gets mad at me when he helps and I screw it up
    public static ArrayList<BufferedImage> BI(ArrayList<PictureData> pData) {
        try {
            ArrayList<BufferedImage> bufim = new ArrayList<BufferedImage>();
            String line;
            String parts [];
            for (PictureData pd: pData) {
                BufferedImage img = ImageIO.read(new File(pd.getPic()));
                bufim.add(img);
            }
            return bufim;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    }


