import com.yourname.transport.*;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация проблемы с HashMap (без equals/hashCode)===");
        Driver driver1 = new Driver("AB123456", "Иван Петров");
        Driver driver2 = new Driver("AB123456", "Иван Петров");

        Map<Driver, String> driverCarMap = new HashMap<>();

        driverCarMap.put(driver1, "Toyota Camry");
        System.out.println("1. Добавили driver1 -> Toyota Camry");

        String car = driverCarMap.get(driver2);
        System.out.println("2. Ищем по drive2 (такой же licenseId): " + car);
        System.out.println("  Результат: " + (car == null ? "НЕ НАЙДЕН! (ПРОБЛЕМА)" : car));

        System.out.println("\n3. Сравнение объектов:");
        System.out.println("  driver1 == driver2 : " + (driver1 == driver2));
        System.out.println("  driver1.equals(driver2) : " + driver1.equals(driver2));
        System.out.println(" driver1.hashCode() = " + driver1.hashCode());
        System.out.println(" driver2.hashCode() = " + driver2.hashCode());

        System.out.println("\n=== Демонстрация коллизий в HashMap ===");

        Driver driver3 = new Driver("АВ", "Иван");
        Driver driver4 = new Driver("ВА", "Петр");

        System.out.println("hashCode driver3: " + driver3.hashCode());
        System.out.println("hashCode driver4: " + driver4.hashCode());
        System.out.println("Коллизия? " + (driver3.hashCode() == driver4.hashCode() &&
                !driver3.equals(driver4)));

        Map<Driver, String> collosionMap = new HashMap<>();
        collosionMap.put(driver3, "Машина 3");
        collosionMap.put(driver4, "Машина 4");

        System.out.println("\nСодержимое HashMap при коллизии:");
        for (Map.Entry<Driver, String> entry : collosionMap.entrySet()) {
            System.out.println(" " + entry.getKey() + " -> " + entry.getValue());
        }

    }
}