package users;

import java.util.Objects;

public class Users {

    private int id;
    private String name;
    private String password;

    public Users() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Users(String name, String password) {
        this.name = name;
        this.password = password;
    }

//    public boolean equals(Object o) {
//        if (o instanceof Users) {
//            Users p = (Users) o;
//            return Objects.equals(this.id, p.id) && Objects.equals(this.name, p.name) && Objects.equals(this.password, p.password);
//        }
//        return false;
//    }
}
