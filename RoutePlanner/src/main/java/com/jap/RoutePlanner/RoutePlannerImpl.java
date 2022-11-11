package com.jap.RoutePlanner;

import java.util.Scanner;
import java.io.*;
public class RoutePlannerImpl {
    public static void main(String[] args) throws IOException, NumberFormatException {
        Scanner scan = new Scanner(System.in);
        RoutePlannerOperations rpl = new RoutePlannerOperations();
        String filename = "E:\\NIIT_Study_Materials\\Core_Java\\Course4\\Java Demos\\Sprint\\RoutePlanner\\src\\main\\java\\com\\jap\\RoutePlanner\\routes.csv";
        int count = 0;
        count = rpl.countofFlightRecords(filename);

        Routes[] routes = null;
        routes = rpl.readflightrecords(filename, count);
        System.out.printf("%5s %23s %28s %22s %25s\n", "From", "To", "Distance in km", "Travel Time", "Typical Airfare");
        for (Routes x : routes) {
            x.showFlightDetails();
        }
        System.out.println("Enter Source City Name");
        String cityname = scan.nextLine();
        rpl.showDirectFlights(routes, cityname);

        System.out.println("Enter Source City Name");
        String sourceCity = scan.nextLine();
        System.out.println("Enter Destination City Name");
        String destinationCity = scan.nextLine();
        rpl.showAllConnections(routes, sourceCity, destinationCity);
        rpl.Intermediate_Connection(routes, sourceCity, destinationCity);
    }
}



