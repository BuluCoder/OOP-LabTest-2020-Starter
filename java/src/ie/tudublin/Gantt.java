package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;



public class Gantt extends PApplet
{
	ArrayList<Task> tk = new ArrayList<Task>();
	
	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		Table tab = loadTable("tasks.csv", "header");
		for(TableRow tabrow:tab.rows())
		{
			Task task = new Task(tabrow);
			tk.add(task);
		}
	}

	public void printTasks()
	{
		for(Task tk:tk)
		{
				System.out.println(tk);
		}
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		loadTasks();
		printTasks();
	}
	
	public void draw()
	{			
		background(0);
	}


	public static void main (String...args){
		PApplet.main("ie.tudublin.Gantt");
	}
}