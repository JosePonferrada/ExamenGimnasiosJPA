package examenGimnasiosJPA.drivers;

import examenGimnasiosJPA.DriverGeneral;

public class DriverGimnasio extends DriverGeneral{
	
	private static DriverGimnasio controlador = null;

	public DriverGimnasio () {
		super(DriverGeneral.class, "IDK");
	}

}
