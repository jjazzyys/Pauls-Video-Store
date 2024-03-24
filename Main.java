import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    // create linked list
    Customer_list customer_list = new Customer_list();
    Video_list video_list = new Video_list();
    Scanner scan = new Scanner(System.in);

    // ignore this we're vibing for testing purposes
    Customer c1 = new Customer("John", "Doe", "5517956838");
    Customer c2 = new Customer("Jane", "Smith", "2018422834");
    customer_list.add(new CNode(c1));
    customer_list.add(new CNode(c2));
    Video v1 = new Video("Fast & Furious", "111111111111");
    video_list.add(new VNode(v1));
    Video v2 = new Video("The Matrix", "222222222222");
    video_list.add(new VNode(v2));
    Video v3 = new Video("The Barbie Movie", "333333333333");
    video_list.add(new VNode(v3));
    Video v4 = new Video("Harry Potter", "444444444444");
    video_list.add(new VNode(v4));

    System.out.println("Howdy! Welcome to Paul's Video Store!");
    System.out.println();
    System.out.println("Please pick an option:");
    System.out.println("addCustomer");
    System.out.println("addVideo");
    System.out.println("rentVideo");
    System.out.println("returnVideo");
    System.out.println("checkVideo");
    System.out.println("quit");
    System.out.println();
    String option = "";

    // create a menu for the work to interact with!
    while (!option.equals("quit")) {
      option = scan.nextLine();

      // add a customer to the linked list!
      if (option.equals("addCustomer")) {
        System.out.println("Please enter customer's first name: ");
        String firstName = scan.nextLine();
        System.out.println("Please enter customer's last name: ");
        String lastName = scan.nextLine();
        System.out.println("Please enter customer's phone number: ");
        System.out.println("Preferably in the format ########## but I won't tell ;D");
        String phone = scan.nextLine();
        Customer customer = new Customer(firstName, lastName, phone);
        customer_list.add(new CNode(customer));
        System.out.println("You're registered!");
      }

      // add a video to the linked list!
      else if (option.equals("addVideo")) {
        System.out.println("Please enter video's name: ");
        String name = scan.nextLine();
        System.out.println("Please enter video's barcode: ");
        System.out.println("Preferably 12 digits but it is what it is");
        String barcode = scan.nextLine();
        Video video = new Video(name, barcode);
        video_list.add(new VNode(video));
        System.out.println("New Video added!");
      }

      // rent a video --> add its barcode to the customer's rented array
      else if (option.equals("rentVideo")) {
        System.out.println("Please enter customer's phone number: ");
        String phone = scan.nextLine();

        CNode customerNode = customer_list.findFull(phone);

        if (customerNode == null) {
          System.out.println("Customer not found");
        } else {
          System.out.println("Please enter video's barcode: ");
          String barcode = scan.nextLine();
          Video v = video_list.find(barcode);

          if (v == null) {
            System.out.println("Video not found");
          } else {
            if (!v.rented) {
              if (customerNode.customer.getEmpty() == 3) {
                customerNode.customer.rentIt(barcode);
                v.rented = true;
                System.out.println("Video: " + v.name + " rented");
              } else if (customerNode.customer.getEmpty() == 2) {
                customerNode.customer.rentIt(barcode);
                v.rented = true;
                System.out.println("Video: " + v.name + " rented");
              } else if (customerNode.customer.getEmpty() == 1) {
                customerNode.customer.rentIt(barcode);
                v.rented = true;
                System.out.println("Video: " + v.name + " rented");
              } else {
                System.out.println("You already rented 3 videos");
              }
            } else {
              System.out.println("That one is rented right now");
            }
          }
        }
      }

      // return a video
      // if you're seeing this please go to sleep
      else if (option.equals("returnVideo")) {
        System.out.println("Please enter customer's phone number: ");
        String phone = scan.nextLine();

        CNode customerNode = customer_list.findFull(phone);

        if (customerNode == null) {
          System.out.println("Customer not found");
        } else {
          System.out.println("Please enter video's barcode: ");
          String barcode = scan.nextLine();

          Video v = video_list.find(barcode);

          if (v == null) {
            System.out.println("Video not found");
          } else {
            if (customer_list.checkReturn(phone, barcode)) {
              customer_list.giveIt(phone, v);
              v.rented = false;
              System.out.println("Video: " + v.name + " returned");
            } else {
              System.out.println(
                  customerNode.customer.firstName + " " + customerNode.customer.lastName + " did not rent this video");
            }
          }
        }
      }

      // look to see if a video is rented.
      else if (option.equals("checkVideo")) {
        System.out.println("Please enter video's barcode: ");
        String barcode = scan.nextLine();
        Video v = video_list.find(barcode);
        if (v == null) {
          System.out.println("Video not found");
        } else {
          if (v.rented == true) {
            customer_list.check(barcode);
          } else {
            System.out.println("That one is not rented");
          }
        }
      }

      else {
        if (!option.equals("quit")) {
          System.out.println("Command Invalid");
        }
      }

    }
  }
}
