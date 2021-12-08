//main application where I run my code
public class App {
    public static void main(String[] args) {
       /*/ if (pd == null || pd.size() == 0) {
            System.out.println("you're a dipshit");
        } else {
            System.out.println("hey you're not a dipshit");
            if (bufim == null || bufim.size() == 0) {
                System.out.println("you're a dipshit2");
            } else {
                System.out.println("hey you're not a dipshit2");
                PictureFrame frm = new PictureFrame(pd, bufim);
                frm.setVisible(true);
            }
        } 
        */
        PictureFrame frm = new PictureFrame();
        frm.setVisible(true);
    }
}
