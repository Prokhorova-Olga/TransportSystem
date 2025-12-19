package com.yourname.transport.validators;

import com.yourname.transport.Car;
import com.yourname.transport.Driver;
import com.yourname.transport.exceptions.InvalidColorException;
import com.yourname.transport.exceptions.InvalidEngineVolumeException;
import com.yourname.transport.exceptions.InvalidIdException;
import com.yourname.transport.exceptions.ValidationException;

public class CarValidator implements Validator<Car> {

    private final Validator<Driver> driverValidator;

    public CarValidator(Validator<Driver> driverValidator) {
        this.driverValidator = driverValidator;
    }

    @Override
    public void validate(Car car) {
        if (car == null) {
            throw new ValidationException("Car не может быть null");
        }
        validateId(car.getId());
        validateModel(car.getModel());
        validateColor(car.getColor());
        validateEngineCapacity(car.getEngineCapacity());
        validateNumberOfDoors(car.getNumberOfDoors());
        if (car.getDriver() != null) {
            driverValidator.validate(car.getDriver());
        }
    }

    private void validateId(String id) {
        if (id == null || id.isBlank()) {
            throw new InvalidIdException(id);
        }
        if (!id.contains("-")) {
            throw new InvalidIdException("ID должен содержать дефис: 'CAR-001'");
        }
    }

    private void validateModel(String model) {
        if (model == null || model.isBlank()) {
            throw new ValidationException("Модель автомобиля не может быть пустой");
        }
    }

    private void validateColor(String color) {
        if (color == null || color.isBlank()) {
            throw new InvalidColorException(color);
        }
        String[] allowedColors = {"красный", "синий", "черный", "белый", "зеленый", "серый"};
        boolean isValid = false;
        for (String allowed : allowedColors) {
            if (allowed.equalsIgnoreCase(color)) {
                isValid = true;
                break;
            }
        }
        if (!isValid) {
            throw new InvalidColorException("Цвет '" + color + "' не входит в список допустимых");
        }
    }

    private void validateEngineCapacity(double volume) {
        if (volume <= 0) {
            throw new InvalidEngineVolumeException(volume);
        }
        if (volume > 10.0) {
            throw new InvalidEngineVolumeException("Объем двигателя не может превышать 10.0 литров");
        }
    }

    private void validateNumberOfDoors(int doors) {
        if (doors < 2 || doors > 7) {
            throw new ValidationException("Количество дверей должно быть от 2 до 7");
        }
    }







}
