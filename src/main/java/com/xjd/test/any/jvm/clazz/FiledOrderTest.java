package com.xjd.test.any.jvm.clazz;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * @author elvis.xu
 * @since 2018-09-19 16:43
 */
public class FiledOrderTest {

	// Fields
	//
	public String driverTrace;

	// OBD终端编号
	public String obdTerminal;

	// 紧及刹车次数
	public Long breakCnt;

	// 加速次数
	public Long accelaCnt;

	// 平均速度
	public Double avgSpeed;

	// 最小速度
	public Double minSpeed;

	// 最大油耗
	public Double maxOil;

	// 最小油耗
	public Double minOil;

	// 平均油耗
	public Double avgOil;

	// 最大加速度
	public Double maxAccela;

	// 最小加速度
	public Double minAccela;

	// 行驶里程
	public Double mileage;

	// 记录时间
	public Date updateDate;

	// 最大速度
	public Double maxSpeed;

	// 驾驶时长
	public Double drivingTime;

	// 发送机工作时长
	public Double enginWorkTime;

	// 点火时间点
	public Date startTime;

	// 熄火时间点
	public Date endTime;

	// 超速次数：超速120公里/时
	public Long overspeedCnt;

	// 超速时长：超速120公里/时
	public Double overspeedTime;

	// 超速次数：超速80公里/时
	public Long overspeed2Cnt;

	// 超速时长：超速80公里/时
	public Double overspeed2Time;

	// 怠速时长
	public Double idleTime;

	// 热车时长
	public Double hotTime;

	// 紧急加速公里数
	public Double accelerateMileage;

	// 紧急刹车公里数
	public Double breakMileage;

	// 用户标识
	public Long userId;

	public String gps;

	// 车辆标识
	public Long vehicleId;

	// session Id
	public Long verId;

	// 驾驶行为类型 0:智能盒上传, 1:平台自动生成
	public Integer habitType;

	public static void main(String[] args) {
		{
			System.out.println("=======");
			Field[] fields = FiledOrderTest.class.getDeclaredFields();
			for (Field field : fields) {
				System.out.println(field.getName());
			}
		}
		{
			System.out.println("=======");
			Field[] fields = FiledOrderTest.class.getDeclaredFields();
			for (Field field : fields) {
				System.out.println(field.getName());
			}
		}
	}
}
