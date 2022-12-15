/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline_reservation_systems;

import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
public class Seats  {
    int Number_of_Seats = 20;
    public static ArrayList<String> Available_Seats = new ArrayList<String>();
    Connection connect;
    String query;
    Statement st;
    ResultSet r;
    static  Semaphore sem = new Semaphore(1);
   

    public ArrayList<String> Get_Available_Seats(){
         try{
            int Available=0;
            connect= DbConnection.getConnection();
            Available_Seats = new ArrayList<>();
            query="select Name from seat where Check_Seat='"+Available+"'";
            st=connect.prepareStatement(query);
            r=st.executeQuery(query);
            while(r.next()){
               Available_Seats.add(r.getString("Name"));
         
            }
          
          
       }catch(SQLException ex){
         System.out.println(ex);
       }
          finally{
            try{
                connect.close();
                st.close();
                r.close();
                
            }
            catch(SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
    }
          return  Available_Seats;
    }
    public  boolean validateSeat(String Name ,int Seat_id) {
     
        boolean check = true;
        try {
            sem.acquire();
            System.out.println(Thread.currentThread().getName());
            int isValiable = getCheckSeat(Name);
            if (isValiable == 1) {
                updateAvailableSeats(Name);
                check = false;
            } else {
                check = updateSeat(Seat_id);
            }
        } catch (InterruptedException ex) {
            check = false;
            System.out.println(ex);
        }finally{
            sem.release();
        }
        
        return check;
    }
   

     public boolean updateSeat(int Seat_id){
         boolean check;
         try {
             connect = DbConnection.getConnection();
             query = "update seat set Check_Seat = 1 where id = '" + Seat_id + "'";
             st = connect.prepareStatement(query);
             int result = st.executeUpdate(query);
             
             check = result != 0;
         } catch (SQLException ex) {
             check = false;
            System.out.println(ex);
         }
         return check;
    }
     
     public void updateAvailableSeats(String Name){
          for (int i = 0; i < Available_Seats.size(); i++) {
             if (Available_Seats.get(i).equals(Name)) {
                 Available_Seats.remove(i);
             }
         }
     }
     
     
     public int getCheckSeat(String Name){
        int isValiable=0;
        try {
            connect = DbConnection.getConnection();
            String seatQuery = "SELECT Check_Seat FROM seat WHERE Name ='" + Name+ "'";
            Statement resSeatQuery = connect.prepareStatement(seatQuery);
            r = resSeatQuery.executeQuery(seatQuery);
          
          if(r.next()){
              isValiable=r.getInt("Check_Seat");
          }
        } catch (SQLException ex) {
           System.out.println(ex);
        }
          return  isValiable; 
     }
     
     // Function for creating Name of Seats (Just Run only one time )
    
    public void Add_Seats(){
      int x=0;
         
        try{
            connect= DbConnection.getConnection();
          for(int i=1;i<=Number_of_Seats;i++){
            query="insert into seat(Name,Check_Seat) values ('1S"+i+"','"+x+"') ";
            st=connect.createStatement();
            st.executeUpdate(query);
              }
          
       }catch(SQLException ex){
         System.out.println(ex);
       }
        
    }
}
  
