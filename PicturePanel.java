
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

//for some reason my mouse only moves if you double click it and I'm not sure why

public class PicturePanel extends JPanel implements MouseListener, MouseMotionListener{
    private ArrayList<PictureData> picdata;
    private String mouseStatus;
    private int mouseX; 
    private int mouseY;
    private BufferedImage picture;


    public PicturePanel(){
        setPreferredSize(new Dimension(200,200));
        mouseStatus = "(x=0, y=0)";
        addMouseListener(this);
        addMouseMotionListener(this);
        mouseX = 1;
        mouseY = 1;
        picdata = new ArrayList<PictureData>();
    }

    public void setPicture(BufferedImage picture){
        this.picture = picture;
        repaint();
     }

    public void mouseClicked(MouseEvent e){
        mouseStatus = String.format("(x=%d, y=%d)", e.getX(), e.getY());
        mouseX = e.getX();
        mouseY = e.getY();
        repaint();
    }
    //I tried to follow the Dot notes but for some reason that wasn't working
    //with my mouses and then Bre told me to just tell them all not to do anything and it seemed to work
    public void mousePressed(MouseEvent e){
    }

    public void mouseReleased(MouseEvent e){
    }

    public void mouseEntered(MouseEvent e){
    }

    public void mouseExited(MouseEvent e){
    }

    public void mouseMoved(MouseEvent e){
    }

    public void mouseDragged(MouseEvent e){
    }

    public ArrayList<PictureData> getPicdata() {
        return picdata;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(picture,0,0,null);
        g.drawString(mouseStatus,mouseX,mouseY);
    }
    
}
