package myPackage;


/**
 
 */
public class Switch {
	private String initiator;
	private String part;
	private String reason;
	private String priority;
	private String ID;
	private String comment;
	private String supplier;
	
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	Switch(){
		super();
	}
	public Switch(String in, String id,String pt,String prior,String sp,String r,String com) {
		super();
		ID = id;
		part = pt;
		reason =r;
		priority=prior;
		initiator=in;
		comment=com;
	}
	

	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String prior) {
		this.priority = prior;
	}
	public String getID() {
		return ID;
	}
	public void setID(String id) {
		ID = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getInitiator () {
		return initiator;
	}
	
	public void setInitiator(String inior) {
		initiator = inior;
	}
	
	public String getPart () {
		return part;
	}
	
	public void setPart(String pat) {
		part = pat;
	}
	

}
