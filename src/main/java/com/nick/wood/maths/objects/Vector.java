package com.nick.wood.maths.objects;

public class Vector {

	public static Vecd create(double... e) {
		switch (e.length) {
			case 2:
				return new Vec2d(e[0], e[1]);
			case 3:
				return new Vec3d(e[0], e[1], e[2]);
			default:
				throw new UnsupportedOperationException("A vector of length " + e.length + " has not been implemented yet");
		}
	}

	public static Vecd zero(int num) {
		switch (num) {
			case 2:
				return new Vec2d(0.0, 0.0);
			case 3:
				return new Vec3d(0.0, 0.0, 0.0);
			default:
				throw new UnsupportedOperationException("A vector of length " + num + " has not been implemented yet");
		}
	}
}
