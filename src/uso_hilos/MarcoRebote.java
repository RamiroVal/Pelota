package uso_hilos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MarcoRebote extends JFrame{
	
	private LaminaPelota lamina;
	
	public MarcoRebote() {
		super("Rebotes");
		setSize(400, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		lamina = new LaminaPelota();
		add(lamina, BorderLayout.CENTER);
		
		laminaInferior();
		
		
	}
	
	public void laminaInferior() {
		JPanel laminaBotones = new JPanel();
		
		JButton btnCorrer = new JButton("Correr");
		JButton btnSalir = new JButton("Salir");
		
		laminaBotones.add(btnCorrer);
		laminaBotones.add(btnSalir);
		
		add(laminaBotones, BorderLayout.SOUTH);
		
		btnCorrer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comienzaJuego();
				
			}
		});
		
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
	}
	
	public void comienzaJuego() {
		Pelota pelota = new Pelota();
		lamina.add(pelota);
		
		Runnable r = new PelotaHilos(pelota, lamina);
		
		Thread t = new Thread(r);
		t.start();
		
	}
	
	public static void main(String[] args) {
		new MarcoRebote().setVisible(true);
	}

}
