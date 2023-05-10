package komponenten.listen;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

public class StadtTemperaturModel2 extends AbstractListModel<StadtTemperatur> {

	private ArrayList<StadtTemperatur> liste = new ArrayList<StadtTemperatur>();

	public void add(StadtTemperatur st) {
		int index = liste.size();
		liste.add(st);
		fireIntervalAdded(this, index, index);
	}

	public StadtTemperatur remove(int index) {
		StadtTemperatur tmp = liste.remove(index);
		fireIntervalRemoved(this, index, index);
		return tmp;
	}

	@Override
	public StadtTemperatur getElementAt(int index) {
		return liste.get(index);
	}

	@Override
	public int getSize() {
		return liste.size();
	}

}
