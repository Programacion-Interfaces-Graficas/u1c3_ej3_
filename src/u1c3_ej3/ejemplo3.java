package u1c3_ej3;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


public class ejemplo3 implements ItemListener{
	//Declarar variables globales privadas para ser accedidas dentro de esta clase
	private JFrame ventana;
	private JLabel etiqueta1;
	private JLabel etiqueta2;
	private JCheckBox hobbieLeer;
	private JCheckBox hobbieDeporte;
	private JCheckBox hobbieJugar;

	public ejemplo3() {
		//Crear un nuevo contenedor JFrame
		ventana=new JFrame("Ejemplo 3");
		//Especificar FlowLayout como administrador de dise;o
		ventana.getContentPane().setLayout(new FlowLayout());
		//Asignar el tamaño inicial de la ventana
		ventana.setSize(400,150);
		//Terminar el programa cuando el usuario cierre la ventana
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Crear etiquetas vacias
		etiqueta1=new JLabel("");
		etiqueta2=new JLabel("");
		//Crear casillas de verificación
		hobbieLeer=new JCheckBox("Leer novelas");
		hobbieDeporte=new JCheckBox("Hacer Deporte");
		hobbieJugar=new JCheckBox("Jugar videojuegos");
		//Los eventos generados por las casillas de verificación
		//se procesan en el método itemStateChanged()
		//Agregar escuchadores a las accion
		hobbieLeer.addItemListener(this);
		hobbieDeporte.addItemListener(this);
		hobbieJugar.addItemListener(this);
		
		//Agregar los componentes en el contenedor
		ventana.add(hobbieLeer);
		ventana.add(hobbieJugar);
		ventana.add(hobbieDeporte);
		ventana.add(etiqueta1);
		ventana.add(etiqueta2);
		
		//Mostrar la ventana
		ventana.setVisible(true);
		
	}
	public static void main(String[] args) {
		//Crea la ventana en el subproceso de entrega de eventos
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ejemplo3();
			}
			
		});

	}
	//Controlador de las casillas de verificacion 
	public void itemStateChanged(ItemEvent e) {
		//Almacenar el texto en una cadena de caracteres
		String msg="";
		//Obtener la referencia de la casilla de verificación que ha activado el evento.
		JCheckBox casilla=(JCheckBox)e.getItem();//Realizar un casting de Object a CheckBox
		//Indicar que casilla de verificacion ha cambiado
		if(casilla.isSelected()) {
			etiqueta1.setText(casilla.getText() + " Ha sido seleccionada");
		}else {
			etiqueta1.setText(casilla.getText() + " Ha sido deseleccionada");
		}
		
		//Informar de todas las casillas selecionadas
		if(hobbieLeer.isSelected()) {
			msg+="Leer novelas ";
		}else if(hobbieJugar.isSelected()) {
			msg+=" Jugar videojuegos ";
		}else if(hobbieDeporte.isSelected()) {
			msg+="Hacer Deporte ";
		}
		etiqueta2.setText("Los Hobbies seleccionados son:"+msg);
	}

	
}
