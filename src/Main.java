import com.yourname.transport.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. Создаем объекты транспорта ...");
        Car car1 = new Car("CAR-001", "car", "Toyota Camry", "Синий", "Япония",
                2.5, 4, "седан", "комфорт", 2.5);

        Car car2 = new Car("CAR-002", "car", "BMW X5", "Черный", "Германия",

                3.0, 5, "внедорожник", "люкс", 3.0);

        Bicycle bike1 = new Bicycle("BIKE-001", "bicycle", "горный");
        Bicycle bike2 = new Bicycle("BIKE-002", "bicycle", "городской");
        Bicycle bike3 = new Bicycle("BIKE-003", "bicycle", "шоссейный");


        System.out.println("\n2. Создаем менеджер и добавляем транспорт в коллекции ... ");

        TransportManager manager = new TransportManager();
      manager.addTransport(car1);
      manager.addTransport(car2);
      manager.addTransport(bike1);
      manager.addTransport(bike2);
      manager.addTransport(bike3);

        System.out.println("\n3. Демонстрация работы List и Set ...");
        manager.printAllTransports();
        manager.printUniqueTypes();

        System.out.println("\n4. Демонстрация строго поиска в Map ...");
        manager.findById("CAR-001");
        manager.findById("BIKE-001");
        manager.findById("UNKNOWN-123");

        System.out.println("\n5. Работа с интерфейсом Repairable через коллекции ...");
        manager.sendAllRepairableToService();
    }
}