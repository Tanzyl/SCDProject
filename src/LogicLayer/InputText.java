package LogicLayer;
import PresentationLayer.Window;
public class InputText {
	public static void main(String[] args) {
		UrduString data=new UrduString();
		Window.showWindow(data);
		while(true)		{System.out.print(data.getTxt()+"\n");}
	}
	
}
