package uso_hilos;

import java.awt.Component;

public class PelotaHilos implements Runnable{

	private Pelota pelota;
	private Component componente;
	
	public PelotaHilos(Pelota pelota, Component componente) {
		this.pelota = pelota;
		this.componente = componente;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 3000; i++) {
			pelota.muevePelota(componente.getBounds());
			componente.paint(componente.getGraphics());
			
			try {
				Thread.sleep(4);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
