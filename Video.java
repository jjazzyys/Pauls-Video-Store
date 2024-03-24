public class Video {
  public String name;
  public String barcode;
  public boolean rented;

  public Video(String name, String barcode) {
    this.name = name;
    this.barcode = barcode;
    this.rented = false;
  }

  public String print() {
    return "Video: " + name + " " + barcode;
  }
}