package gomez.christian.recup1;

import java.util.HashSet;
import java.util.Set;

public class Montacargas {
	
	private Double pesomax;
	private Carga carga1;
	private Set <Carga> cargas;
	private Set <Carga> cargascompletadas;
	
	public Montacargas (Double pesomax)
	{
		
		this.pesomax=pesomax;
		this.cargas=new HashSet<>();
		this.cargascompletadas=new HashSet<>();
	}

	public void agregarCarga(Carga carga) throws NoExisteCargaException,CargaMaximaSuperadaException{
		Double cargaTotal=0.0;
		if(carga.getPesocarga().equals(0.0))
		{
			throw new NoExisteCargaException();
			
		}
		else
		{
			this.cargas.add(carga);
			for (Carga cargaRecorrer : cargas)
			{
				cargaTotal+=cargaRecorrer.getPesocarga();
				if(cargaTotal>this.pesomax)
				{
					throw new CargaMaximaSuperadaException();
				}
			}
		}
	}

	public Double obtenerCarga() {
		Double cargaTotal=0.0;
		for (Carga cargaRecorrer : cargas)
		{
			cargaTotal+=cargaRecorrer.getPesocarga();
			
			
		}
		return cargaTotal;
	}

	public void descargarCarga() {
		this.cargascompletadas.addAll(cargas);
		this.cargas.removeAll(cargas);
		Double cargaTotal=0.0;
	
	}

	public Double obtenerCargaPromedio() {
		Double cargaPromedio=0.0;
		Integer cantidadDeCargas=0;
		Double cargaTotal=0.0;
		cantidadDeCargas=this.cargascompletadas.size();
		for(Carga cargaRecorrer : cargascompletadas)
		{
			cargaTotal+=cargaRecorrer.getPesocarga();
			cargaPromedio=cargaTotal/cantidadDeCargas;
			
			
		}
		return cargaPromedio;
		
	}
	
	

	
}
