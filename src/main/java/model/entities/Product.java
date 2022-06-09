package model.entities;

public class Product {
	
	private Long productId;
	private String name;
	private Double price;
	private boolean comprado;
	
	public Product(Long productId, String name, Double price, boolean comprado) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.comprado = comprado;
	}
	
	public Long getProductId() {
		return productId;
	}
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public boolean isComprado() {
		return comprado;
	}
	
	public void setComprado(boolean comprado) {
		this.comprado = comprado;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((productId == null) ? 0 : productId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (productId == null) {
            if (other.productId != null)
                return false;
        } else if (!productId.equals(other.productId))
            return false;
        return true;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
    public String comprado() {
    	return comprado ? "<font color=#3CB371>" + "Sim" + "<font color=\"black\">" : "<font color=#FF0000>" + "Não" + "<font color=\"black\">";
    }
}
