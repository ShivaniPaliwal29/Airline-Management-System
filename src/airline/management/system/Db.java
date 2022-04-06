/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.management.system;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ksaum
 */
public class Db {
    Connection con;
    public Connection dbConnect(String dbname){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/"+dbname);
            System.out.println("connected successfully");
            this.con=con;
            return con;
            
        }catch(Exception e){
            e.printStackTrace();
        } 
        return null;
    }
    public void insert(String id,int p){
        try{
            PreparedStatement ps=con.prepareStatement("insert into Login values(?,?)");
            ps.setString(1,id);
            ps.setInt(2,p);
            if(ps.executeUpdate()>0)
              System.out.println("inserted successfully");  
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    int p;
    public void insertPassenger(String tk,String f,String t,String s,String des,String d,String fl){
        
         p=(int) Math.floor(Math.random() * 100);
        System.out.println(p);
        try{
            PreparedStatement ps=con.prepareStatement("insert into Passenger values(?,?,?,?,?,?,?,?)");
            ps.setString(2,tk);
            ps.setInt(1,p);
            ps.setString(3,f);
            ps.setString(4,t);
            ps.setString(7,d);
            ps.setString(5,s);
            ps.setString(6,des);
            ps.setString(8,fl);
            if(ps.executeUpdate()>0)
              System.out.println("inserted successfully");  
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void insertReservation(String f,String t,String s,String des,String d){
        try{
            String q=Integer.toString(p);
            int ticket;
            ticket=(int) Math.floor(Math.random() * 100);
            String tk=Integer.toString(ticket);
            tk="AB"+tk;
            System.out.println(tk);
            PreparedStatement ps=con.prepareStatement("insert into Reservation values(?,?,?,?,?,?,?)");
            ps.setString(2,tk);
            ps.setString(1,q);
            ps.setString(3,f);
            ps.setString(4,t);
            ps.setString(7,d);
            ps.setString(5,s);
            ps.setString(6,des);
            if(ps.executeUpdate()>0)
              System.out.println("inserted successfully");  
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void insertFlightSector(String p,String tk,String f,String t,String s,String des,String d){
        try{
            //PreparedStatement ps=con.prepareStatement("insert into Flight values(?,?,?,?)");
            PreparedStatement ps1=con.prepareStatement("insert into Sector values(?,?,?,?)");
            /*ps.setString(2,tk);
            ps.setString(1,p);
            ps.setString(3,f);
            ps.setString(4,t);*/
            ps1.setString(4,d);
            ps1.setString(2,s);
            ps1.setString(3,des);
            ps1.setString(1,p);
            if(ps1.executeUpdate()>0)
              System.out.println("inserted successfully");  
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void insertPayment(String ch,String card,String date,String ph){
        try{
            int amount=5999;
            PreparedStatement ps=con.prepareStatement("insert into Payment values(?,?,?,?,?,?)");
            ps.setInt(1,p);
            ps.setString(6,ph);
            ps.setString(2,ch);
            ps.setString(3,card);
            ps.setInt(4,amount);
            ps.setString(5,date);
            if(ps.executeUpdate()>0)
              System.out.println("inserted successfully");  
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
   /* public void createTable(){
        try{
            PreparedStatement ps=con.prepareStatement("create table reservation (pnr_no varchar(10), ticket_id varchar(10), f_code varchar(10), jny_date varchar(20), jny_time varchar(10), src varchar(20), dst varchar(20));
            if(ps.executeUpdate()>0)
              System.out.println("created successfully"); 
            }
        
        catch(Exception e){
            e.printStackTrace();
        }
    }*/
    /*public void update(int id,String n,String c,String d){
        try{
            PreparedStatement ps=null;
            ps=con.prepareStatement("update agri set Fname=?,City=?,State=? where FarmerNo=?");
            ps.setInt(4,id);
            ps.setString(1,n);
            ps.setString(2,c);
            ps.setString(3,d);
            if(ps.executeUpdate()>0)
              System.out.println("updated successfully");  
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }*/
    public ResultSet search(String id,int i)throws Exception{
        PreparedStatement ps = con.prepareStatement("select * from Login where Username=? AND Password=?");
        ps.setString(1, id);
        ps.setInt(2, i);
        ResultSet rs = ps.executeQuery();
 
        return rs;
    }
    public ResultSet searchReservation(String src,String des)throws Exception{
        PreparedStatement ps = con.prepareStatement("select * from Reservation where src=? AND des =?");
        ps.setString(1, src);
        ps.setString(2, des);
        ResultSet rs = ps.executeQuery();
 
        return rs;
    }
    public ResultSet searchFlight(String src,String des)throws Exception{
        PreparedStatement ps = con.prepareStatement("select * from Flight where src=? AND des =?");
        ps.setString(1, src);
        ps.setString(2, des);
        ResultSet rs = ps.executeQuery();
 
        return rs;
    }
    public ResultSet searchFlightInfo(String fl)throws Exception{
        PreparedStatement ps = con.prepareStatement("select * from Flight where f_code=?");
        ps.setString(1, fl);
        ResultSet rs = ps.executeQuery();
 
        return rs;
    }
    public ResultSet searchSector(String fl)throws Exception{
        PreparedStatement ps = con.prepareStatement("select * from Sector where flight_code=?");
        ps.setString(1, fl);
        ResultSet rs = ps.executeQuery();
 
        return rs;
    }
    public ResultSet searchPayment(int pnr)throws Exception{
        PreparedStatement ps = con.prepareStatement("select * from Payment where pnr_no=?");
        ps.setInt(1, pnr);
        ResultSet rs = ps.executeQuery();
 
        return rs;
    }
    
}
