package isiunison.space.bd.pantallas;

import isiunison.space.bd.CRUD.AgregarUsuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro extends JFrame implements ActionListener {
    private JButton boton1,boton2;
    private JLabel titulo,lPassword,lUsuario,lPermisos;
    private JTextField tPassword,tUsuario,tPermisos;
    private Font fuente;

    public Registro(){
        setLayout(null);
        setTitle("Login");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 280);
        setLocationRelativeTo(null);
        setResizable(false);

        fuente=new Font("Arabella",Font.ITALIC,24);

        titulo=new JLabel("Registrarse");
        titulo.setFont(fuente);
        titulo.setBounds(135,30,215,30);
        add(titulo);

        lUsuario=new JLabel("Usuario:");
        lUsuario.setBounds(95,70,50,20);
        add(lUsuario);

        tUsuario=new JTextField("");
        tUsuario.setBounds(155,70,150,20);
        add(tUsuario);

        lPassword=new JLabel("Contraseña:");
        lPassword.setBounds(80,100,80,20);
        add(lPassword);

        tPassword=new JTextField("");
        tPassword.setBounds(165,100,150,20);
        add(tPassword);

        lPermisos=new JLabel("Permisos:");
        lPermisos.setBounds(90,130,80,20);
        add(lPermisos);

        tPermisos=new JTextField("usuario");
        tPermisos.setBounds(160,130,150,20);
        tPermisos.disable();
        add(tPermisos);

        boton1=new JButton("Volver");
        boton1.setBounds(154,160,90,20);
        boton1.addActionListener(this);
        add(boton1);

        boton2=new JButton("Registrarse");
        boton2.setBounds(142,190,115,20);
        boton2.addActionListener(this);
        add(boton2);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton1){
            dispose();
            Login l=new Login();
        }
        if(e.getSource()==boton2){
            AgregarUsuarios a = new AgregarUsuarios();
            a.registroUsuario(tUsuario.getText(), tPassword.getText(),tPermisos.getText());
        }
    }
}