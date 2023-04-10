import java.io.*;

public class minipro{

    public static void main(String[] args) throws IOException{
        int mp = 0;
        boolean cond = true;

        String []menu = {"Hotdogs                     ", 
        "Hamburguesa                 ", 
        "Nachos con chile y queso    ", 
        "Nachos con queso            ", 
        "Combo de hotdog\n\t\t\t\t\t\t\t\t  (Hotdog, soda y papitas)     ",
        "Combo de Hamburguesa\n\t\t\t\t\t\t\t  (Hamburguesa, soda y papitas)",
        "Sodas                       ", 
        "Agua                        ", 
        "Te Frio                     ", 
        "Queso                       ", 
        "Chile                       ", 
        "Bacon                       "};
        double []precio= {2.50, 3.50, 3.50, 3.00, 4.50, 5.00, 1.50, 1.25, 1.50, 1.50, 1.50, 1.50};       
        
        BufferedReader lc = new BufferedReader(new InputStreamReader(System.in));
            
        System.out.println("\t\t\t\t\t\t\t\t   VENTA DE COMIDA Y REFRESCOS");
        while(cond){
            System.out.println("\n\n\t\t\t\t\t\t\t\t1. Ingresar una factura\n\t\t\t\t\t\t\t\t2. Consultas y monto vendido\n\t\t\t\t\t\t\t\t3. Salir del programa");
            mp = Integer.parseInt(lc.readLine());

            if(mp==1){
                //creacion de objeto para llamar al metodo externo de la clase crearFactura
                crearfactura obj1 = new crearfactura();
                obj1.Menu(menu, precio);
            }
            else if(mp==2){
                //creacion de objeto para llamar al metodo externo de la clase consultasVentas
                consultasVentas obj2 = new consultasVentas();

                obj2.montoActividad(menu);;
            }
            else if(mp ==3){
                System.out.println("Usted ha terminado su recorrido por el proyecto.");
                cond = false;
            }
            else{
                System.out.println("ERROR. Opcion no valida");
            }
        }
    }//FIN DE MAIN
}//FIN DE CLASE