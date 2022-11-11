package com.jap.RoutePlanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RoutePlannerOperations {
    public int countofFlightRecords(String filename) throws IOException, NumberFormatException {
        File f = new File(filename);
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            while (br.readLine() != null) count++;
        }

        return count;
    }


    public Routes[] readflightrecords(String filename, int count) throws IOException, NumberFormatException {
        File f = new File(filename);
        Routes[] routes = new Routes[count];
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            int i = 0;
            String temp;
            while ((temp = br.readLine()) != null) {
                String tempArr[] = temp.split(",");
                int distance = Integer.parseInt(tempArr[2].trim());
                routes[i] = new Routes(tempArr[0].trim(), tempArr[1].trim(), distance, tempArr[3].trim(), tempArr[4].trim());
                i++;
            }

        }
        return routes;
    }

    public void showDirectFlights(Routes[] routeInfo, String fromCity) {
        int count = 0;
        for (int i = 0; i < routeInfo.length; i++) {
            if (fromCity.equalsIgnoreCase(routeInfo[i].getSourcecity()))
                count++;
        }
        if (count == 0) {
            System.out.println("We are sorry.At this point of time, " +
                    "we do not have any information on flights originating from " + fromCity.toUpperCase());
            System.exit(0);
        }

        System.out.println("Direct Flights from "+fromCity.toUpperCase());
        System.out.println("Before Sorting");
        System.out.printf("%5s %23s %28s %22s %25s\n", "From", "To", "Distance in km", "Travel Time", "Typical Airfare");
        for (int i = 0; i < routeInfo.length; i++) {
            if (fromCity.equalsIgnoreCase(routeInfo[i].getSourcecity()))
                routeInfo[i].showFlightDetails();
        }

        System.out.println();
        // System.out.println(count);
        String[] directflights = new String[count];

        for (int j = 0; j < directflights.length; j++) {
            for (int i = 0; i < routeInfo.length; i++) {
                if (fromCity.equalsIgnoreCase(routeInfo[i].getSourcecity())) {
                    directflights[j] = routeInfo[i].getDestinationcity();
                    j++;
                }
            }
        }

        sortDirectFlights(directflights);
        System.out.println("After Sorting");
        System.out.printf("%5s %23s %28s %22s %25s\n", "From", "To", "Distance in km", "Travel Time", "Typical Airfare");
        for (int i = 0; i < directflights.length; i++) {
            String temp = directflights[i];
            for (int j = 0; j < routeInfo.length; j++) {
                if (fromCity.equalsIgnoreCase(routeInfo[j].getSourcecity()) && (temp.equalsIgnoreCase(routeInfo[j].getDestinationcity()))) {
                    routeInfo[j].showFlightDetails();
                }
            }
        }
    }

    public void sortDirectFlights(String directFlights[]) {
        for (int pass = 1; pass < directFlights.length; pass++) {
            for (int i = 0; i < directFlights.length - pass; i++) {
                if ((directFlights[i].compareToIgnoreCase(directFlights[i + 1])) > 0) {
                    String temp = directFlights[i];
                    directFlights[i] = directFlights[i + 1];
                    directFlights[i + 1] = temp;
                }
            }
        }
    }

    public void showAllConnections(Routes[] routeInfo, String fromCity, String toCity) {
        //int count1=routeInfo.length;
        int count = 0;
        for (int i = 0; i < routeInfo.length; i++) {
            if ((fromCity.equalsIgnoreCase(routeInfo[i].getSourcecity())) && (toCity.equalsIgnoreCase(routeInfo[i].getDestinationcity())))
                count = count + 1;

            // showIntermediateconnection(routeInfo,toCity);
        }
        if (count == 0) {
            System.out.println("There is no direct flights from " + fromCity.toUpperCase() + " to " + toCity.toUpperCase());
            System.out.println();
        }
        else {
            System.out.println("Direct Flights from " + fromCity.toUpperCase() + " to " + toCity.toUpperCase());
            System.out.printf("%5s %23s %28s %22s %25s\n", "From", "To", "Distance in km", "Travel Time", "Typical Airfare");

            for (int i = 0; i < routeInfo.length; i++) {
                if (fromCity.equalsIgnoreCase(routeInfo[i].getSourcecity()) && (toCity.equalsIgnoreCase(routeInfo[i].getDestinationcity()))) {
                    routeInfo[i].showFlightDetails();
                }
            }
        }
        //System.out.println("Intermediate Flights from " + fromCity + " to " + toCity);
        //System.out.printf("%5s %23s %28s %22s %25s\n", "From", "To", "Distance in km", "Travel Time", "Typical Airfare");
        //showIntermediateconnection(routeInfo,fromCity, toCity);
        //System.out.println("Intermediate Flights are");


    }
 /*   public void showIntermediateconnection(Routes[] routes,String fromCity, String toCity) {

        for (int i = 0; i < routes.length; i++) {
            if (toCity.equalsIgnoreCase(routes[i].getDestinationcity())) {
               // if(fromCity.equalsIgnoreCase(routes[i].getSourcecity()) && (toCity.equalsIgnoreCase(routes[i].getDestinationcity())))
                //{continue;}
               // else{
                    showIntermediateconnection(routes,fromCity,routes[i].getSourcecity());//}
                    routes[i].showFlightDetails();
            }
        }

    }*/


    public void Intermediate_Connection(Routes[] routeInfo, String fromCity, String toCity) {
        int count = 0;
        for (int i = 0; i < routeInfo.length; i++) {
            if (fromCity.equalsIgnoreCase(routeInfo[i].getSourcecity()))
                if (fromCity.equalsIgnoreCase(routeInfo[i].getSourcecity()) && (toCity.equalsIgnoreCase(routeInfo[i].getDestinationcity()))) {
                    continue;
                } else count++;
        }

        String[] directflights = new String[count];

        for (int j = 0; j < directflights.length; j++) {
            for (int i = 0; i < routeInfo.length; i++) {
                if (fromCity.equalsIgnoreCase(routeInfo[i].getSourcecity())) {
                    if (fromCity.equalsIgnoreCase(routeInfo[i].getSourcecity()) &&
                            (toCity.equalsIgnoreCase(routeInfo[i].getDestinationcity()))) {
                        continue;
                    } else {
                        directflights[j] = routeInfo[i].getDestinationcity();
                        j++;
                    }
                }
            }
        }

        int count1 = 0;
        for (int j = 0; j < directflights.length; j++) {
            String temp = directflights[j];
            for (int i = 0; i < routeInfo.length; i++) {
                if (temp.equalsIgnoreCase(routeInfo[i].getSourcecity()) &&
                        (toCity.equalsIgnoreCase(routeInfo[i].getDestinationcity()))) {
                    count1++;
                }
            }
        }

        if(count1 == 0) {
            System.out.println("There is no Intermediate Flights from " + fromCity.toUpperCase()+" to "+toCity.toUpperCase());
            System.exit(0);}


        String[] directflights1 = new String[count1];
        for (int k = 0; k < directflights1.length; k++) {
            for (int j = 0; j < directflights.length; j++) {
                String temp = directflights[j];
                for (int i = 0; i < routeInfo.length; i++) {
                    if (temp.equalsIgnoreCase(routeInfo[i].getSourcecity()) &&
                            (toCity.equalsIgnoreCase(routeInfo[i].getDestinationcity()))) {
                        directflights1[k] = temp;
                        k++;
                    }
                }
            }
        }
        System.out.println();
        System.out.println("Intermediate Flights from "+fromCity.toUpperCase()+" to "+toCity.toUpperCase());
        System.out.printf("%5s %23s %28s %22s %25s\n", "From", "To", "Distance in km", "Travel Time", "Typical Airfare");

        for (int i = 0; i < directflights1.length; i++)
        {String temp=directflights1[i];
            for (int j = 0; j < routeInfo.length; j++) {
                if (fromCity.equalsIgnoreCase(routeInfo[j].getSourcecity()) && temp.equalsIgnoreCase(routeInfo[j].getDestinationcity()))
                {routeInfo[j].showFlightDetails();}
                if (temp.equalsIgnoreCase(routeInfo[j].getSourcecity())&&toCity.equalsIgnoreCase(routeInfo[j].getDestinationcity()))
                {routeInfo[j].showFlightDetails();
                    break;}
            }
        }
    }
}
