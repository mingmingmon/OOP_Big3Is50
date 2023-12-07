package Server.Facade;

import java.util.ArrayList;

import Server.GenericManager.Manager;
import Server.GenericManager.Data;
import Server.ServerComputer;

public abstract class DataEngineImpl<T extends Data> extends Manager<T>
		implements IDataEngine<T> {
	String[] labels = null;
	public void setLabels(String[] labels) {
		this.labels = labels;
	}

	@Override
	public UIData get(int index) {
		// TODO Auto-generated method stub
		return (UIData)dataList.get(index);
	}
	public void addElement(T data) {
		dataList.add(data);
		ServerComputer.save();
	}
}