import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PictureFrame extends JFrame {
    //private PicturePanel mainPanel;
    private JTextField num;
    private JTextArea picdes;
    ArrayList <PictureData> picdata = PictureDataReader.readPictureDataFromFile("descriptions.txt");
    //PictureData element = picdata.get(1);
    ArrayList <BufferedImage> BI = PictureLoader.BI(picdata);
    int currentIndex = 0;
    private PicturePanel panNorth;
    PictureData datadata = picdata.get(currentIndex);

//went to see Xavier in tutoring and he helped me with the following functions
    public void saveData(String num, String picdes){
        picdata.get(currentIndex).setNum(num);
        picdata.get(currentIndex).setPicdes(picdes);
        PictureDataWriter.writeToFile(picdata,"descriptions.txt");
    }


    public void setPicData(int currentIndex){
        panNorth.setPicture(BI.get(currentIndex));
        setInfo(currentIndex);
    }

    public void setInfo(int currentIndex){
        PictureData datadata = picdata.get(currentIndex);
        num.setText(datadata.getNum());
        picdes.setText(datadata.getPicdes());

    }
    public void setupMenu() {
        //System.out.println()
        setTitle("Picture Frame");
        JMenuBar mbar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
        JMenuItem miSave = new JMenuItem("Save");
        miSave.addActionListener(new ActionListener () {
                public void actionPerformed(ActionEvent e) {
                    saveData(num.getText(), picdes.getText());
                   // miSave.addActionListener(this);
                    //savePicAndDes();
                }
            });
        JMenuItem miExit = new JMenuItem("Exit");
        miExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mnuFile.add(miSave);
        mnuFile.add(miExit);
        mbar.add(mnuFile);

        JMenu mnuHelp = new JMenu("Help");
        JMenuItem miAbout = new JMenuItem("About");
        miAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Created by Sarah Breslin December 3, 2021");
            
            }
        });
        mnuHelp.add((miAbout));
        mbar.add(mnuHelp);
        setJMenuBar(mbar);
    } //mainly followed Klump's Dots notes for the menu and how to make it look good essentially
    public void setupLook() {
        setupMenu();
        setBounds(100,100,290,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setupMenu();
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());
        JButton prev = new JButton("Prev");
        panSouth.add(prev); //bre and outside source "Jake Filotto" 
        //helped me fix my buttons with a lot of trial and error!..as you can see
        prev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentIndex <= 0){
                    currentIndex = 3;
                    //System.out.println(currentIndex);
                    setPicData(currentIndex);
                } else {
                    currentIndex = currentIndex -1;
                    //System.out.println(currentIndex);
                    setPicData(currentIndex);
                    }
                }
            });
        JButton save = new JButton("Save");
        panSouth.add(save);
            save.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    saveData(num.getText(), picdes.getText());
                   // save.addActionListener(this);
                }
            });
        JButton next = new JButton("Next");
            panSouth.add(next);
            next.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (currentIndex >= 3){
                        currentIndex = 0;
                        //System.out.println(currentIndex);
                        setPicData(currentIndex);
                    }else {
                        currentIndex = currentIndex + 1;
                        //System.out.println(currentIndex);
                        setPicData(currentIndex);
                    }
                }
            });
            panNorth = new PicturePanel();
            c.add(panNorth,BorderLayout.NORTH);
            c.add(mainPanel,BorderLayout.CENTER);
            //PictureData test = picdata.get(num);
            num = new JTextField(20);
            picdes = new JTextArea(1,1);
            picdes.setLineWrap(true);
            mainPanel.add(num, BorderLayout.NORTH);
            mainPanel.add(picdes, BorderLayout.CENTER);
            mainPanel.add(panSouth, BorderLayout.SOUTH);
        
        }
//more trial and error shown here

    /*public void changepic(int numb) {
        num = num + numb;
        if (num < 0) {
            num = BI.size() - 1;
        } else {
            num = num % BI.size();
        }
     }*/ 
    
    public PictureFrame () {
        //this.picdata = picdata;
        //this.BI = BI;
        //num = 0;
        //setupPicDisplay();
        setupLook();
        setPicData(currentIndex);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);;
    }
  
}


