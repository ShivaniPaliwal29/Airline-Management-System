/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.management.system;

import java.sql.Date;
import java.util.Scanner;

/**
 *
 * @author ksaum
 */
public class AirlineManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Scanner o=new Scanner(System.in);
        Db obj=new Db();
        obj.dbConnect("Airline Management System");
       // obj.insertReservation("103","AB566","AJ970","2:00PM","Kolkata","Patna","2021-12-12");
       //obj.insertFlightSector("AJ970","INDIGO 1","Kolkata","Patna","100","A","First Class");
       //obj.insertFlightSector("AJ900","INDIGO 2","Kolkata","Patna","550","B","Second Class");
       //obj.insertFlightSector("AJ960","INDIGO 3","Kolkata","Patna","30","C","Third Class");
        //obj.insertPayment(100,null,"1234987623458765",1200,"2021-11-2","8292560588");
        //obj.insertPayment(103,null,"1234987623456543",1700,"2021-11-21","9123989805");
        //obj.insertPayment(100,null,"1234987623458765",1200,"2021-11-2","8292560588");
    }
    
}
