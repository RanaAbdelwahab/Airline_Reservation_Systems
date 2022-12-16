/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package airline_reservation_systems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AirlineReservationSystems {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Register reg = new Register();
        reg.setTitle("Registration Form");
        reg.setVisible(true);
        reg.setResizable(false);

        
        //The below code just for testing multithreading
        
        /*int cores=Runtime.getRuntime().availableProcessors()+1;
        System.out.println(cores);
        ExecutorService excutor = Executors.newFixedThreadPool(cores);
        Runnable threadPool1 = new Booking("1S16", "nermeen899", "Egypt", "Egypt", 10000, "Visa", 12);
        excutor.execute(threadPool1);
        Runnable threadPool2 = new Booking("1S16", "haidy56", "Egypt", "Dubai", 10000, "Visa", 34);
        excutor.execute(threadPool2);
        Runnable threadPool3 = new Booking("1S16", "nour917", "Egypt", "Dubai", 10000, "Visa", 56);
        excutor.execute(threadPool3);
        Runnable threadPool4 = new Booking("1S16", "rana674", "Egypt", "Dubai", 10000, "Visa", 78);
        excutor.execute(threadPool4);
        Runnable threadPool5 = new Booking("1S16", "rana674", "Egypt", "Dubai", 10000, "Visa", 9);
        excutor.execute(threadPool5);
        Runnable threadPool6 = new Booking("1S16", "rana674", "Egypt", "Dubai", 10000, "Visa", 10);
        excutor.execute(threadPool6);
        Runnable threadPool7 = new Booking("1S16", "rana674", "Egypt", "Dubai", 10000, "Visa", 11);
        excutor.execute(threadPool7);
      
        excutor.shutdown();*/
       
       
    }
     
}