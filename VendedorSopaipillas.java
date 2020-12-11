import java.util.Scanner;

public class VendedorSopaipillas {
    int sopaipas;
    int totalCaja;
    //el detalle de caja guarda cada tipo de moneda o billete de acuerdo a lo siguiente:
    //[0]=100;[1]=500;[2]=1000;[3]=2000;[4]=5000;[5]=10000;[6]=20000
    int [] detalleCaja=new int[7];
    int costo=100;

    public int getCosto() {
        return costo;
    }
    public int getTotalCaja() {
        return totalCaja;
    }
    public void setSopaipas(int sopaipas) {
        this.sopaipas = sopaipas;
    }
    public void setDetalleCaja(int[] detalleCaja) {
        this.detalleCaja = detalleCaja;
        this.totalCaja=detalleCaja[0]*100+detalleCaja[1]*500+detalleCaja[2]*1000+detalleCaja[3]*2000+detalleCaja[4]*5000+detalleCaja[5]*10000+detalleCaja[6]*20000;
    }
    public int getSopaipas() {
        return sopaipas;
    }
    public int[] getDetalleCaja() {
        return detalleCaja;
    }

    public int vender(){
        int n;
        Scanner pregunta=new Scanner(System.in);
        do{
            try{
                System.out.println("¿cuántas sopaipas quiere, amigo?");
                n= pregunta.nextInt();
                break;
            } catch (Exception e){
                System.out.println("no puedo vender sopaipillas por pedasos");
                pregunta.nextLine();
            }finally {
                System.out.println("...............");
            }
        }while (true);
        setSopaipas(this.sopaipas-n);
        return n;
    }
    public int[] cobrar(int precio){
        Scanner cobra=new Scanner(System.in);
        String [] tipoBillete={"monedas de 100","monedas de 500","billetes de 1000","billetes de 2000","billetes de 5000","billetes de 10000","billetes de 20000"};
        int[] billetes=new int[7];
        do{
            try{
                for (int i=0;i<7;i++){
                    System.out.println("¿Cuántos "+tipoBillete[i]+" recibe el vendedor?");
                    billetes[i]=cobra.nextInt();
                }
                int totalPago=billetes[0]*100+billetes[1]*500+billetes[2]*1000+billetes[3]*2000+billetes[4]*5000+billetes[5]*10000+billetes[6]*20000;
                if (precio>totalPago){
                    throw new IllegalArgumentException("no es suficiente plata para esa cantidad de sopaipillas");
                }
                break;
            } catch (Exception e){
                System.out.println("No puedes pagar con media moneda");
                cobra.nextLine();
            }
        }while (true);

        return billetes;
    }
    public int contarCaja(){
        int [] detalle=getDetalleCaja();
        int total=detalle[0]*100+detalle[1]*500+detalle[2]*1000+detalle[3]*2000+detalle[4]*5000+detalle[5]*10000+detalle[6]*20000;
        return total;
    }
    public int[] darVuelto(int [] recibido,int costo){
        int []detalleCaja=getDetalleCaja();
        int totalRecibido=recibido[0]*100+recibido[1]*500+recibido[2]*1000+recibido[3]*2000+recibido[4]*5000+recibido[5]*10000+recibido[6]*20000;
        int deuda=totalRecibido-costo;
        int []detalleVuelto=new int[7];
        int []valorMoneda={100,500,1000,2000,5000,10000,20000};
        for (int i=0;i<7;i++){
            detalleCaja[i]+=recibido[i];
        }
        for (int i=6;i>=0;i--){
            detalleVuelto[i]=deuda/valorMoneda[i];
            detalleCaja[i]-=detalleVuelto[i];
            deuda=deuda%valorMoneda[i];
        }
        this.detalleCaja=detalleCaja;
        return detalleVuelto;
    }
}
