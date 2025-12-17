import com.yourname.transport.Car;
import com.yourname.transport.DuplicateIdException;
import com.yourname.transport.TransportManager;
import com.yourname.transport.TransportNotFoundException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        TransportManager manager = new TransportManager();

        Car car1 = new Car("CAR-001", "car", "Toyota", "синий", "Japan",
                2.5, 5, "sedan", "premium", 2.5, null);

        System.out.println("=== 1. Умпешное добавление ===");
        try {
            manager.addTransport(car1);
            System.out.println("Успешно!");
        } catch (DuplicateIdException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n=== 2. Попытка добавить дубликат ===");
        Car car2 = new Car("CAR-001", "car", "BMW", "черный", "Germany",
                3.0, 5, "SUV", "luxury", 3.0, null);
        try {
            manager.addTransport(car2);
        } catch (DuplicateIdException e) {
            System.out.println("Поймали ожидаемую ошибку: " + e.getMessage());
        }

        System.out.println("\n.=== 3. Использование safeAddTransport ===");
        manager.safeAddTransport(car2);

        System.out.println("\n=== 4. Поиск несуществующего транспорта ===");
        try {
            manager.findByIdOrThrow("UKNOWN");
        } catch (TransportNotFoundException e) {
            System.out.println("Поймали: " + e.getMessage());
        }

        System.out.println("\n=== 5. Try-with-resources (демонстрация) ===");
        String fileName = "config.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            System.out.println("Прочитано из файла: " + line);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}