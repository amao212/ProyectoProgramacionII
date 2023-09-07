package BusinessLogic.Entities;

public class Inventario {

    private int    inventarioId
                   ,codigoProduto
                   ,cantidadProducto;
    private String nombreProduto
                   ,estadoProducto
                   ,fechaIngreso
                   ,fechaModificacion;

    private float  costoProducto
                   ,pvpProducto;

    

    public Inventario(int inventarioId, int codigoProduto, int cantidadProducto, String nombreProduto,
            String estadoProducto, String fechaIngreso, String fechaModificacion, float costoProducto,
            float pvpProducto) {
        this.inventarioId = inventarioId;
        this.codigoProduto = codigoProduto;
        this.cantidadProducto = cantidadProducto;
        this.nombreProduto = nombreProduto;
        this.estadoProducto = estadoProducto;
        this.fechaIngreso = fechaIngreso;
        this.fechaModificacion = fechaModificacion;
        this.costoProducto = costoProducto;
        this.pvpProducto = pvpProducto;
    }


    public String getNombreProduto() {
        return nombreProduto;
    }

    public void setNombreProduto(String nombreProduto) {
        this.nombreProduto = nombreProduto;
    }

    public String getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(String estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getInventarioId() {
        return inventarioId;
    }

    public void setInventarioId(int inventarioId) {
        this.inventarioId = inventarioId;
    }

    public float getCostoProducto() {
        return costoProducto;
    }

    public void setCostoProducto(float costoProducto) {
        this.costoProducto = costoProducto;
    }

    public float getPvpProducto() {
        return pvpProducto;
    }

    public void setPvpProducto(float pvpProducto) {
        this.pvpProducto = pvpProducto;
    }

    
    
}