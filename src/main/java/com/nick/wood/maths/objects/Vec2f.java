package com.nick.wood.maths.objects;

import java.util.Objects;

public class Vec2f {

	public static final Vec2f ZERO = new Vec2f(0.0f, 0.0f);
	public static final Vec2f X = new Vec2f(1.0f, 0.0f);
	public static final Vec2f Y = new Vec2f(0.0f, 1.0f);

	private final float x;
	private final float y;

	public Vec2f(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public Vec2f add(Vec2f vec) {
		return new Vec2f(
				this.x + vec.x,
				this.y + vec.y);
	}

	public Vec2f subtract(Vec2f vec) {
		return new Vec2f(
				this.x - vec.x,
				this.y - vec.y);
	}

	public Vec2f scale(float s) {
		return new Vec2f(
				this.x * s,
				this.y * s);
	}

	public double dot(Vec2f vec) {
		return
				this.x * vec.getX() +
				this.y * vec.getY();
	}

	public double length2() {
		return
				(this.x * this.x) +
				(this.y * this.y);
	}

	public float length() {
		return (float) Math.sqrt(length2());
	}

	public Vec2f normalise()  {
		if (this.length() == 0.0 ) {
			return Vec2f.ZERO;
		}
		return this.scale(1/this.length());
	}

	public float[] getValues() {
		return new float[] {x, y};
	}

	public Matrix4d outerProduct(Vec2f vec3d) {

		int width = 4;
		double[] elements = new double[16];

		for (int thisVecIndex = 0; thisVecIndex < this.getValues().length; thisVecIndex++) {
			for (int otherVecIndex = 0; otherVecIndex < vec3d.getValues().length; otherVecIndex++) {

				elements[thisVecIndex * 4 + otherVecIndex] = this.getValues()[thisVecIndex] * vec3d.getValues()[otherVecIndex];

			}
		}

		return new Matrix4d(elements);
	}

	public Vec2f neg() {
		return new Vec2f(
				-this.x,
				-this.y
		);
	}

	public double cross(Vec2f vec2f) {
		return (this.x * vec2f.y) - (vec2f.x * this.y);
	}

	public Vec2f midpoint(Vec2f vec2f) {
		float x = (vec2f.x + this.x)/2;
		float y = (vec2f.y + this.y)/2;
		return new Vec2f(x, y);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Vec2f vec2d = (Vec2f) o;
		return Double.compare(vec2d.x, x) == 0 &&
				Double.compare(vec2d.y, y) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}
