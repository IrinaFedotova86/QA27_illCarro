package models;

import enums.Fuel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



    @Getter
    @Setter
    @ToString
    @Builder

    public class Car {
    private String location;
    private String manufacture;
    private String model;
    private String year;
    private Fuel fuel;
    private int seat;
    private String carClass;
    private String carRegNumber;
    private double price ;
    private String about;


}
