package myPackage;


/**
 * @author  Lingquan
 */
public class Order {
	private String ID;
	private String Priority;
	private String Quantity;
	private String Supplier;
	private String Link;
	
	
	Order(){
		super();
	}
	Order(String id, String pri, String qu,String sp,String l) {
		super();
		ID = id;
		Priority = pri;
		Quantity = qu;
		Supplier=sp;
		Link=l;
	}
	/**
	 * @return  the name
	 * @uml.property  name="name"
	 */
	public String getID () {
		return ID;
	}
	/**
	 * @param name  the name to set
	 * @uml.property  name="name"
	 */
	public void setID(String id) {
		ID = id;
	}
	/**
	 * @return  the brand
	 * @uml.property  name="brand"
	 */
	public String getPriority () {
		return Priority;
	}
	/**
	 * @param brand  the brand to set
	 * @uml.property  name="brand"
	 */
	public void setPriority(String pri) {
		Priority = pri;
	}
	/**
	 * @return  the weight
	 * @uml.property  name="weight"
	 */
	public String getQuantity(){
		return Quantity;
	}
	
	public void setQuantity(String qu){
		Quantity = qu;
	}
	
	public String getSupplier(){
		return Supplier;
	}
	
	public void setSupplier(String sp){
		Supplier = sp;
	}
	public String getLink(){
		return Link;
	}
	
	public void setLink(String l){
		Link = l;
	}

}
