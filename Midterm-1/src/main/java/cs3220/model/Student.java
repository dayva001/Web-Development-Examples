package cs3220.model;
import jakarta.validation.constraints.NotBlank;

public class Student {
	
	@NotBlank
	protected String name;
	
	private static int idSeed=0;
	private final int id;
	
	public Student(String name)
	{
		this.name = name;
		id=idSeed++;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}


}
