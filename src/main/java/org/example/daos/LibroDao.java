package org.example.daos;

import org.example.beans.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibroDao  extends BaseDao{
    public ArrayList<Libro> listar() throws SQLException{
        ArrayList<Libro> lista = new ArrayList<Libro>();
        String sql = "SELECT id_libro,titulo,autor,anio_publicacion FROM libro ORDER BY titulo";
        try(Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();){
            while(rs.next()){
                Libro l = new Libro();
                l.setId_libro(rs.getInt("id_libro"));
                l.setTitulo(rs.getString("titulo"));
                l.setAutor(rs.getString("autor"));
                l.setAnio_publlicacion(rs.getInt("anio_publicacion"));
                lista.add(l);
            }
            return lista;
        }
    }
}
