package entity;

public class Client {

    private final int id;
    private final String name;
    private final CLIENT_CATEGORY category;
    private final String document;

    public int getId() {
        return id;
    }

    public Client(int id, String name, CLIENT_CATEGORY category, String document) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public CLIENT_CATEGORY getCategory() {
        return category;
    }

    public String getDocument() {
        return document;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", document='" + document + '\'' +
                '}';
    }
}
