package myPackage;

public class Accounts {
@Lingquan
private String accountname;
private int passcode;
private String type;

public Accounts(){};

public Accounts(String accountname,int passcode,String type)
{
	super();
	this.accountname=accountname;
	this.passcode=passcode;
	this.type=type;
}
@Lingquan
public boolean Accountscheck(String accountname,int passcode,String type)
{
if (this.accountname.equals(accountname)&&this.passcode==passcode&&this.type.equals(type))
{return true;}
else return false;
	}


public static void main(String[] args) {
	
}

public String getName () {
	return accountname;
}
public void setName(String na) {
	accountname = na;
}
public void setPasscode(int pc) {
	passcode = pc;
}

public int getPasscode(){
	return passcode;
}
public String getType(){
	return type;
}
public void setType(String tp){
	type = tp;
}
}
