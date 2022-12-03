/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package airline_reservation_systems;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AirlineReservationSystems {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Register reg = new Register();
        reg.setTitle("Registration Form");
        reg.setVisible(true);
        reg.setResizable(false);*/

        int cores=Runtime.getRuntime().availableProcessors()+1;
        System.out.println(cores);
        ExecutorService excutor = Executors.newFixedThreadPool(cores);
        Runnable threadPool1 = new Booking("1S1", "nermeen899", "Dubai", "Egypt", 10000, "Visa", 1234);
        excutor.execute(threadPool1);
        Runnable threadPool2 = new Booking("1S1", "rana674", "Egypt", "Dubai", 10000, "Visa", 1234);
        excutor.execute(threadPool2);
        Runnable threadPool3 = new Booking("1S2", "rana674", "Egypt", "Dubai", 10000, "Visa", 1234);
        excutor.execute(threadPool3);
        Runnable threadPool4 = new Booking("1S2", "rana674", "Egypt", "Dubai", 10000, "Visa", 1234);
        excutor.execute(threadPool4);
       
        excutor.shutdown();
    }
     
}