package service;

import entity.CLIENT_CATEGORY;
import entity.Client;
import repository.ClientRepository;

import java.util.Scanner;

public class ClientMenu implements IEntityMenu{

    private ClientRepository clientRepository;
    public ClientMenu(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public boolean RegisterNew(Scanner scanner) {
        System.out.println("Choose one of the categories bellow:");
        int categoryId;
        do{
            for(int i=0; i <CLIENT_CATEGORY.values().length; i++){
                System.out.printf("\t%d. %s\n", i, CLIENT_CATEGORY.values()[i]);
            }
            categoryId = scanner.nextInt();
        }while(categoryId < 0 | categoryId > CLIENT_CATEGORY.values().length);
        scanner.nextLine(); // Clear buffer
        System.out.println("Give me the document number:");
        String document = scanner.nextLine();
        System.out.println("Give me a name:");
        String name = scanner.nextLine();

        this.clientRepository.register(new Client(name, CLIENT_CATEGORY.values()[categoryId], document));
        System.out.println(this.clientRepository);
        return false;
    }

    @Override
    public boolean EditRegister(Scanner scanner) {
        return false;
    }

    @Override
    public void SearchRegister(Scanner scanner) {

    }
}
