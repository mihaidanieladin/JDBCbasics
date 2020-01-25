package Main;

// Defining a Person type object
public class Person {
    
    // Defining person attributes
    private int id_person;
    private String name;
    private String surname;
    private String email;
    private String telephone;
    
    
    // GETTERS AND SETTERS
    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {    
        this.id_person = id_person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Person{" + "id_person=" + id_person + ", name=" + name + ", surname=" + surname + ", email=" + email + ", telephone=" + telephone + '}';
    }
    
    
}
