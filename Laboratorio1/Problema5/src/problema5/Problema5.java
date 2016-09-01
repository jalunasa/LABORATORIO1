/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema5;
import java.util.Scanner;

/**
 *
 * @author HP-PC
 */
public class Problema5 {
    public static boolean salir=false;
 
    public static void main(String[] args) {
        
        int[][] tarjetas = new int[100][2];        
        int totalTarjetas=0;        
        int[][] sillas = new int[11][20];       
        int[][] reservas = new int[100][3];        
        int totalReservas=0;        
        int[][] ventas = new int[100][2];        
        int totalVentas=0;
        
        for(int i=0;i<11;i++)
        {
            for(int j=0;j<20;j++)
            {
               sillas[i][j]=0;
            }
        }
        
        while(!salir)
        {
            menu();
            Scanner in= new Scanner(System.in);
            int opcion=in.nextInt();
            
            switch (opcion)
            {
                case 1:
                    totalTarjetas=ventaTarjeta(tarjetas,totalTarjetas);
                    break;
                case 2:
                    recargaTarjeta(tarjetas,totalTarjetas);
                    break;
                case 3:
                    totalReservas=crearReserva(sillas,reservas,totalReservas);
                    break;
                case 4:
                    totalVentas=pagarReserva(reservas,totalReservas,ventas,totalVentas,tarjetas,totalTarjetas);
                    break;
                case 5:
                    cancelarReserva(reservas,totalReservas,sillas);
                    break;
                case 6:
                    totalVentas=ventaBoleta_SinReser(sillas,ventas,totalVentas,tarjetas,totalTarjetas);
                    break;
                case 7:
                    total_Dinero_Boletas(ventas,totalVentas);
                    break;
                case 8:
                    salir=true;
                    break;
                default:
                    opcion_error();
                    break;
            }
        }//fin while 
    } //main fin 
    
    public static int ventaTarjeta(int[][] tarjetas ,int totalTarjetas)
    {
        System.out.println("Valor a pagar 70.000");
        System.out.println("Ingrese numero de cedula del cliente");
        Scanner in= new Scanner(System.in);
        int cedula=in.nextInt();
        tarjetas[totalTarjetas][0]=cedula;
        tarjetas[totalTarjetas][1]=70000;
        totalTarjetas++;
        return totalTarjetas;
    }
    public static int  buscar_tarjeta(int[][] tarjetas ,int totalTarjetas ,int cedula)
    {
        int idx=-1;
        for(int i=0;i<totalTarjetas;i++)
        {
            if(tarjetas[i][0]==cedula)
            {
                idx=i;
                break;
            }   
        }
        return idx;
    }
    public static void recargaTarjeta(int[][] tarjetas,int totalTarjetas)
    {
        System.out.println("Valor a recargar 50.000");
        System.out.println("Ingrese numero de cedula del cliente");
        Scanner in= new Scanner(System.in);
        int cedula=in.nextInt();
        int idx=buscar_tarjeta(tarjetas,totalTarjetas,cedula);
        tarjetas[idx][1]+=50000;
    }
    public static void descontarTarjeta(int codigo,int[][] tarjetas,int totalTarjetas,int valor)
    {
        for(int i=0;i<totalTarjetas;i++)
        {
            if(tarjetas[i][0]==codigo)
            {
                tarjetas[i][1]-=valor;
                break;
            }
        }
    }

