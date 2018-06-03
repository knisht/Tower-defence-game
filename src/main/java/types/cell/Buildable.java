package types.cell;

import core.GameObject;
import core.primitive.Point;

public interface Buildable<T extends GameObject> {
	void build(T target);

	Point getPoint();
}
