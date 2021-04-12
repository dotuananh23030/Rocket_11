package com.vti.academy.backend;

public class CPU {
	private double price;
	
	public class Processor{
		private int coreAmount;
		private String menuFacturer;
		public double getCache() {
			return 4.3;
		}
		
		public int getCoreAmount() {
			return coreAmount;
		}
		
		public String getMenuFacturer() {
			return menuFacturer;
		}
	}
	
	public class Ram{
		private int memory;
		private String menufacturer;
		public double getClockSpeed() {
			return 5.5;
		}
		
		public int getMemory() {
            return memory;
        }

        public String getManufacturer() {
            return menufacturer;
        }
	}
	public static void main(String[] args) {
		CPU.Processor cpu = new CPU().new Processor();
		cpu.getCache();
		CPU.Ram cpu1 = new CPU().new Ram();
		cpu1.getClockSpeed();
	}
	
	
}
