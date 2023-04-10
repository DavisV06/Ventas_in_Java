public class consultasVentas {

    public void montoActividad(String prod[]) {
        double totaltodo = 0;
        double []porc = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        double []montos = crearfactura.acumtot;

        System.out.println("\t\t\t\t\t\t\t----------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t\t MONTO VENDIDO DE LA ACTIVIDAD");
        System.out.println("\t\t\t\t\t\t\t----------------------------------------------\n");
        System.out.printf("\t\t\t\t  Productos                            Monto total por producto               Porcentaje de aporte\n");

        for(int i=0; i<9; i++){
            totaltodo = totaltodo + montos[i];
        }
        for(int i=0; i<9;i++){
            porc[i] = (montos[i]/totaltodo)*100;
        }

        for(int i=0; i<9; i++){
            if(i == 4){
                System.out.printf("\n\t\t\t\t   Combo de hotdog\n\t\t\t\t   (Hotdog, soda y papitas)                        %.2f                             %.2f%%\n",montos[i], porc[i]);
            }
            else if(i==5){
                System.out.printf("\n\t\t\t\t   Combo de Hamburguesa\n\t\t\t\t   (Hamburguesa, soda y papitas)                   %.2f                             %.2f%%\n",montos[i], porc[i]);
            }
            else{
                System.out.printf("\n\t\t\t\t   %s                    %.2f                             %.2f%%\n",prod[i],montos[i], porc[i]);
            }
        }
        System.out.println("\t\t\t\t\t\t\t----------------------------------------------\n");
        System.out.printf("\t\t\t\t\t\t\tEl monto total de la venta es: %.2f\n", totaltodo);
        System.out.println("\t\t\t\t\t\t\t----------------------------------------------\n");
    }
    
    
}
