/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline.reservation.systems;

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
   public boolean checkPassword(int pass,String username){
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
}
