package service;

import java.util.Scanner;

public interface IEntityMenu {

    boolean RegisterNew(Scanner scanner);
    boolean EditRegister(Scanner scanner);
    void SearchRegister(Scanner scanner);

}
