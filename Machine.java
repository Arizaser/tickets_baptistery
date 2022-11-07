/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package venta_entradas;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Tendré un menú en el que podré elegir cuántas entradas quiero 
 * El precio de la entrada es de 4 euros Se vende un máximo de 10 entradas por día 
 * Tengo que introducir el importe exacto en la máquina. Si no, se devuelve el dinero y se
 * empieza otra vez
 *
 * @author marizase
 */
public class Machine {
    private int maxTicketsPerDay = 10;
    private int ticketPrice = 4;
    private HashMap<String, Integer> ticketsSoldDay = new HashMap();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
    Date date = new Date();
    
    public Machine() {
        this.ticketsSoldDay.put(formatter.format(date), 0);
    }
    
    public int enterNumTickets(int numTickets) {
        String todaysDate = formatter.format(new Date());
        if (this.ticketsSoldDay.get(todaysDate)+numTickets > this.maxTicketsPerDay) {
            return 0;
        }
        return numTickets;
    }
    
    public int enterMoney(int money) {
        return money;
    }
    
    public void buyTickets(int numTickets, int money) {
        String todaysDate = formatter.format(new Date());
        if (this.ticketsSoldDay.get(todaysDate)+numTickets <= this.maxTicketsPerDay 
              && numTickets*this.ticketPrice == money) {
            
            this.ticketsSoldDay.put(todaysDate, this.ticketsSoldDay.get(todaysDate)+numTickets);
            System.out.println("Se te han vendido " + numTickets + " entradas.");
            
        } else {
            String returnString =  this.ticketsSoldDay.get(todaysDate) == this.maxTicketsPerDay ?
                                   "No se venden más entradas porque ya se han vendido el número máximo" : (this.ticketsSoldDay.get(todaysDate)+numTickets > this.maxTicketsPerDay ?
                                   "Has pedido más enradas de las que quedan disponibles." :
                                   "No has introducido el importe exacto para el número de entradas compradas.");
            
            System.out.println(returnString);
        }
        
    }
    
    public void showTicketsSoldPerDay() {
        for (Map.Entry<String, Integer> set :
             this.ticketsSoldDay.entrySet()) {
            System.out.println(set.getKey() + " => " + set.getValue());
        }
    }

    public int getMaxTicketsPerDay() {
        return maxTicketsPerDay;
    }
    
    public int todaysTicketsLeft(){
        String todaysDate = formatter.format(new Date());
        return this.maxTicketsPerDay - this.ticketsSoldDay.get(todaysDate);
        
    }
    
}
