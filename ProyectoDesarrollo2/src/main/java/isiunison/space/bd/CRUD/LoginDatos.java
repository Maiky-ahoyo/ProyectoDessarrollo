package isiunison.space.bd.CRUD;

import isiunison.space.bd.pantallas.Login;
import isiunison.space.bd.utilerias.ConectorBD;

import javax.swing.*;
import java.sql.*;

public class LoginDatos {

    private static Connection conexion;
    private static PreparedStatement sentenciaPreparada;
    private static ResultSet resultado;

    public static void consultarUsuario(String usuario,String password){
        String nPassword= String.valueOf(password.hashCode());
        String mensaje=null;
        try {
            conexion=ConectorBD.getInstance();
            String consulta="SELECT usuario,password FROM usuarios WHERE usuario=? && password=?";
            sentenciaPreparada=conexion.prepareStatement(consulta);
            sentenciaPreparada.setString(1,usuario);
            sentenciaPreparada.setString(2,nPassword);
            resultado=sentenciaPreparada.executeQuery();
            if(resultado.next()){
                Login.setPermisos(getPermisos(usuario,password));
            } else {
                mensaje="Por favor, revise sus datos";
                JOptionPane.showMessageDialog(null,mensaje);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Por favor, revise sus datos");
            System.out.println("Error: "+e);
        }
    }

    public static String getPermisos(String usuario,String password){
        String permisos = null;
        String nPassword= String.valueOf(password.hashCode());
        try {
            conexion=ConectorBD.getInstance();
            String consulta="SELECT permisos FROM usuarios WHERE usuario=? && password=?";
            sentenciaPreparada=conexion.prepareStatement(consulta);
            sentenciaPreparada.setString(1,usuario);
            sentenciaPreparada.setString(2,nPassword);
            resultado=sentenciaPreparada.executeQuery();
            if(resultado.next()){
                permisos=resultado.getString("permisos");
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return permisos;
    }
}
