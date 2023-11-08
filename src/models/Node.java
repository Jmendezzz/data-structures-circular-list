package models;

public class Node {
  public Soldier soldier;
  public Node next;

  public Node(Soldier soldier, Node next) {
    this.soldier = soldier;
    this.next = next;
  }
}
