package tads;

import models.Node;
import models.Soldier;

public class CircularList {
  Node head;
  Node tail;
  public CircularList(){
    head = null;
    tail = null;
  }

  public void insert(Soldier soldier) {
    Node newNode = new Node(soldier, null);
    if (head == null) {
      newNode.next = newNode;
    } else {
      tail.next = newNode;
      newNode.next = head;
    }
    tail = newNode;
  }

  public void deleteByNRounds(int nRounds){


    int totalElements = getTotalElements();
    int lastSoldierPosition = 0;
    Node movil= head;
    while(totalElements != 1 ){
      for(int i = 0; i < nRounds; i++){
          movil = movil.next;
      }
      Node toDelete = movil;
      deleteByName(toDelete.soldier.name);
      movil = movil.next;

      totalElements = getTotalElements();
    }
  }

  public Node getByPosition(int position){
    Node aux = head;
    int count = 1;
    boolean end = false;
    while(!end){
      if(count == position){
        return aux;
      }
      if(aux == tail){
        end = true;
      }
      count++;
      aux = aux.next;
    }
    return null;
  }

  public void deleteByName(String soldierName){

    Node movil = head;
    int count = 1;
    boolean end = false;
    while(!end){
      if(movil.next.soldier.name.equals(soldierName)){
        Node toDelete = movil.next;
        System.out.println("deleting " + toDelete.next.soldier.name);
        if(toDelete == tail){
          movil.next = head;
          tail = movil;
        }else{
          movil.next = toDelete.next;
          movil = null;
        }
        break;
      }
      if(movil == tail){
        end = true;
      }
      count++;
      movil = movil.next;
    }
  }

  public int getTotalElements(){
    boolean end = false;
    Node movil = head;
    int count=0;
    while(!end){
      if(movil == tail ){
        end=true;
      }
      count++;
    }
    return count;
  }
  public void deleteNode(Node node){

  }
}
