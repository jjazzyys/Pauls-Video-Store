// create customer for a linked list

public class Customer {
  public String firstName;
  public String lastName;
  public String phone;
  public String[] rentedVideos;

  public Customer(final String firstName, final String lastName, final String phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
    this.rentedVideos = new String[3];
    this.rentedVideos[0] = "";
    this.rentedVideos[1] = "";
    this.rentedVideos[2] = "";
  }

  public String print() {
    return "Customer: " + firstName + " " + lastName + " " + phone;
  }

  // count how many empty spaces there are
  public int getEmpty() {
    int count = 0;
    for (int i = 0; i < rentedVideos.length; i++) {
      if (rentedVideos[i].equals("")) {
        count++;
      }
    }
    return count;
  }

  // used in customer_list to rent the video
  public void rentIt(final String barcode) {
    if (getEmpty() <= 3) {
      for (int i = 0; i < rentedVideos.length; i++) {
        if (rentedVideos[i].equals("")) {
          rentedVideos[i] = barcode;
          return;
        }
      }
    } else {
      System.out.println("You already rented 3 videos");
    }
  }

  // used in customer_list to return the video
  public void returnIt(final String barcode) {
    int i = 0;
    while (i < rentedVideos.length) {
      if (rentedVideos[i].equals(barcode)) {
        rentedVideos[i] = "";
        return;
      }
      i++;
    }
  }

  // used in customer_list to check if the customer has rented the video
  public boolean checkIt(final String barcode) {
    int i = 0;
    while (i < rentedVideos.length) {
      if (rentedVideos[i].equals(barcode)) {
        return true;
      }
      i++;
    }
    return false;
  }

}