    public static int crearReserva(int[][] sillas, int[][] reservas,int totalReservas)
    {
        String fila;
        int columna;
        System.out.println("Ingrese numero de cedula del cliente");
        Scanner in= new Scanner(System.in);
        int cedula=in.nextInt();
        System.out.println("Ingrese el numero de sillas");
        in= new Scanner(System.in);
        int nSillas=in.nextInt();
        int valorTotal=0;
        for(int i=0;i<nSillas;i++)
        {
            System.out.println("Ingrese la fila a reservar");
            in= new Scanner(System.in);
            fila=in.next();
            System.out.println("Ingrese la columna");
            in= new Scanner(System.in);
            columna=in.nextInt();
            columna--;
            int valor=8000;
            int filaEntero=0;
            switch (fila)
            {
                case "A":
                    filaEntero=0;
                    break;
                case "B":
                    filaEntero=1;
                    break;
                case "C":
                    filaEntero=2;
                    break;
                case "D":
                    filaEntero=3;
                    break;
                case "E":
                    filaEntero=4;
                    break;
                case "F":
                    filaEntero=5;
                    break;
                case "G":
                    filaEntero=6;
                    break;
                case "H":
                    filaEntero=7;
                    break;
                case "I":
                    filaEntero=8;
                    valor=11000;
                    break;
                case "J":
                    filaEntero=9;
                    valor=11000;
                    break;
                case "K":
                    filaEntero=10;
                    valor=11000;
                    break;
            }
            if(sillas[filaEntero][columna]==0)
            {
                sillas[filaEntero][columna]=cedula;
                valorTotal+=valor;
            }
            else
            {
                System.out.println("silla ocupada");
                i--;
            }
        }
        reservas[totalReservas][0]=cedula;
        reservas[totalReservas][1]=nSillas;
        reservas[totalReservas][2]=valorTotal;
        System.out.println("Codigo de reserva: "+totalReservas);
        totalReservas++;
        return totalReservas;
    }
    public static int pagarReserva(int[][] reservas,int totalReservas,int[][] ventas,int totalVentas,int[][] tarjetas,int totalTarjetas)
    {
        System.out.println("pagar por:");
        System.out.println("1. Codigo Reserva");
        System.out.println("2. numero de tarjeta");
        Scanner in= new Scanner(System.in);
        int opcion=in.nextInt();
        if(opcion==1)
        {
            System.out.println("Ingrese codigo de reserva");
            in= new Scanner(System.in);
            int codigo=in.nextInt();
            return pagarReservaCodigo(reservas,totalReservas,ventas,totalVentas,codigo,tarjetas,totalTarjetas);
        }
        else if(opcion==2)
        {
            System.out.println("Ingrese numero de tarjeta");
            in= new Scanner(System.in);
            int numero=in.nextInt();
            return pagarReservaNumero(reservas,totalReservas,ventas,totalVentas,numero,tarjetas,totalTarjetas);
        }
        return totalVentas;
    }
    public static int pagarReservaCodigo(int[][] reservas,int totalReservas,int[][] ventas,int totalVentas, int codigo,int[][] tarjetas,int totalTarjetas)
    {
        System.out.println("Detalles del pago:");
        System.out.println("Cliente: "+reservas[codigo][0]);
        System.out.println("Numero Sillas: "+reservas[codigo][1]);
        System.out.println("Valor a pagar: "+(reservas[codigo][2]*0.9));
        System.out.println("Ingrese: ");
        System.out.println("1. Pagar en efectivo");
        System.out.println("2. Pagar con tarjeta");

        Scanner in= new Scanner(System.in);
        int opcion=in.nextInt();
        if(opcion==1)
        {
            ventas[totalVentas][0]=reservas[codigo][0];
            ventas[totalVentas][1]=(int) (reservas[codigo][2]*0.9);
            totalVentas++;
        }
        else
        {
            ventas[totalVentas][0]=reservas[codigo][0];
            ventas[totalVentas][1]=(int) (reservas[codigo][2]*0.9);
            descontarTarjeta(reservas[codigo][0],tarjetas,totalTarjetas,ventas[totalVentas][1]);
            totalVentas++;
        }
        return totalVentas;
    }
    public static int pagarReservaNumero(int[][] reservas,int totalReservas,int[][] ventas,int totalVentas, int numero,int[][] tarjetas,int totalTarjetas)
    {      
        int codigo=0;
        for(int i=0;i<totalReservas;i++)
        {
            if(reservas[i][0]==numero)
            {
                codigo=i;
                break;
            }
        }
        return pagarReservaCodigo(reservas,totalReservas,ventas,totalVentas,codigo,tarjetas, totalTarjetas);
    }
    public static void cancelarReserva(int[][] reservas,int totalReservas,int[][] sillas)
    {
        System.out.println("cancelar por:");
        System.out.println("1. Codigo Reserva");
        System.out.println("2. numero de tarjeta");
        Scanner in= new Scanner(System.in);
        int opcion=in.nextInt();
        if(opcion==1)
        {
            System.out.println("Ingrese codigo de reserva");
            in= new Scanner(System.in);
            int codigo=in.nextInt();
            cancelarReservaCodigo(reservas,sillas,codigo);
        }
        else if(opcion==2)
        {
            System.out.println("Ingrese numero de tarjeta");
            in= new Scanner(System.in);
            int numero=in.nextInt();
            cancelarReservaNumero(reservas,totalReservas,sillas,numero);
        }    
    }
    public static void cancelarReservaCodigo(int[][] reservas,int[][] sillas, int codigo)
    {   
        int sillasLiberadas=0;
        for(int i=0;i<12;i++)
        {
            for(int j=0;j<20;j++)
            {
                if(sillas[i][j]==reservas[codigo][0])
                {
                    sillas[i][j]=0;
                    sillasLiberadas++;
                }
                if(sillasLiberadas==reservas[codigo][1])
                {
                    break;
                }
            }
            if(sillasLiberadas==reservas[codigo][1])
            {
                break;
            }
        }
        reservas[codigo][0]=0;
        reservas[codigo][1]=0;
        reservas[codigo][2]=0;
    }
    public static void cancelarReservaNumero(int[][] reservas,int totalReservas,int[][] sillas,int numero)
    {      
        int codigo=0;
        for(int i=0;i<totalReservas;i++)
        {
            if(reservas[i][0]==numero)
            {
                codigo=i;
                break;
            }
        }
        cancelarReservaCodigo(reservas,sillas,codigo);
    }
    public static int ventaBoleta_SinReser(int[][] sillas,int[][] ventas,int totalVentas,int[][] tarjetas,int totalTarjetas)
    {
        int [] venta= new int[3];
        int [][] sillasUtilizadas;
        int columna;
        String fila;
        System.out.println("Ingrese numero de cedula del cliente");
        Scanner in= new Scanner(System.in);
        venta[0]=in.nextInt();
        System.out.println("Ingrese el numero de sillas");
        in= new Scanner(System.in);
        venta[1]=in.nextInt();
        sillasUtilizadas= new int[venta[1]][2];
        int valorTotal=0;
        for(int i=0;i<venta[1];i++)
        {
            System.out.println("Ingrese la fila a reservar");
            in= new Scanner(System.in);
            fila=in.next();
            System.out.println("Ingrese la columna");
            in= new Scanner(System.in);
            columna=in.nextInt();
            columna--;
            int valor=8000;
            int filaEntero=0;
            switch (fila)
            {
                case "A":
                    filaEntero=0;
                    break;
                case "B":
                    filaEntero=1;
                    break;
                case "C":
                    filaEntero=2;
                    break;
                case "D":
                    filaEntero=3;
                    break;
                case "E":
                    filaEntero=4;
                    break;
                case "F":
                    filaEntero=5;
                    break;
                case "G":
                    filaEntero=6;
                    break;
                case "H":
                    filaEntero=7;
                    break;
                case "I":
                    filaEntero=8;
                    valor=11000;
                    break;
                case "J":
                    filaEntero=9;
                    valor=11000;
                    break;
                case "K":
                    filaEntero=10;
                    valor=11000;
                    break;
            }
            if(sillas[filaEntero][columna]==0)
            {
                sillasUtilizadas[i][0]=filaEntero;
                sillasUtilizadas[i][1]=columna; 
                valorTotal+=valor;
            }
            else
            {
                System.out.println("silla ocupada");
                i--;
            }
        }
        venta[2]=valorTotal;
        System.out.println("Valor Total: "+venta[2]);
        System.out.println("tipo de pago:");
        System.out.println("1. Efectivo.");
        System.out.println("2. Tarjeta.");
        in= new Scanner(System.in);
        int opcion=in.nextInt();
        if(opcion==1)
        {
            return ventaBoleta_SinReserEfect(venta,sillasUtilizadas,sillas,ventas,totalVentas,tarjetas,totalTarjetas);
        }
        else if(opcion==2)
        {
            return ventaBoleta_SinReserTarj(venta,sillasUtilizadas,sillas,ventas,totalVentas,tarjetas,totalTarjetas);
        }
        
        return totalVentas;
    }//ventaBoleta_SinReser

