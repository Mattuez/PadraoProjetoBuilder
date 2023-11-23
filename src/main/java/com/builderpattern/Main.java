package com.builderpattern;

import com.builderpattern.applicationContext.ApplicationContext;
import com.builderpattern.builder.CarBuilder;
import com.builderpattern.builder.CarBuilderImpl;
import com.builderpattern.exception.BusinessException;
import com.builderpattern.model.Car;
import com.builderpattern.model.CarType;
import com.builderpattern.model.Pessoa;

import java.time.Year;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext();

        CarBuilder carBuilder = new CarBuilderImpl();

        Car car1 = exemploSemBuilderComTodosOsParametros();
        Car car2 = exemploSemBuilderComParametrosNecessarios();
        Car car3 = exemploComBuilderComTodosParametros();
        Car car4 = exemploComBuilderComParametrosNecessarios();
        Pessoa pessoa = exemploLombok();

        try {
            applicationContext.getCarService().insert(car1);
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(applicationContext.getCarService().getById(car1.getId()));;
    }

    private static Car exemploSemBuilderComTodosOsParametros() {

        return new Car(null, "HJL123", "Modelo sem builder com todos os parametros", Year.of(2000),
                "Marca de exemplo 1", "Azul", "273981739", CarType.COMBUSTION_CAR, true);
    }

    private static Car exemploSemBuilderComParametrosNecessarios() {

        return new Car(null, "DSV", "Modelo sem builder com parametros necessarios", null,
                null, null, null, CarType.ELECTRIC_CAR, true);
    }

    private static Car exemploComBuilderComTodosParametros() {

        CarBuilder carBuilder = new CarBuilderImpl();

        return carBuilder
                .licensePlate("NTJ1234")
                .model("Modelo com builder com todos os parametros")
                .releaseYear(Year.of(1980))
                .brand("exemplo 2")
                .color("azul")
                .vin("1234567890")
                .carType(CarType.COMBUSTION_CAR)
                .build();
    }

    private static Car exemploComBuilderComParametrosNecessarios() {

        CarBuilder carBuilder = new CarBuilderImpl();

        return carBuilder
                .licensePlate("ATX5050")
                .model("Modelo com builder com parametros necessarios")
                .carType(CarType.HYBRID)
                .build();
    }

    private static Pessoa exemploLombok() {

        return Pessoa.builder()
                .firstName("Joao")
                .lastName("Pessoa")
                .age(10)
                .height(160)
                .build();
    }
}