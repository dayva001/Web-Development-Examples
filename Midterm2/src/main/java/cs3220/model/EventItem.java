package cs3220.model;
import jakarta.validation.constraints.NotBlank;

public class EventItem {
	
	@NotBlank
	private String name;
	private int amount;
	private String bringer;
	private static int idSeed=0;
	private final int id;
	
	public EventItem(String name, int amount)
	{
		id = idSeed++;
		this.name = name;
		this.amount = amount;
	}
	public EventItem(String name, int amount, String bringer)
	{
		id = idSeed++;
		this.name = name;
		this.amount = amount;
		this.bringer = bringer;
	}
	public String getBringer() {
		return bringer;
	}
	public void setBringer(String bringer) {
		this.bringer = bringer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getId()
	{
		return id;
	}
	

}
