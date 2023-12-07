package Server.Facade;

import Server.GenericManager.Data;

import java.util.ArrayList;

public interface IDataEngine<T extends Data> {
	UIData get(int index);
	void addElement(T a);
}
