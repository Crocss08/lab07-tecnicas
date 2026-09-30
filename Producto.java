import java.math.BigDecimal;

/**
 * Representa un producto en el sistema de inventario.
 */
public class Producto {

    // Atributos privados (Encapsulación)
    private Long id;
    private String codigoBarras;
    private String nombre;
    private String categoria;
    private BigDecimal precioCompra;
    private BigDecimal precioVenta;
    private int stockActual;
    private int stockMinimo;

    // Constructor sin parámetros (útil para frameworks o instanciación vacía)
    public Producto() {
    }

    // Constructor completo para inicializar un producto existente
    public Producto(Long id, String codigoBarras, String nombre, String categoria, 
                    BigDecimal precioCompra, BigDecimal precioVenta, int stockActual, int stockMinimo) {
        this.id = id;
        this.codigoBarras = codigoBarras;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
    }

    // Constructor sin ID (útil para crear un nuevo producto antes de guardarlo en la Base de Datos)
    public Producto(String codigoBarras, String nombre, String categoria, 
                    BigDecimal precioCompra, BigDecimal precioVenta, int stockActual, int stockMinimo) {
        this.codigoBarras = codigoBarras;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    // Método de utilidad para verificar alertas de stock
    public boolean requiereReabastecimiento() {
        return this.stockActual <= this.stockMinimo;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", codigoBarras='" + codigoBarras + '\'' +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precioVenta=" + precioVenta +
                ", stockActual=" + stockActual +
                '}';
    }
}