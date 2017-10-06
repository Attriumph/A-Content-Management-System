package myPackage;


/**
 * @author  yjin
 */
public class Component {
	private String name;
	private String brand;
	private double weight;
	
	Component(){
		super();
	}
	Component(double wt, String na, String br) {
		super();
		name = na;
		weight = wt;
		brand = br;
	}
	/**
	 * @return  the name
	 * @uml.property  name="name"
	 */
	public String getName () {
		return name;
	}
	/**
	 * @param name  the name to set
	 * @uml.property  name="name"
	 */
	public void setName(String na) {
		name = na;
	}
	/**
	 * @return  the brand
	 * @uml.property  name="brand"
	 */
	public String getBrand () {
		return brand;
	}
	/**
	 * @param brand  the brand to set
	 * @uml.property  name="brand"
	 */
	public void setBrand(String br) {
		brand = br;
	}
	/**
	 * @return  the weight
	 * @uml.property  name="weight"
	 */
	public double getWeight(){
		return weight;
	}
	/**
	 * @param weight  the weight to set
	 * @uml.property  name="weight"
	 */
	public void setWeight(double wt){
		weight = wt;
	}

}
