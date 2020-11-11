package com.itshixun.dao;

import java.util.List;

import com.itshixun.pojo.Car;

public interface CarDao {
	public int checkCar(Car car);
	public void addCar(Car car);
	public int showCarNum(String userid);
	public double showCarPrice(String userid);
	 public List<Car> findCar(String userid);
	 public void addCarNum(Car car);
	 public void reduceCarNum(Car car);
	 public int deleteAllCar(String userid);
	 public int deleteCar(String userid,String menuname);
	 public Car showCarBy(String userid,String menuname);

}
