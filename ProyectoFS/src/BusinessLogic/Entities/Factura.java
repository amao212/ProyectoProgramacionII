package BusinessLogic.Entities;

public class Factura {
    private Integer idFactura;
    private Integer usuarioId;
    private Integer clienteIdCliente;
    private Integer inventarioId;
    private String  estadoFactura;
    private String  totalFactura;
    private String  fechaIngresFactura;
    private String  fechaModificacionFactura;

    public Factura( Integer idFactura, 
                    Integer usuarioId, 
                    Integer clienteIdCliente, 
                    Integer inventarioId,
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

    public Integer getUsuarioId() {
        return usuarioId;
    }


    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getClienteIdCliente() {
        return clienteIdCliente;
    }


    public void setClienteIdCliente(Integer clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    public Integer getInventarioId() {
        return inventarioId;
    }


    public void setInventarioId(Integer inventarioId) {
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

