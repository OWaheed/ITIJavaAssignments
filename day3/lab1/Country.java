import java.util.ArrayList;
import java.util.List;

public class Country {
    private  int code;
    private String name;
    private ArrayList<City> cities = new ArrayList<>();

    public Country() {
    }

    public Country(int code, String name) {
        this.code = code;
        this.name = name;
    }



    public Country(int code, String name, ArrayList<City> cities) {
        this.code = code;
        this.name = name;
        this.cities = cities;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }
    public void setCity(City c) {
        this.cities.add(c);
    }


    @Override
    public String toString() {
        return "Country{" +
                "code=" + code +
                ", name='" + name + '\'' ;
    }
}
