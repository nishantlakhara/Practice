package designpatterns.behavorial.command;

public class Light {
    String area;

    public Light(String area) {
        this.area = area;
    }

    public void turnOn() {
        System.out.println(area + " Light turned on");
    }

    public void turnOff() {
        System.out.println(area + " Light turned off");
    }

    @Override
    public String toString() {
        return "Light{" +
                "area='" + area + '\'' +
                '}';
    }
}
