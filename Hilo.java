import javax.swing.JOptionPane;

public class Hilo extends Thread {

	private VentanaPrincipal ventana;
	private boolean saltando, subiendo, bajando;
    private int pasos;
    private  boolean running;
	public Hilo(VentanaPrincipal frame) {
		this.ventana=frame;		
		running= true;
		this.start();
		saltando=false;
		subiendo=false;
		bajando=false;
		pasos=0;
	}

	public void run(){
		while (running){
			ventana.moverCatus();
			if (saltando){
			pasos++;
			if (pasos>10){				
				subiendo=false;
			}
			
			if (pasos>40){				
				bajando=true;
			}
			
			
			if (pasos>50){			
				bajando=false;
				saltando=false;
				pasos=0;		
			}
				
			if (subiendo ){			
			    ventana.subirDinosaurio();				
			 }
			
			if (bajando){
				ventana.bajarDinosaurio();
			}
			
		}	
			
			if (ventana.colision()){		
				JOptionPane.showMessageDialog(null,"Te has Matao..");
				this.parar();
				ventana.estadoInicial();
				
			}	
			
			if (ventana.colision2()){		
				JOptionPane.showMessageDialog(null,"Te has Matao.. JARRRL");
				this.parar();
				ventana.estadoInicial();
				
			}	
			
			
			
	    try {
				Thread.sleep(39);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
				
	}
	
	public void parar(){
		running=false;
		
	}
	public void iniciarSalto(){
		if (!saltando){

			saltando=true;
			subiendo=true;
			
		}
	}

}
