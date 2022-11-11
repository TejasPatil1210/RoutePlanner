package com.jap.RoutePlanner;

public class Routes {

    private String sourcecity;
    private String destinationcity;
    private int distance;
    private String flighttime;
    private String ticketcost;


    public Routes(String sourcecity,String destinationcity,int distance,String flighttime,String ticketcost){
        this.sourcecity=sourcecity;
        this.destinationcity=destinationcity;
        this.distance=distance;
        this.flighttime=flighttime;
        this.ticketcost=ticketcost;
    }

    public String getSourcecity(){return sourcecity;}
    public String getDestinationcity(){return destinationcity;}
    public int getDistance(){return distance;}
    public String getFlighttime(){return flighttime;}
    public String getTicketcost(){return ticketcost;}


    public void showFlightDetails()
    {
        //System.out.printf("%5s %10s %35s %20s %20s\n", "From", "To","Distance in km","Travel Time","Typical Airfare");
        System.out.printf("%5s %25s %20d %25s %25s\n", getSourcecity(), getDestinationcity(),getDistance(),getFlighttime(),
                getTicketcost());
    }
}
