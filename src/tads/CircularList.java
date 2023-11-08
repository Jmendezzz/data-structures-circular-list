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
      head = newNode;
      newNode.next = newNode;
    } else {
      tail.next = newNode;
      newNode.next = head;
    }
    tail = newNode;
  }

  public void deleteByNRounds(int nRounds){
    int totalElements = getTotalElements();
    Node movil = head;
    while(totalElements != 1 ){
      for(int i = 1; i < nRounds; i++){
          movil = movil.next;
      }
      Node toDelete = movil;
      deleteByName(toDelete.soldier.name);
      movil = movil.next;
      totalElements = getTotalElements();
    }
    System.out.println("El soldado ganador es: " + head.soldier.name);
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
        System.out.println("Eliminando al soldado: " + toDelete.soldier.name);
        if(toDelete == tail){
          movil.next = head;
          tail = movil;
          toDelete = null;
        }else if(toDelete == head){
          head = head.next;
          tail.next = head;
          toDelete = null;
        }
        else{
          movil.next = toDelete.next;
          toDelete = null;
        }
        break;
      }
      if(movil == tail){
        end = true;
      }
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
      movil = movil.next;
    }
    return count;
  }
  public void printList(){
    Node aux = head;
    boolean end = false;
    while(!end){
      System.out.println(aux.soldier.name);
      if(aux == tail){
        end = true;
      }
      aux = aux.next;
    }
  }
}
