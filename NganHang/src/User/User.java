
package User;

public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private String role;
    private String CMND;
    private long money;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getCMND() {
        return CMND;
    }

    public long getMoney() {
        return money;
    }

}

