package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;



public class Gantt extends PApplet
{
	ArrayList<Task> tk = new ArrayList<>();

	
	public void settings()
	{
		size(1000, 600);
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

	public void displayTasks()
	{
		colorMode(HSB);

		float y;
		float gap;
		int days = 30;

		textAlign(CENTER,CENTER);

		fill(255);
		stroke(255);
		for(int i = 1; i <= days; i++)
		{
			y = map(i,0, days + 5, 50, this.width + 50);
			textSize(15);
			text(i, y, 5);
			line(y, 25, y,  this.height);
		}

		textAlign(LEFT, CENTER);
		float rectH = 30;
		float roundEdge = 5;

		for(int i = 0; i < tk.size(); i++)
		{
			gap = map(i, 0, tk.size(), 50, height);

			stroke(255);
			fill(255);
			Task t = tk.get(i);
			text(t.getTask(), 0, gap);

			fill(map(i, 0, tk.size(), 0, 255), 255, 255);
			noStroke();

			float theStart = map(t.getStart(), 2, 30, 105, width - 100);
			float theEnd = map(t.getEnd(), 2, 30, 105, width - 100);
			rect(
					theStart,
					gap - 15,
					abs(theStart - theEnd),
					rectH,
					roundEdge
			);
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
		displayTasks();
	}


	public static void main (String...args){
		PApplet.main("ie.tudublin.Gantt");
	}
}