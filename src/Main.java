import models.Soldier;
import tads.CircularList;

import java.util.Scanner;

public class Main {
  public static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    CircularList circularList = new CircularList();

    System.out.println("Ingrese el  número de soldados");
    int nSoldiers = sc.nextInt();
    addSoldiers(circularList, nSoldiers);


  }

  public static void addSoldiers(CircularList circularList, int nSoldiers){
    for(int i = 0; i < nSoldiers; i++){
      System.out.println("Ingrese el nombre del soldado " + i+1);
      String soldierName = sc.next();
      circularList.insert(new Soldier(soldierName));
    }
  }
}