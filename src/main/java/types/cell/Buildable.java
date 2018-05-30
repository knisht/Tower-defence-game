package types.cell;

import core.GameObject;

public interface Buildable<T extends GameObject> {
	void build(T target);

	double getX();

	double getY();
}
