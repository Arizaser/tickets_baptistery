/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package venta_entradas;

import java.util.Scanner;

/**
 *
 * @author marizase
 */
public class Main {

    public static void main(String[] args) {
        Machine mch = new Machine();
        Scanner sc = new Scanner(System.in);
        int tickets;
        int money;

        System.out.println("BIENVENIDO AL ANTIGUO BAPTISTERIO ROMANO DEL SIGLO PRIMERO");
        while (mch.todaysTicketsLeft() > 0) {
            System.out.println("¿Cúantas entradas quieres?");
            tickets = sc.nextInt();
            if (tickets <= mch.todaysTicketsLeft()) {
                System.out.println("Introduce el importe exacto");
                money = sc.nextInt();
                mch.buyTickets(tickets, money);
            }else{
                System.out.println("Número de entradas invalido");
            }
            
            mch.showTicketsSoldPerDay();
        }
        System.out.println("Ya se han vendido todas las entradas de hoy. Vuelve mañana temprano.");
    }
}
