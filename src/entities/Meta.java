package entities;

public class Meta {

	public String displayName;
	public String getName(){
		return displayName;
	}
	public void say(){
		
	}
	public boolean isId;
	public boolean isReference;
	public String referencedEntityName;
	public Meta(String displayName, boolean isId, boolean isReference, String referencedEntityName) {
		super();
		this.displayName = displayName;
		this.isId = isId;
		this.isReference = isReference;
		this.referencedEntityName = referencedEntityName;
	}
	
}
