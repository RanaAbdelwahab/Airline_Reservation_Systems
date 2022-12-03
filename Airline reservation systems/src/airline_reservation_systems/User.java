/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline_reservation_systems;

import java.sql.*;

public class User {
    Connection connect;
    String query;
    Statement st;
    ResultSet r;
    public boolean checkUsername(String username){
       boolean check;
       try{
            connect= DbConnection.getConnection();
            query="select Username from user where Username='"+username+"'";
            st=connect.prepareStatement(query);
            r=st.executeQuery(query);
         
            check = r.next();
            
          
       }catch(SQLException ex){
         check= false;
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
       
       return check;
   }
   public boolean checkPassword(String pass,String username){
       boolean check;
       try{
            connect= DbConnection.getConnection();
            query="select Password from user where Password='"+pass+"' and Username='"+username+"'";
            st=connect.prepareStatement(query);
            r=st.executeQuery(query);
         
            check = r.next();
          
       }catch(SQLException ex){
         check= false;
       }
       return check;
   }
    public boolean CheckRegistration(String Fname , String Lname,String Username , String Password , 
            String DOB, String Address, String Country , String Mobile){
         boolean check;
       try{
            connect= DbConnection.getConnection();
            query="insert into user(FirstName,LastName,Username,Password,DOB,address,Country,Mobile) values ('"+Fname+"','"+Lname+"','"+Username+"','"+Password+"','"+DOB+"','"+Address+"','"+Country+"','"+Mobile+"')";
            st=connect.createStatement();
            int result=st.executeUpdate(query);
          
            if(result!=0){
                check=true;
            }
            else {
                check=false;
            }
          
          
       }catch(SQLException ex){
         check= false;
       }
       return check;
    }
    
}
