import com.yourname.transport.Bicycle;
import com.yourname.transport.Car;
import com.yourname.transport.Transport;


public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("123", "passengerCar", "Audi", "red",
                "Germany", 4.5, 5, "crossover", "base", 567);

        Bicycle bicycle1 = new Bicycle("456", "bicycle", "sport");

        Transport carRef = new Car("980", "passengerCar", "BWW", "white",
                "Germany", 5.0, 5, "crossover", "comfort", 632);


        Transport[] transports = {
                car1,
                bicycle1,
                carRef,
        new Bicycle("789", "mountain", "горный"
        )};

        System.out.println("\n=== Демонстрация полиморфизма ===");
        for (Transport transport : transports) {
            transport.move();
            System.out.println(transport.getInfo());
            System.out.println("------");
        }

        System.out.println("\n===== Проверка инкапсуляции ===");
//        System.out.println(car1.id);

        System.out.println("\n===== Приведение типов ====");
        for (Transport transport : transports) {
            if (transport instanceof Car) {
                Car car = (Car) transport;
                car.setTheAlarm();
            }
            if (transport instanceof Bicycle) {
                Bicycle bicycle = (Bicycle) transport;
                System.out.println("Тип велосипеда: " + bicycle.getBicycleType());

            }
        }
    }
}