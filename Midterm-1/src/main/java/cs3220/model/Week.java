package cs3220.model;

import java.util.ArrayList;
import java.util.List;

public class Week 
{
	private List<Job> jobs;
	private static int idSeed=0;
	private final int id;
	
	public Week()
	{
		id=idSeed++;
		jobs = new ArrayList<Job>();
		jobs.add(new Job("Chair Stacker"));
		jobs.add(new Job("Gardener"));
		jobs.add(new Job("Recess Buddy"));
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public int getId()
	{
		return id;
	}

	
	
	
	
}
