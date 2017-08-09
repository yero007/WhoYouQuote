package whoyouquote.yero007.com.whoyouquote.data;

public class ObjectNameValuePair {

	protected String name;
	protected Object value;

	public ObjectNameValuePair(String name, Object value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public Object getValue() {
		return value.toString();
	}
}
