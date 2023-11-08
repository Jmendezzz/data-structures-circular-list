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
    System.out.println("Ingrese el número de saltos para escoger el soldado ganador");
    int nRounds = sc.nextInt();
    circularList.deleteByNRounds(nRounds);
  }

  public static void addSoldiers(CircularList circularList, int nSoldiers){
    for(int i = 1; i <= nSoldiers; i++){
      System.out.println("Ingrese el nombre del soldado " + i);
      String soldierName = sc.next();
      circularList.insert(new Soldier(soldierName));
    }
  }
}