import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class kcalc555 {
    private static JFrame janela;
    private static JList<String> lista;
    private static JTextField r1,r2, c1;
    private static JLabel nom1,nom2,nom3, saida1, saida2, coder;
    private static JButton botao;
    private static JPanel l1,l2,l3,l4,l5,l6;
    private static JCheckBox tempo;
    public static void main(String[] args) {
	String[] modo = {"astavel","monoestavel"};
	
	janela = new JFrame("kcalc555");
	lista = new JList<String>(modo);
	r1 = new JTextField();
	r2 = new JTextField();
	c1 = new JTextField();
	nom1 = new JLabel("res 1");
	nom2 = new JLabel("res 2");
	nom3 = new JLabel("capac");
	coder = new JLabel("by kodo no kami");
	botao = new JButton("calcular");
	l1 = new JPanel();
	l2 = new JPanel();
	l3 = new JPanel();
	l4 = new JPanel(); 
	saida1 = new JLabel("t (alto): ");
	saida2 = new JLabel("t (baixo): ");
	tempo = new JCheckBox("tempo");
	
	janela.setLayout(null);
	janela.setBounds(200,200,450,250);
	janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
	
	lista.setBounds(30,10,100,35);
	r1.setBounds(55,50,150,25);
	r2.setBounds(55,80,150,25);
	c1.setBounds(55,110,150,25); 
	nom1.setBounds(10,50,40,25);
	nom2.setBounds(10,80,40,25);
	nom3.setBounds(10,110,40,25);
	botao.setBounds(50,150,100,30);
	
	saida1.setForeground(Color.red);
	saida1.setBounds(230,120,500,20);
	saida2.setForeground(Color.blue);
	saida2.setBounds(230,140,500,20);

	l1.setBackground(Color.red);
	l1.setBounds(250,20,3,80);
	l2.setBackground(Color.red);
	l2.setBounds(250,20,65,4);
	l3.setBackground(Color.blue);
	l3.setBounds(315,20,3,80);
	l4.setBackground(Color.blue);
	l4.setBounds(315,98,65,4);
	
	coder.setBounds(140,190,200,20);
	coder.setForeground(Color.gray);
	
	tempo.setBounds(140,10,100,20);
	
	tempo.addChangeListener(new ChangeListener() {
	    @Override
	    public void stateChanged(ChangeEvent arg0) {
		if(tempo.isSelected()){
		    nom3.setText("seg");
		    saida1.setText("capacitor: ");
		    saida2.setVisible(false);
		}
		else{
		    nom3.setText("capac");
		    saida1.setText("t (alto): ");
		    saida2.setVisible(true);
		}
	    }
	});
	
	lista.addListSelectionListener(new ListSelectionListener() {
	    @Override
	    public void valueChanged(ListSelectionEvent arg0) {
		if(lista.getSelectedValue() == "astavel"){
		    r2.setVisible(true);
		}
		else{
		    r2.setVisible(false);
		}
	    }
	});
	
	botao.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent arg0) {
		if(!tempo.isSelected()){
		    if(lista.getSelectedValue() == "astavel"){
			double equAlto = Math.log(2) * (Integer.parseInt(r1.getText()) + Integer.parseInt(r2.getText())) * Float.parseFloat(c1.getText()); 
			saida1.setText(String.format("t (alto): %f s", equAlto));
		    
			double equBaixo = Math.log(2) * Integer.parseInt(r2.getText()) * Float.parseFloat(c1.getText()); 
			saida2.setText(String.format("t (baixo): %f s", equBaixo));
		    }
		    else if(lista.getSelectedValue() == "monoestavel"){
		    	double equAlto = 1.1 * Integer.parseInt(r1.getText()) * Float.parseFloat(c1.getText()); 
		    	saida1.setText(String.format("t (alto): %f s", equAlto));
		    	saida2.setText("t (baixo): 0 s");
		    }
		}
		else{
		    if(lista.getSelectedValue() == "astavel"){
			double equAlto = Float.parseFloat(c1.getText()) / Math.log(2) / (Integer.parseInt(r1.getText()) + Integer.parseInt(r2.getText())); 
			saida1.setText(String.format("capacitor: %f F", equAlto));
		    }
		    else if(lista.getSelectedValue() == "monoestavel"){
		    	double equAlto = Float.parseFloat(c1.getText()) / Integer.parseInt(r1.getText()) / 1.1 ; 
		    	saida1.setText(String.format("capacitor: %f F", equAlto));
		    	saida2.setText("t (baixo): 0 s");
		    }
		}
	    }
	});
	
	janela.add(lista);
	janela.add(r1);
	janela.add(r2);
	janela.add(c1);
	janela.add(nom1);
	janela.add(nom2);
	janela.add(nom3);
	janela.add(botao);
	janela.add(l1);
	janela.add(l2);
	janela.add(l3);
	janela.add(l4);
	janela.add(saida1);
	janela.add(saida2);
	janela.add(tempo);
	janela.add(coder);
	
	janela.setVisible(true);
    }
}
