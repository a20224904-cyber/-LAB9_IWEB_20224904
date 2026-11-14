package org.example.daos;

import org.example.beans.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao extends BaseDao{
    public boolean registrar(String nombres, String apellidos,String email,String password_hash) throws SQLException {
        String sql= "INSERT INTO usuario"+"(nombres,apellidos,email,password_hash,rol,estado)"+"VALUES(?,?,?,SHA2(?,256),'LECTOR','ACTIVO')";
        try(Connection conexion=this.getConnection()){
            PreparedStatement pst=conexion.prepareStatement(sql);
            pst.setString(1,nombres);
            pst.setString(2,apellidos);
            pst.setString(3,email);
            pst.setString(4,password_hash);
            pst.executeUpdate();
            return true;
        } catch(SQLException e){
            return false;
        }
    }

    public Usuario validarPassword(String email, String password_hash) throws SQLException {
        String sql= "SELECT id_usuario,nombres,apellidos,email,rol,estado "+"FROM usuario "+"WHERE email=? AND password_hash=SHA2(?,256)=? AND estado='ACTIVO'";
        try(Connection conexion=this.getConnection()){
            PreparedStatement pst=conexion.prepareStatement(sql);
            pst.setString(1,email);
            pst.setString(2,password_hash);

            try(ResultSet rs=pst.executeQuery()){
                if(rs.next()){
                    Usuario u = new Usuario();
                    u.setId_usuario(rs.getInt("id_usuario"));
                    u.setNombres(rs.getString("nombres"));
                    u.setApellidos(rs.getString("apellidos"));
                    u.setEmail(rs.getString("email"));
                    u.setRol(rs.getString("rol"));
                    u.setEstado(rs.getString("estado"));
                    return u;
                }
            }
        }
        return null;
    }
}
