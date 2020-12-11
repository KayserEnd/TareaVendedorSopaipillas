import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import java.lang.Math;

public class TestVendedorSopaipillas {
    int sopaipas=100;
    int totalCaja;
    //el detalle de caja guarda cada tipo de moneda o billete de acuerdo a lo siguiente:
    //[0]=100;[1]=500;[2]=1000;[3]=2000;[4]=5000;[5]=10000;[6]=20000
    int [] detalleCaja=new int[7];
    int costo=100;
    @Before public void starter(){
        for (int i=0;i<7;i++)
            this.detalleCaja[i]=(int) (Math.random()*10);
        this.totalCaja=this.detalleCaja[0]*100+this.detalleCaja[1]*500+this.detalleCaja[2]*1000+this.detalleCaja[3]*2000+this.detalleCaja[4]*5000+this.detalleCaja[5]*10000+this.detalleCaja[6]*20000;

    }
    @Test public void testContarCaja(){
        int [] monedas={100,500,1000,2000,5000,10000,20000};
        int total=0;
        for (int i=0;i<7;i++)
            total+=this.detalleCaja[i]*monedas[i];
        VendedorSopaipillas sopaipa=new VendedorSopaipillas();
        sopaipa.setDetalleCaja(this.detalleCaja);
        assertEquals(total,sopaipa.contarCaja());
    }
    @Test public void testDarVuelto(){
        VendedorSopaipillas tester=new VendedorSopaipillas();
        int [] recibido=new int[7];
        for (int i=0;i<7;i++)
            recibido[i]=(int)(Math.random()*10);
        int vuelto=recibido[0]*100+recibido[1]*500+recibido[2]*1000+recibido[3]*2000+recibido[4]*5000+recibido[5]*10000+recibido[6]*20000-400;
        int []vueltoRealDetalle=tester.darVuelto(recibido,400);
        int vueltoReal=vueltoRealDetalle[0]*100+vueltoRealDetalle[1]*500+vueltoRealDetalle[2]*1000+vueltoRealDetalle[3]*2000+vueltoRealDetalle[4]*5000+vueltoRealDetalle[5]*10000+vueltoRealDetalle[6]*20000;
        assertEquals(vueltoReal,vuelto);
    }
    @After public void Finisher(){
        System.out.println("Testeo completo");
    }
}
