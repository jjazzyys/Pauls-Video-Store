// build a linkedlist of customers

public class Customer_list {
  public CNode head;
  public int count;

  public Customer_list() {
    head = null;
    count = 0;
  }

  // add a customer
  public void add(CNode newy) {
    if (head == null) {
      head = newy;
      count++;
    } else {
      CNode current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newy;
      count++;
    }
  }

  // find customer name from phone number
  public String find(String search) {
    CNode current = head;
    while (current != null) {
      if (current.customer.phone.equals(search)) {
        return current.customer.firstName + " " + current.customer.lastName;
      }
      current = current.next;
    }
    return null;
  }

  // find customer name from phone number
  public CNode findFull(String search) {
    CNode current = head;
    while (current != null) {
      if (current.customer.phone.equals(search)) {
        return current;
      }
      current = current.next;
    }
    return null;
  }

  // print the list of customers
  public void print() {
    CNode current = head;
    while (current != null) {
      System.out.println(current.customer.print());
      current = current.next;
    }
  }

  // used for renting
  public void getIt(String phone, Video v) {
    CNode current = head;
    while (current != null) {
      if (current.customer.phone.equals(phone)) {
        current.customer.rentIt(v.barcode);
        v.rented = true;
        return;
      }
      current = current.next;
    }
    System.out.println("Customer not found");
  }

  // used for returning
  public void giveIt(String phone, Video v) {
    CNode current = head;
    while (current != null) {
      if (current.customer.phone.equals(phone)) {
        if (current.customer.getEmpty() < 3) {
          current.customer.returnIt(v.barcode);
        } else {
          System.out.println("You have no videos rented");
        }
        return;
      }
      current = current.next;
    }
    System.out.println("Customer not found");
  }

  // used for checking if any customer has the video
  public String check(String barcode) {
    CNode current = head;
    while (current != null) {
      if (current.customer.getEmpty() > 0) {
        if (current.customer.checkIt(barcode)) {
          System.out.println(
              "Customer " + current.customer.firstName + " " + current.customer.lastName + " has rented this video");
          return current.customer.firstName + " " + current.customer.lastName;
        }
      }
      current = current.next;
    }
    System.out.println("No customer has rented this video");
    return null;
  }

  // used for checking if a specific customer has the video
  public boolean checkReturn(String phone, String barcode) {
    CNode current = head;
    while (current != null) {
      if (current.customer.phone.equals(phone)) {
        return current.customer.checkIt(barcode);
      }
      current = current.next;
    }
    return false;
  }

}
