package cs3220.model;

import jakarta.validation.constraints.NotBlank;

public class Job {

	@NotBlank
	protected String name;
	protected Student student;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	private static int idSeed=0;
	private final int id;
	
	public Job(String name)
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
