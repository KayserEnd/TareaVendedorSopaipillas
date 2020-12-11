public class EjemploSopaipillas {
    public static void main(String[] args) {
        VendedorSopaipillas miVendedor=new VendedorSopaipillas();
        int [] detalle={100,100,100,100,100,100,100};
        int totalCaja;
        miVendedor.setDetalleCaja(detalle);
        miVendedor.setSopaipas(1000);
        totalCaja=miVendedor.contarCaja();
        System.out.println("se tiene "+totalCaja+" clp en la caja");
        int tamannoVenta=miVendedor.vender();
        int valorVenta=tamannoVenta*100;
        int [] cobro=miVendedor.cobrar(valorVenta);
        totalCaja=miVendedor.contarCaja();
        System.out.println("se tiene "+totalCaja+" clp en la caja");
        int []vuelto=miVendedor.darVuelto(cobro,100*tamannoVenta);
        int totalVuelto=vuelto[0]*100+vuelto[1]*500+vuelto[2]*1000+vuelto[3]*2000+vuelto[4]*5000+vuelto[5]*10000+vuelto[6]*20000;
        System.out.println("se dio un vuelto de "+totalVuelto+"clp, en "+vuelto[0]+" monedas de 100, "+vuelto[1]+" monedas de 500, "+vuelto[2]+" billetes de 1000");
        System.out.println(vuelto[3]+" billetes de 2000, "+vuelto[4]+" billetes de 5000, "+vuelto[5]+" billetes de 10000"+vuelto[6]+" billetes de 20000");
    }
}
