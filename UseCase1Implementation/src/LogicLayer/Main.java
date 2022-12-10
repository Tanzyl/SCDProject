package LogicLayer;

import java.awt.EventQueue;

import PresentationLayer.InsertingData;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertingData frame = new InsertingData();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
