package interfaces;

import java.util.Date;

public interface IControlador{
    public void altaEspectaculo(String artista, String plataforma, String nombre, String descripcion, int duracion, int cantMinEsp, int cantMaxEsp, String url, int costo, Date registro);
}
