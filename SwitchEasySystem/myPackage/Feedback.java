package myPackage;


/**
 * @author  Lingquan
 */
public class Feedback {
	private String ID;
	private String Part;
	private String Revision;
	private String Reason;
	private String Solution;
	
	Feedback(){
		super();
	}
	Feedback(String id, String pt, String rv,String r,String sl) {
		super();
		ID = id;
		Part = pt;
		Revision = rv;
		Reason=r;
		Solution=sl;
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
	public String getPart () {
		return Part;
	}
	/**
	 * @param brand  the brand to set
	 * @uml.property  name="brand"
	 */
	public void setPart(String pt) {
		Part = pt;
	}
	/**
	 * @return  the weight
	 * @uml.property  name="weight"
	 */
	public String getRevision(){
		return Revision;
	}
	
	public void setRevision(String rv){
		Revision = rv;
	}
	
	public String getReason(){
		return Reason;
	}
	
	public void setReason(String r){
		Reason = r;
	}
	public String getSolution(){
		return Solution;
	}
	
	public void setSolution(String sl){
		Solution = sl;
	}

}
