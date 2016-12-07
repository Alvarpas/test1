/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/**
 *
 * @author JesT
 */
public class Principal 
{
    public static void main(String[] args)
    {
        GestionBD gbd = new GestionBD();
        gbd.conectar();
        //gbd.insertar();
        gbd.leer();
    }
    
}
