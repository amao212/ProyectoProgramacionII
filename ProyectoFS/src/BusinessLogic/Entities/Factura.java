package BusinessLogic.Entities;

public class Factura {
    private Integer idFactura;
    private String usuarioId;
    private String clienteIdCliente;
    private String inventarioId;
    private String  estadoFactura;
    private String  totalFactura;
    private String  fechaIngresFactura;
    private String  fechaModificacionFactura;

    public Factura( Integer idFactura, 
                    String usuarioId, 
                    String clienteIdCliente, 
                    String inventarioId,
                    String estadoFactura, 
                    String totalFactura, 
                    String fechaIngresFactura, 
                    String fechaModificacionFactura) {
                        
        this.idFactura = idFactura;
        this.usuarioId = usuarioId;
        this.clienteIdCliente = clienteIdCliente;
        this.inventarioId = inventarioId;
        this.estadoFactura = estadoFactura;
        this.totalFactura = totalFactura;
        this.fechaIngresFactura = fechaIngresFactura;
        this.fechaModificacionFactura = fechaModificacionFactura;
    }

    public Integer getIdFactura() {
        return idFactura;
    }


    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public String getUsuarioId() {
        return usuarioId;
    }


    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getClienteIdCliente() {
        return clienteIdCliente;
    }


    public void setClienteIdCliente(String clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    public String getInventarioId() {
        return inventarioId;
    }


    public void setInventarioId(String inventarioId) {
        this.inventarioId = inventarioId;
    }

    public String getEstadoFactura() {
        return estadoFactura;
    }


    public void setEstadoFactura(String estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    public String getTotalFactura() {
        return totalFactura;
    }


    public void setTotalFactura(String totalFactura) {
        this.totalFactura = totalFactura;
    }


    public String getFechaIngresFactura() {
        return fechaIngresFactura;
    }

    public void setFechaIngresFactura(String fechaIngresFactura) {
        this.fechaIngresFactura = fechaIngresFactura;
    }

    
    public String getFechaModificacionFactura() {
        return fechaModificacionFactura;
    }


    public void setFechaModificacionFactura(String fechaModificacionFactura) {
        this.fechaModificacionFactura = fechaModificacionFactura;
    }





}

