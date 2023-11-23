package com.builderpattern.exception;

public class CarNotFoundException extends EntityNotFoundException{
    public CarNotFoundException(String message) {
        super(message);
    }

    public CarNotFoundException(Long carId) {
        this("Car with id %d doesn't exist".formatted(carId));
    }
}
