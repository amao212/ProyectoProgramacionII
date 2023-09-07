package BusinessLogic.Entities;

public class Usuario {
    private Integer idUsuario;  
    private String credencial,
     password,
     nombre,
     apellido,
     cedula,
     estado,
     fechaIngreso,
     fechaModificacion;
     public Usuario(Integer idUsuario , 
                    String credencial,
                    String password,
                    String nombre,
                    String apellido,
                    String cedula,
                    String estado,
                    String fechaIngreso,
                    String fechaModificacion){
            this.idUsuario =idUsuario;
            this.credencial = credencial;
            this.password = password;
            this.nombre = nombre;
            this.apellido = apellido;
            this.cedula = cedula;
            this.estado = estado;
            this.fechaIngreso = fechaIngreso;
            this.fechaModificacion = fechaModificacion;

     }



    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getCredencial() {
        return credencial;
    }
    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }







}