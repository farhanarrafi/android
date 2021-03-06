package aiub.eatl.farhan.contactdatabase;

public class Contact {
	
	private int _id;
	private String _name;
	private String _phone_number;
	
	public Contact() {
		
	}
	
	public Contact(int _id, String _name, String _phone_number) {
		this._id = _id;
		this._name = _name;
		this._phone_number = _phone_number;
	}
	
	public Contact(String _name, String _phone_number) {
		this._name = _name;
		this._phone_number = _phone_number;
	}
	
	public int getID() {
		return this._id;
	}
	
	public void setID(int _id) {
		this._id = _id;
	}
	
	public String getName() {
		return this._name;
	}
	
	public void setName(String _name) {
		this._name = _name;
	}
	
	public String getPhone_number() {
		return this._phone_number;
	}
	
	public void setPhone_number(String _phone_number) {
		this._phone_number = _phone_number;
	}
}
