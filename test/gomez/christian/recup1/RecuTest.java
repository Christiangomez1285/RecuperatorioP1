package gomez.christian.recup1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class RecuTest {

	
	
	@Test
	public void queSePuedaCrearElMontacargas(){
		Double pesomax=125.0;
		Montacargas montacargas = new Montacargas (pesomax);
		assertNotNull(montacargas);
		
	}
	
	@Test
	public void queDevuelvaElPesoDeLaCargaActual() throws NoExisteCargaException, CargaMaximaSuperadaException
	{	Double pesocarga=25.0;
		Double pesocarga2=28.0;
		Carga carga1= new Carga (pesocarga);
		Carga carga2= new Carga (pesocarga2);
		Double pesomax=125.0;
		Montacargas montacargas = new Montacargas (pesomax);
		montacargas.agregarCarga(carga1);
		montacargas.agregarCarga(carga2);
		assertEquals(montacargas.obtenerCarga(),53.0,0.01);	
	}
	
	@Test(expected =NoExisteCargaException.class)
	public void queLanceExcepcionSiNoExisteLaCarga() throws NoExisteCargaException, CargaMaximaSuperadaException
	{	
		Carga carga1= new Carga (0.0);
		Double pesomax=125.0;
		Montacargas montacargas = new Montacargas (pesomax);
		montacargas.agregarCarga(carga1);	
	}
	
	@Test
	public void queSiSeDescargaCargaLoRefleje() throws NoExisteCargaException, CargaMaximaSuperadaException {
		Double pesocarga=25.0;
		Double pesocarga2=28.0;
		Carga carga1= new Carga (pesocarga);
		Carga carga2= new Carga (pesocarga2);
		Double pesomax=125.0;
		Montacargas montacargas = new Montacargas (pesomax);
		montacargas.agregarCarga(carga1);
		montacargas.agregarCarga(carga2);
		montacargas.descargarCarga();
		assertEquals(montacargas.obtenerCarga(),0.0,0.01);
		}
	
	@Test
	public void queDevuelvaElPromedioDeCargasCompletadas() throws NoExisteCargaException, CargaMaximaSuperadaException {
		Double pesocarga=25.0;
		Double pesocarga2=20.0;
		Double pesocarga3=15.0;
		Carga carga1= new Carga (pesocarga);
		Carga carga2= new Carga (pesocarga2);
		Carga carga3= new Carga (pesocarga3);
		Double pesomax=125.0;
		Montacargas montacargas = new Montacargas (pesomax);
		montacargas.agregarCarga(carga1);
		montacargas.agregarCarga(carga2);
		montacargas.agregarCarga(carga3);
		montacargas.descargarCarga();
		assertEquals(montacargas.obtenerCargaPromedio(),20.0,0.01);
		
		}
	
	@Test (expected=CargaMaximaSuperadaException.class)
	public void queSiSeSuperaCargaMaximaMontacargasLanceUnaExcepcion() throws CargaMaximaSuperadaException, NoExisteCargaException
	{
		Double pesocarga=85.0;
		Double pesocarga2=20.0;
		Double pesocarga3=35.0;
		Carga carga1= new Carga (pesocarga);
		Carga carga2= new Carga (pesocarga2);
		Carga carga3= new Carga (pesocarga3);
		Double pesomax=125.0;
		Montacargas montacargas = new Montacargas (pesomax);
		montacargas.agregarCarga(carga1);
		montacargas.agregarCarga(carga2);
		montacargas.agregarCarga(carga3);
		
	}
	
}
