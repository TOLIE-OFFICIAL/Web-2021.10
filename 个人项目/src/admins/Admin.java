package admins;

public class Admin {

    private int id;
    private String Admin_name;
    private String Apwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdmin_name() {
        return Admin_name;
    }

    public void setAdmin_name(String admin_name) {
        Admin_name = admin_name;
    }

    public String getApwd() {
        return Apwd;
    }

    public void setApwd(String apwd) {
        Apwd = apwd;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", Admin_name='" + Admin_name + '\'' +
                ", Apwd='" + Apwd + '\'' +
                '}';
    }

    public Admin(String admin_name, String apwd) {
        Admin_name = admin_name;
        Apwd = apwd;
    }
}

