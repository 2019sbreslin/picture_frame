
//where my getters and setters are made

public class PictureData {
    private String pic;
    private String num;
    private String picdes;

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPicdes() {
        return picdes;
    }

    public void setPicdes(String picdes) {
        this.picdes = picdes;
    }

    public PictureData(String pic, String num, String picdes) { //constructor
        this.pic = pic;
        this.num = num;
        this.picdes = picdes;
    }
    @Override
    public String toString(){  //my toString function that Klump told us to do
        return String.format("%d %d %d", pic, num, picdes); 
    }
}

    //public PictureData(int x, int y, int pointSize) {
    //}

   // public static String getNum(String num) {
    //    return null;
   // }
   
