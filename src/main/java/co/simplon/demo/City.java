package co.simplon.demo;

import java.util.Objects;

public class City {
    String name;
    double longitude;
    double latitude;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setName(String name) {
        this.name = name;
    }
public City(String name, double longitude, double latitude){
        this.name= name;
        this.latitude=latitude;
        this.longitude= longitude;
}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Double.compare(city.longitude, longitude) == 0 &&
                Double.compare(city.latitude, latitude) == 0 &&
                Objects.equals(getName(), city.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), longitude, latitude);
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    public String getName() {
        return name;
    }
}
