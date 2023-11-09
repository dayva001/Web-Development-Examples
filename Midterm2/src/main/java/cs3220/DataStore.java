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
		students.add(new Student("Belle"));
		students.add(new Student("Jake"));
		students.add(new Student("Katie"));
		students.add(new Student("Matt"));
		weeks = new ArrayList<Week>();
		addWeek();
		}
	
	public void addWeek()
	{
		Week temp = new Week();
		temp.setJobs(jobs);
		weeks.add(temp);
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
	
}
