// build a linkedlist of videos
public class Video_list {
  public VNode head;
  public int count;

  public Video_list() {
    head = null;
    count = 0;
  }

  // add a video
  public void add(VNode newy) {
    if (head == null) {
      head = newy;
      count++;
    } else {
      VNode current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newy;
      count++;
    }
  }

  // find a video by the barcode
  public Video find(String search) {
    VNode current = head;
    while (current != null) {
      if (current.video.barcode.equals(search)) {
        return current.video;
      }
      current = current.next;
    }
    return null;
  }

  // print the list of videos
  public void print() {
    VNode current = head;
    while (current != null) {
      System.out.println(current.video.print());
      current = current.next;
    }
  }

}