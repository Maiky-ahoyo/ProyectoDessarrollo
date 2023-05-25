package isiunison.space.bd.CRUD;

import isiunison.space.bd.utilerias.ConectorBD;

import javax.swing.*;
import java.sql.*;

public class AgregarUsuarios {
    private static Connection conexion;
    private static PreparedStatement sentenciaPreparada;

    public void registroUsuario(String usuario, String password, String permisos){
        String nPassword= String.valueOf(password.hashCode());
        int us=usuario.hashCode();
        int pa=password.hashCode();
        if(!(us==0 || pa==0)){
            try {
                conexion=ConectorBD.getInstance();
                String consulta="INSERT INTO usuarios (usuario,password,permisos) VALUES (?,?,?)";
                sentenciaPreparada=conexion.prepareStatement(consulta);
                sentenciaPreparada.setString(1,usuario);
                sentenciaPreparada.setString(2,nPassword);
                sentenciaPreparada.setString(3,permisos);
                int i=sentenciaPreparada.executeUpdate();
                if(i>0){
                    JOptionPane.showMessageDialog(null,"Datos guardados");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al guardar datos, intente de nuevo");
                System.out.println("Error: "+e);
            }
        } else  {
            JOptionPane.showMessageDialog(null,"Por favor, ingrese los datos");
        }
    }
}
