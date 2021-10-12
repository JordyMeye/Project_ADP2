
package za.ac.cput.login.user.admin;


public class Admin {
    
    private String name ;
    private String Location;
    private String type ;
    private String cost;
    private int number ;
    private String availability;
    private String date ;

    public Admin(String name, String Location, String type, String cost, int number, String availability, String date) {
        this.name = name;
        this.Location = Location;
        this.type = type;
        this.cost = cost;
        this.number = number;
        this.availability = availability;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return Location;
    }

    public String getType() {
        return type;
    }

    public String getCost() {
        return cost;
    }

    public int getNumber() {
        return number;
    }

    public String getAvailability() {
        return availability;
    }

    public String getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Admin{" + "name=" + name + ", Location=" + Location + ", type=" + type + ", cost=" + cost + ", number=" + number + ", availability=" + availability + ", date=" + date + '}';
    }
    
    
    
}
