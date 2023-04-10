import java.io.*;

public class crearfactura {

    static double []acumtot = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
    static int []contot = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    public void Menu(String men[], double precios[]) throws IOException{

        double []acum = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        int []cont = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        double totala = 0;
        int me = 0;
        boolean condi = true;

        BufferedReader lc = new BufferedReader(new InputStreamReader(System.in));

        InicializarVar(acum, cont);

        while(condi){
            System.out.println("\t\t\t\t\t\t\tIngrese la opcion que desea: \n\n\t\t\t\t\t\t\t1. Agregar producto a la factura\n\t\t\t\t\t\t\t2. Imprimir factura\n\t\t\t\t\t\t\t3. Terminar factura y regresar");
            me = Integer.parseInt(lc.readLine());
            
            if(me==1){
                Factura(acum, cont, men, precios);
            }
            else if(me==2){
                imprimirFactura(acum, cont, totala, men);
            }
            else if(me== 3){
                totala = 0;
                condi = false;
            }
            else{
                System.out.println("\t\t\t\t\t\t\tVALOR NO VALIDA. Ingreselo ");
            }

        }
    }//FIN DE CLASE DE MENU

    public void InicializarVar(double ac[], int ct[]){
        for(int i = 0; i<9; i++){
            ac[i] = 0;
            ct[i] = 0;
        }
    }//FIN DE LA INICIALIZACION DE LOS ACUMULADORES MENORES

    public void imprimirMenu(String men[], double preci[]){
        System.out.println("\t\t\t\t\t\t\t----------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t\t\t    MENU");

        System.out.println("\t\t\t\t\t\t\t----------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t\t\t Productos");
        System.out.println("\t\t\t\t\t\t\t----------------------------------------------\n");
        for(int i=0; i<9; i++){
            System.out.printf("\t\t\t\t\t\t\t%d. %s----------%.2f            \n",(i+1), men[i], preci[i]);
        }

    }//FIN DE IMPRIMIR MENU PRINCIPAL

    public void imprimirAdicionales(String men[], double preci[]){
        System.out.println("\t\t\t\t\t\t\t----------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t\t  Ingredientes adicionales");
        System.out.println("\t\t\t\t\t\t\t----------------------------------------------\n");
        for(int i= 9; i<12; i++){
            
            System.out.printf("\t\t\t\t\t\t\t%d. %s----------%.2f            \n",(i+1), men[i], preci[i]);
        }
    }//FIN DE IMPRIMIR ADICIONALES

    public void Factura(double ac[], int ct[], String menn[], double prc[]) throws IOException{
        int desi = 0, des= 0, j=0, ad = 0, a=0, adi=0;
        boolean cond = true, condi2 = true;

        BufferedReader lc = new BufferedReader(new InputStreamReader(System.in));
        
        imprimirMenu(menn, prc);
        imprimirAdicionales(menn, prc);

        while(cond){
            System.out.println("\n\n\t\t\t\t\t\t\tIngrese el numero del producto que desea agregar: ");
            desi = Integer.parseInt(lc.readLine());

            if(desi > 9 || desi<1){
                System.out.println("\n\n\t\t\t\t\t\t\tEsta opcion no es valida, ingrese una opcion entre 1 y 9");
            }
            else{
                j = desi - 1;
                while(condi2){
                    System.out.println("\n\n\t\t\t\t\t\t\tIngrese la cantidad de "+menn[j]+" que desea comprar: ");
                    des = Integer.parseInt(lc.readLine());
    
                    if(des<=0){
                        System.out.println("\n\n\t\t\t\t\t\t\tEsta opcion no es valida, ingrese una opcion mayor a 0");
                    }
                    else{
                        ct[j] = ct[j] + des;
                        contot[j] = contot[j]+ct[j];
                        ac[j] = ac[j] + (prc[j]*des);
                        if(j != 0 && j!= 1){
                            acumtot[j] = acumtot[j] + ac[j];
                        }
                        cond = false;
                        condi2 = false;

                    }
                }
            }
        }

        if(desi == 1 || desi==2){
            System.out.println("\n\t\t\t\t\t\t\tDesea agregar un ingrediente adicional?\n\t\t\t\t\t\t\t1. Si \n\t\t\t\t\t\t\t2. No");
            ad = Integer.parseInt(lc.readLine());

            if(ad == 1){
                cond = true;
                while(cond){
                    if(des> 1 && desi==1){
                        System.out.println("\n\t\t\t\t\t\t\tA cuantos "+menn[j]+" desea agregarle ingrediente adicional?: ");
                    }
                    else if(des > 1 && desi==2){
                        System.out.println("\n\t\t\t\t\t\t\tA cuantas "+menn[j]+" desea agregarle ingrediente adicional?: ");
                    }

                    adi = Integer.parseInt(lc.readLine());//LECTURA DE LA CANTIDAD DE PRODUCTOS A LOS QUE SE LES DESEA AGREGAR INGREDIENTE ADICIONAL

                    if(adi<=0){
                        System.out.println("\n\n\t\t\t\t\t\t\tEsta opcion no es valida, ingrese una opcion mayor a 0");
                    }
                    else if(adi>des){
                        System.out.println("\n\n\t\t\t\t\t\t\tERROR. Esta comprando una cantidad de "+menn[j]+" menor a lo que desea ingresarle adicionales");
                    }
                    else{
                        cond = false;
                    }
                }
                
                des = adi;
                
                if(des>=1){
                    cond = true;
                    while(cond && des !=0){
                        imprimirAdicionales(menn, prc);
                        System.out.println("\n\n\t\t\t\t\t\t\tIngrese el numero del adicional que desea agregar: ");
                        desi = Integer.parseInt(lc.readLine());
                        
                        if(desi < 10 || desi>12){
                            System.out.println("\n\n\t\t\t\t\t\t\tEsta opcion no es valida, ingrese una opcion entre 10 y 12");
                        }
                        else{
                            a = desi - 1;
                            ac[j]= ac[j] + prc[a];
                            //acumtot[j] = acumtot[j] + ac[j];
                            des-=1;
                            //cond = false;
                        } 
                    }
                    acumtot[j] = acumtot[j] + ac[j];
                }
            }
        }

    }//FIN DE CLASE FACTURA

    public void imprimirFactura(double ac[], int ct[], double total, String men[]) {

        System.out.printf("\t\t\t\t\t\t\t  Productos             Cantidad             Acumulado\n");
        
        for(int i=0; i<9; i++){
            total = total + ac[i];

            System.out.printf("\n\t\t\t\t\t\t\t   %s             %d             %.2f\n",men[i],ct[i],ac[i]);
        }
        System.out.println("\t\t\t\t\t\t\t----------------------------------------------\n");
        System.out.printf("\t\t\t\t\t\t\tEl total de esta factura es: %.2f\n", total);
        System.out.println("\t\t\t\t\t\t\t----------------------------------------------\n");
        
    }//FIN DE CLASE DE IMPRIMIR FACTURA
}
