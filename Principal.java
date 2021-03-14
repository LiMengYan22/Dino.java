import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lblDinosaurio;
	private JLabel lblCactus1;
	private JLabel lblCactus2;
	private JLabel lblNube;
	private JLabel lblNube2;
	private JLabel lblLand;
	private JLabel lblSprite;
	private JLabel lblPuntos;	
	private JLabel Puntos;	
	private static Hilo hilo;
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();					
					frame.setVisible(true);
					hilo=  new Hilo(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {	
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {				
//				switch (arg0.getKeyCode()){ 
//				case KeyEvent.VK_RIGHT:
//					lblDinosaurio.setLocation(lblDinosaurio.getX()+5, lblDinosaurio.getY());
//					break;
//				case KeyEvent.VK_LEFT:
//					lblDinosaurio.setLocation(lblDinosaurio.getX()-5, lblDinosaurio.getY());
//					break;
//				case KeyEvent.VK_UP:
//					lblDinosaurio.setLocation(lblDinosaurio.getX(),lblDinosaurio.getY()-78);
//					break;
//				case KeyEvent.VK_DOWN:
//					lblDinosaurio.setLocation(lblDinosaurio.getX(),lblDinosaurio.getY()+5);
//					break;
//				
//				}	
				
				if (arg0.getKeyCode()==KeyEvent.VK_SPACE){
				hilo.iniciarSalto();
				}
				}
			
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		lblDinosaurio = new JLabel();
		lblDinosaurio.setIcon(new ImageIcon("img\\dino.png"));
		lblDinosaurio.setBounds(460, 150, 78, 81);
		contentPane.add(lblDinosaurio);		
		
		lblCactus1 = new JLabel();
		lblCactus1.setIcon(new ImageIcon("img\\cactus1.png"));
		lblCactus1.setBounds(800, 175, 38, 45);
		contentPane.add(lblCactus1);
			
		lblCactus2 = new JLabel();
		lblCactus2.setIcon(new ImageIcon("img\\cactus2.png"));
		lblCactus2.setBounds(260, 178, 40, 40);
		contentPane.add(lblCactus2);	
		
		lblNube = new JLabel();
		lblNube.setIcon(new ImageIcon("img\\nube.png"));
		lblNube.setBounds(560, 20, 78, 81);
		contentPane.add(lblNube);
		
		lblNube2 = new JLabel();
		lblNube2.setIcon(new ImageIcon("img\\nube2.png"));
		lblNube2.setBounds(330, 30, 55, 99);
		contentPane.add(lblNube2);
		
		lblLand = new JLabel();
		lblLand.setIcon(new ImageIcon("img\\Land.png"));
		lblLand.setBounds(550, 555, 55, 99);
		contentPane.add(lblLand);
		
		JLabel lblPoints = new JLabel("Points");
		lblPoints.setBounds(828, 30, 46, 14);
		contentPane.add(lblPoints);
					
		/**
		 * ICONORRRRL
		 */
		ImageIcon ii = new ImageIcon ("img/dino.png");
		Image image = ii.getImage();
		this.setIconImage(image);
	}

	public void moverCatus() {
		lblCactus1.setLocation(lblCactus1.getX()-5, lblCactus1.getY());		
		lblCactus2.setLocation(lblCactus2.getX()-6, lblCactus2.getY());
		lblNube.setLocation(lblNube.getX()-5, lblNube.getY());
		lblNube2.setLocation(lblNube2.getX()-6, lblNube2.getY());
		lblLand.setLocation(lblLand.getX()-7, lblLand.getY());
		if (lblCactus1.getX()+lblCactus1.getWidth()<0){
			lblCactus1.setLocation(1000, lblCactus1.getY());
		}
		if (lblCactus2.getX()+lblCactus2.getWidth()<0){
			lblCactus2.setLocation(1000, lblCactus2.getY());
		
		}
		if (lblNube.getX()+lblNube.getWidth()<0){
			lblNube.setLocation(1000, lblNube.getY());
		}
		if (lblNube2.getX()+lblNube2.getWidth()<0){
			lblNube2.setLocation(1000, lblNube2.getY());
		}
		if (lblLand.getX()+lblLand.getWidth()<0){
			lblLand.setLocation(2000, lblLand.getY());
		
	}
		
	}
	public void subirDinosaurio() {
		lblDinosaurio.setLocation(lblDinosaurio.getX(), lblDinosaurio.getY()-11);
		
		}
	public void bajarDinosaurio() {
		lblDinosaurio.setLocation(lblDinosaurio.getX(), lblDinosaurio.getY()+11);
		}

	public boolean colision() {
	    if (lblCactus1.getX()< lblDinosaurio.getX()+lblDinosaurio.getWidth() 
	    && lblDinosaurio.getX()< lblCactus1.getX()+lblCactus1.getWidth() 
	    && lblDinosaurio.getY()+lblDinosaurio.getHeight() > lblCactus1.getY()){   
	    return true;
	}
	    return false;
	}

	
	
	public boolean colision2() {
	    if (lblCactus2.getX()< lblDinosaurio.getX()+lblDinosaurio.getWidth() 
	    && lblDinosaurio.getX()< lblCactus2.getX()+lblCactus1.getWidth() 
	    && lblDinosaurio.getY()+lblDinosaurio.getHeight() > lblCactus2.getY()){    
	    return true;
	}
	    return false;
	}

	
	public void estadoInicial() {
	    lblDinosaurio.setLocation(460, 150);
	    lblCactus1.setLocation(800, 175);
	    lblCactus2.setLocation(260, 178);
	    lblLand.setLocation(1000, 125);
	    hilo= new Hilo (this); 
	    int Puntos = 0;
	    
	
	}
	
//	public void cambiarSpriteDinosaurio(){
//		sprite++;
//		sprite=sprite%2;
//		lblDinosaurio.setIcon(spriteDinosaurio.get(sprite));
//		lblCactus.setIcon(spritesEnemigo.get(sprite));
//	}
	public void actualizarPuntos(){
		Puntos++;
		lblPuntos.setText(Puntos+"");
		
		public int getPuntos(){
			return Puntos;
		}
		
	
		
	}
}	
	