    public static int ventaBoleta_SinReserEfect(int[] venta,int[][] sillasUtilizadas,int[][] sillas,int[][] ventas,int totalVentas,int[][] tarjetas,int totalTarjetas)
    {
        for(int i=0;i<venta[1];i++)
        {
            sillas[sillasUtilizadas[i][0]][sillasUtilizadas[i][1]]=venta[0];
        }
        int tarjeta=buscar_tarjeta(tarjetas ,totalTarjetas , venta[0]);
        if(tarjeta>-1)
        {
            venta[2]=(int) (venta[2]*0.9);
        }  
        ventas[totalVentas][0]=venta[0];
        ventas[totalVentas][1]=venta[2];
        totalVentas++;
        return totalVentas;
    }//ventaBoleta_SinReserEfect
    public static int ventaBoleta_SinReserTarj(int[] venta,int[][] sillasUtilizadas,int[][] sillas,int[][] ventas,int totalVentas,int[][] tarjetas,int totalTarjetas)
    {      
        for(int i=0;i<venta[1];i++)
        {
            sillas[sillasUtilizadas[i][0]][sillasUtilizadas[i][1]]=venta[0];
        }
        int tarjeta=buscar_tarjeta(tarjetas ,totalTarjetas , venta[0]);
        if(tarjeta>-1)
        {
            venta[2]=(int) (venta[2]*0.9);
            descontarTarjeta(tarjeta,tarjetas,totalTarjetas,venta[1]);
            ventas[totalVentas][0]=venta[0];
            ventas[totalVentas][1]=venta[2];
            totalVentas++;
        }
        return totalVentas;
    }//ventaBoleta_SinReserTarj
    public static void total_Dinero_Boletas(int[][] ventas,int totalVentas)
    {
        int Total=0;
        for (int i = 0; i < totalVentas; i++) {
            Total+=ventas[i][1];
        }
        System.out.println("Total de ventas: "+Total);
    }//total_Dinero_Boletas
    public static void menu()
    {
        System.out.println("---------- MENU----------");
        System.out.println("Digita opcion: ");
        System.out.println("1) Venta tarjeta");
        System.out.println("2) Recarga tarjeta");
        System.out.println("3) Crear reserva");
        System.out.println("4) Pagar reserva");
        System.out.println("5) Cancelar reserva");
        System.out.println("6) Venta boleta sin reserva");
        System.out.println("7) Dinero obtenido de ventas");
        System.out.println("8) Salir programa");
    }//menu

    public static void opcion_error(){
        System.out.println("Opcion erronea");
    }//error

    
}//public class Cine
