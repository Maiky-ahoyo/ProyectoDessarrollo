package isiunison.space.bd.pantallas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Usuario extends JFrame implements ActionListener {
    private JButton bLogin,bSalir,bModificar;
    private Font fuente1;
    private JPanel pUsuario;

    public Usuario() {
        setLayout(new BorderLayout());
        setTitle("Administrador");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setResizable(false);

        fuente1=new Font("Arabella",Font.ITALIC,24);

        bLogin=new JButton("Login");
        bLogin.setFont(fuente1);
        bLogin.setBounds(10,10,100,30);
        bLogin.addActionListener(this);
        add(bLogin);

        bSalir=new JButton("Salir");
        bSalir.setFont(fuente1);
        bSalir.setBounds(185,10,90,30);
        bSalir.addActionListener(this);
        add(bSalir);

        pUsuario=new JPanel();
        pUsuario.setLayout(null);
        add(pUsuario,BorderLayout.CENTER);

        bModificar=new JButton("Modificar");
        bModificar.setFont(fuente1);
        bModificar.setBounds(72,60,150,30);
        bModificar.addActionListener(this);
        pUsuario.add(bModificar);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bLogin){
            dispose();
            Login l=new Login();
        }
        if(e.getSource()==bSalir){
            System.exit(0);
        }
        if(e.getSource()==bModificar){
            ModificarUsuario.setClase(String.valueOf(getClass()));
            dispose();
            ModificarUsuario mu=new ModificarUsuario();
        }
    }
}
