package komponenten.listen;

import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.EventListenerList;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class StadtTemperaturModel implements ListModel<StadtTemperatur> {

	private ArrayList<StadtTemperatur> liste = new ArrayList<StadtTemperatur>();

	private ArrayList<ListDataListener> listener = new ArrayList<ListDataListener>();

	public void add(StadtTemperatur st) {
		liste.add(st);
		setChanged();
	}

	public StadtTemperatur remove(int index) {
		StadtTemperatur tmp = liste.remove(index);
		setChanged();
		return tmp;
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		listener.add(l);
	}

	@Override
	public StadtTemperatur getElementAt(int index) {
		return liste.get(index);
	}

	@Override
	public int getSize() {
		return liste.size();
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		listener.remove(l);
	}

	private void setChanged() {
		ListDataEvent e = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, liste.size() - 1);
		for (ListDataListener l : listener) {
			l.contentsChanged(e);
		}
	}

}
