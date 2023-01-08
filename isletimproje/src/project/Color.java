package project;
import java.util.ArrayList;

	public class Color {
		
	    private ArrayList<String> colors = new ArrayList<>();
	    private int count = 9;
	    public Color() {
	        colors.add("\u001B[35m");
	        colors.add("\u001B[30m");
	        colors.add("\u001B[31m");
	        colors.add("\u001B[32m");
	        colors.add("\u001B[33m");
	        colors.add("\u001B[34m");
	        colors.add("\u001B[35m");
	        colors.add("\u001B[36m");
	        colors.add("\u001B[37m");
	        colors.add("\u001B[35m");
	        colors.add("\u001B[30m");
	        colors.add("\u001B[31m");
	        colors.add("\u001B[32m");
	        colors.add("\u001B[33m");
	        colors.add("\u001B[34m");
	        colors.add("\u001B[35m");
	        colors.add("\u001B[36m");
	        colors.add("\u001B[37m");
	        colors.add("\u001B[35m");
	        colors.add("\u001B[30m");
	        colors.add("\u001B[31m");
	        colors.add("\u001B[32m");
	        colors.add("\u001B[33m");
	        colors.add("\u001B[34m");
	        colors.add("\u001B[35m");
	        colors.add("\u001B[36m");
	        colors.add("\u001B[37m");
	        colors.add("\u001B[35m");
	        colors.add("\u001B[30m");
	        colors.add("\u001B[31m");
	        colors.add("\u001B[32m");
	        colors.add("\u001B[33m");
	        colors.add("\u001B[34m");
	        colors.add("\u001B[35m");
	        colors.add("\u001B[36m");
	        colors.add("\u001B[37m");
	        colors.add("\u001B[35m");
	        colors.add("\u001B[30m");
	        colors.add("\u001B[31m");
	        colors.add("\u001B[32m");
	        colors.add("\u001B[33m");
	        colors.add("\u001B[34m");
	        colors.add("\u001B[35m");
	        colors.add("\u001B[36m");
	        colors.add("\u001B[37m");
	        colors.add("\u001B[35m");
	        colors.add("\u001B[30m");
	        colors.add("\u001B[31m");
	        colors.add("\u001B[32m");
	        colors.add("\u001B[33m");
	        colors.add("\u001B[34m");
	        colors.add("\u001B[35m");
	        colors.add("\u001B[36m");
	        colors.add("\u001B[37m");
	        colors.add("\u001B[35m");
	        colors.add("\u001B[30m");
	        colors.add("\u001B[31m");
	        colors.add("\u001B[32m");
	        colors.add("\u001B[33m");
	        colors.add("\u001B[34m");
	        colors.add("\u001B[35m");
	        colors.add("\u001B[36m");
	        colors.add("\u001B[37m");
	        colors.add("\u001B[35m");
	        colors.add("\u001B[30m");
	        colors.add("\u001B[31m");
	        colors.add("\u001B[32m");
	        colors.add("\u001B[33m");
	        colors.add("\u001B[34m");
	        colors.add("\u001B[35m");
	        colors.add("\u001B[36m");
	        colors.add("\u001B[37m");
	    }

	    public String getColor(){
//	        int randm = (int) (Math.random() * count);
//	        String send = colors.get(randm);
//	        colors.remove(randm);
//	        count--;
	        return colors.remove(0);
	    }
	}