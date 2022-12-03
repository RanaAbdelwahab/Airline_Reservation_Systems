/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline_reservation_systems;

import java.sql.*;
import java.util.ArrayList;

public class Seats {
    int Number_of_Seats = 20;
    public static ArrayList<String> Available_Seats = new ArrayList<String>();
    Connection connect;
    String query;
    Statement st;
    ResultSet r;
    public ArrayList<String> Get_Available_Seats(){
         try{
            int Available=0;
            connect= DbConnection.getConnection();
            Available_Seats = new ArrayList<String>();
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
    public synchronized boolean validateAndUpdateSeat(String Name ,int Seat_id) {
        boolean check = true;
        try {
            int isValiable;
            connect = DbConnection.getConnection();
            String seatQuery = "SELECT Check_Seat FROM seat WHERE Name ='" + Name+ "'";
            Statement resSeatQuery = connect.prepareStatement(seatQuery);
            r = resSeatQuery.executeQuery(seatQuery);
           if(r.next()){
               isValiable=r.getInt("Check_Seat");
               
               if (isValiable == 1) {
                for(int i=0;i<Available_Seats.size();i++){
                    if(Available_Seats.get(i).equals(Name)){
                        Available_Seats.remove(i);
                    }
                } 
                
                check=false;
            }
               else {

                   String idQuery = "update seat set Check_Seat = 1 where id = '" + Seat_id + "'";
                   Statement statement = connect.prepareStatement(idQuery);
                   int result = statement.executeUpdate(idQuery);
                   if (result != 0) {
                       check = true;
                   } else {
                       check = false;
                   }
               }
               
            }  
        } catch (SQLException ex) {
            check = false;
            System.out.println(ex);
        }
        return check;
    }
    // Function for creating Name of Seats (Just Run only one time )
    
    /*public void Add_Seats(){
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
        
    }*/
}
  
