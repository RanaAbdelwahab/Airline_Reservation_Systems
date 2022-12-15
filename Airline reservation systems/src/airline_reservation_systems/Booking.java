/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline_reservation_systems;

import java.sql.*;

public class Booking implements Runnable{
    Connection connect;
    String query;
    Statement st;
    ResultSet r;
    String Seat_Name,Username,Source,Destination,Payment_Method;
    int Card_Id;
    double Cost;
    static boolean out = false;
    public Booking(String Seat_Name, String Username, String Source, String Destination, double Cost, String Payment_Method, int Card_Id){
        try {
            connect = DbConnection.getConnection();
            this.Seat_Name = Seat_Name;
            this.Username = Username;
            this.Source = Source;
            this.Destination = Destination;
            this.Cost = Cost;
            this.Payment_Method = Payment_Method;
            this.Card_Id = Card_Id;
        } catch (SQLException ex) {
           System.out.println(ex);
        }
    }
    @Override
    public void run() {
      
       try {
            Seats seat = new Seats();
            int Id = GetId(Seat_Name);
            boolean  Validate = seat.validateSeat(Seat_Name,Id);
            
            if (Validate) {

               int UserId = getUserId(Username);

               if (Id != 0) {
                   query = "insert into reservation(Seat_id,Username,Source,Destination,Cost,Payment_Method,Card_id,User_id) values ('" + Id + "','" + Username + "','" + Source + "','" + Destination + "','" + Cost + "','" + Payment_Method + "','" + Card_Id + "','" + UserId + "')";
                   st = connect.createStatement();
                   st.executeUpdate(query);
                   out = true;

               } else {
                   out = false;
               }

           } else {
               out = false;
           }

       } catch (SQLException ex) {
           
            System.out.println(ex);
        } 
    }
    
    
    public static boolean getCheck(){
        return out;
    }
     public int GetId(String Name){
       int Id=0;
       try{
        
            String idQuery ="Select id from seat where seat.Name ='"+Name +"'";
            Statement statement= connect.prepareStatement(idQuery);
            r=statement.executeQuery(idQuery);
            if(r.next()){
                Id=r.getInt("id");
            }
           }catch(SQLException ex){
               System.out.println(ex);
       }
       return Id;
     }
     
    public int getUserId(String Name){
       int Id=0;
       try{
        
            String idQuery ="Select id from user where user.Username ='"+Name +"'";
            Statement statement= connect.prepareStatement(idQuery);
            r=statement.executeQuery(idQuery);
            if(r.next()){
                Id=r.getInt("id");
            }
           }catch(SQLException ex){
               System.out.println(ex);
       }
       return Id;
     }
    
}
