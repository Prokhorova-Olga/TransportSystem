import com.yourname.transport.*;
import com.yourname.transport.exceptions.InvalidColorException;
import com.yourname.transport.exceptions.InvalidEngineVolumeException;
import com.yourname.transport.exceptions.InvalidLicenseException;
import com.yourname.transport.exceptions.ValidationException;



public class Main {
    public static void main(String[] args) {

        System.out.println("=== Демонстрация работы валидатора данных ===\n");

        System.out.println("1. Создание валидного водителя");
        try {
            Driver validDriver = new Driver("AB123456", "Иван Петров");
            System.out.println(" Успешно создан: " + validDriver);
        } catch (ValidationException e) {
            System.out.println(" Ошибка: " + e.getMessage());
        }

        System.out.println("\n2. Создание водителя с неправильным форматом прав:");
        try {
            Driver invalidDriver = new Driver("123", "Иван");
            System.out.println("Не должно получиться!");
        } catch (InvalidLicenseException e) {
            System.out.println("  Поймали InvalidLicenseException: " + e.getMessage());
        }

        System.out.println("\n3. Создание валидного автомобиля:");
        try {
            Driver driver = new Driver("CD654321", "Анна Сидорова");
            Car validCar = new Car("CAR-001", "car", "Toyota Camry", "синий",
                    "Япония", 2.5, 5, "седан", "комфорт", 2.5, driver);
            System.out.println("Успешно создан: " + validCar.getModel());
        } catch (ValidationException e) {
            System.out.println(" Ошибка: " + e.getMessage());
        }

        System.out.println("\n4. Создание автомобиля с недопустимым цветом:");
        try {
            Car invalidCar = new Car("CAR-002", "car", "BMW", "розовый",
                    "Германия", 3.0, 5, "внедорожник", "люкс", 3.0, null);
            System.out.println("  Не должно получиться!");
        } catch (InvalidColorException e) {
            System.out.println("Поймали InvalidColorException: " + e.getMessage());
        }

        System.out.println("\n5. Создаем автомобиль с отрицательным объемом двигателя:");
        try {
            Car invalidCar = new Car("CAR-003", "car", "Lada", "белый",
                    "Россия", -1.5, 4, "седан", "база", 1.5, null);
            System.out.println("  Не должно получиться!");
        } catch (InvalidEngineVolumeException e) {
            System.out.println("Поймали InvalidEngineVolumeException: " + e.getMessage());
        }

        System.out.println("\n6. Комплексный тест с несколькими ошибками:");
        try {
            Car invalidCar = new Car("", "car", "", "красный",
                    "", 0, 1, "", "", 0, null);
            System.out.println(" Не должно получиться!");
        } catch (ValidationException e) {
            System.out.println("Поймали ValidationException: " + e.getMessage());
            System.out.println("Первая ошибка остановила валидацию - так и должно быть!");
            System.out.println("\n=== Демонстрация завершена ===");

        }
    }
}