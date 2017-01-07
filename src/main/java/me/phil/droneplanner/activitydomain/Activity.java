package me.phil.droneplanner.activitydomain;

/**
 * Something that you want to assign effort to.
 */
public class Activity {
	private String name;
	
	public Activity() {
	}
	
	public Activity(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
