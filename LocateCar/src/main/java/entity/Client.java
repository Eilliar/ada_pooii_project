package entity;

enum CLIENT_CATEGORY {
    PF,
    PJ
}

public class Client {

    int id;
    String name;
    CLIENT_CATEGORY category;
    String document;
}
