import java.util.Objects;

public class Product {
    private String name;
    private String description;
    private String ID;
    private double cost;
    static private int IDSeed =  1;

    public void setID(String ID) {
        this.ID = ID;
    }

    public Product(String name, String description, double cost) {
        this.cost = cost;
        this.ID = genIDNum();
        this.description = description;
        this.name = name;
    }

    public Product(String ID,String name, String description, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    private String genIDNum() {
        String newID = "" + IDSeed;
        while(newID.length() < 8)
        {
            newID = "0" + newID;
        }
        IDSeed++;
        return newID;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getID() {
        return ID;
    }

    public double getCost() {
        return cost;
    }

    public static int getIDSeed() {
        return IDSeed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ID='" + ID + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(cost, product.cost) == 0 && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(ID, product.ID);
    }

    public String toJSON()
    {
        String retString = "";
        char DQ = '\u0022';  // Assign the double quote char to a variable
        retString =  "{" + DQ + "ID" + DQ + ":" + DQ + this.ID + DQ + ",";
        retString += DQ + "name" + DQ + ":" + DQ + this.name + DQ + ",";
        retString += " " + DQ + "description"  + DQ + ":" + DQ + this.description + DQ + ",";
        retString += " " + DQ + "cost"  + DQ + ":" + this.cost + "}";

        return retString;
    }

    public String toXML()
    {
        String retString = "";

        retString = "<Product>" + "<ID>" + this.ID + "</ID>";
        retString += "<name>" + this.name + "</name>";
        retString += "<description>" + this.description + "</description>";
        retString += "<cost>" + this.cost + "</cost></Person>";

        return retString;
    }
    public String toCSV() {
        return  this.ID + ", " + this.name + "," + this.description + "," +this.cost;}
        }


