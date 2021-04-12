package com.vti.academy.entity;

public class Car {
	private String name;
	private String type;
	private Engine engine;

	
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public class Engine {

		private String engineType;
		public String name;
		public String type;

		public String getEngineType() {
			return engineType;
		}

		public void setEngineType(String engineType) {
			this.engineType = engineType;
		}
		@Override
		public String toString() {
			return engineType;
		}
	}
	public static void main(String[] args) {
		Car.Engine car = new Car().new Engine();
		car.engineType = "Crysler";
		car.name = "Mazda";
		car.type = "8WD";
	}
}
