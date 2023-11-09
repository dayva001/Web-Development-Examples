package cs3220;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cs3220.model.Job;
import cs3220.model.Student;
import cs3220.model.Week;

@Component
public class DataStore 
{
	List<Week> weeks;
	List<Job> jobs;
	List<Student> students;
	public DataStore()
	{
		jobs = new ArrayList<Job>();
		jobs.add(new Job("Chair Stacker"));
		jobs.add(new Job("Gardener"));
		jobs.add(new Job("Recess Buddy"));
		students = new ArrayList<Student>();
		students.add(new Student("Belle"));
		students.add(new Student("Jake"));
		students.add(new Student("Katie"));
		students.add(new Student("Matt"));
		weeks = new ArrayList<Week>();
		addWeek();
		addWeek();
		}
	
	public void addWeek()
	{
		weeks.add(new Week());
	}

	public List<Student> getStudents() {
		return students;
	}
	
	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	
	public List<Week> getWeeks()
	{
		return weeks;
	}

	public Job getJob(int id) {
		for(int i=0;i<weeks.size();i++)
		{
			for(int j =0; j < weeks.get(i).getJobs().size();j++)
			{
				if(weeks.get(i).getJobs().get(j).getId() == id)
				{
					return weeks.get(i).getJobs().get(j);
				}
			}
		}
		return null;
	}
	public Week getWeek(int id) {
		for(int i = 0; i<weeks.size(); i++)
		{
			for(int j = 0; j < weeks.get(i).getJobs().size(); j++)
			{
				if(weeks.get(i).getId()== id)
				{
					return weeks.get(i);
				}
			}
		}
		return weeks.get(0);
	}

	public Student getStudent(int id) {
		for(int i=0; i < students.size(); i++)
		{
			if(students.get(i).getId()==id)
			{
				return students.get(i);
			}
		}
		return null;
	}

	public Week getWeekFromJobID(int id) {
			for(int i = 0; i<weeks.size(); i++)
			{
				for(int j = 0; j < weeks.get(i).getJobs().size(); j++)
				{
					if(weeks.get(i).getJobs().get(j).getId()==id)
					{
						return weeks.get(i);
					}
				}
			}
			return weeks.get(0);
		}
	
}
