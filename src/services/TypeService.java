package services;

import java.util.List;

import model.Type;

public interface TypeService {
	public List<Type> getTypes();

	public Type getType(long id);

	public Type newType(Type type);

	public Type updateType(Type type);

	public Type deleteType(long id);
}
