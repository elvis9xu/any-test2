package com.xjd.test.any.base.bytes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class ObdDriverHabitRedisBean {
	
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
    
    public String getDriverTrace() {
		return driverTrace;
	}

	public void setDriverTrace(String driverTrace) {
		this.driverTrace = driverTrace;
	}

	public String getObdTerminal() {
		return obdTerminal;
	}

	public void setObdTerminal(String obdTerminal) {
		this.obdTerminal = obdTerminal;
	}

	public Long getBreakCnt() {
		return breakCnt;
	}

	public void setBreakCnt(Long breakCnt) {
		this.breakCnt = breakCnt;
	}

	public Long getAccelaCnt() {
		return accelaCnt;
	}

	public void setAccelaCnt(Long accelaCnt) {
		this.accelaCnt = accelaCnt;
	}

	public Double getAvgSpeed() {
		return avgSpeed;
	}

	public void setAvgSpeed(Double avgSpeed) {
		this.avgSpeed = avgSpeed;
	}

	public Double getMinSpeed() {
		return minSpeed;
	}

	public void setMinSpeed(Double minSpeed) {
		this.minSpeed = minSpeed;
	}

	public Double getMaxOil() {
		return maxOil;
	}

	public void setMaxOil(Double maxOil) {
		this.maxOil = maxOil;
	}

	public Double getMinOil() {
		return minOil;
	}

	public void setMinOil(Double minOil) {
		this.minOil = minOil;
	}

	public Double getAvgOil() {
		return avgOil;
	}

	public void setAvgOil(Double avgOil) {
		this.avgOil = avgOil;
	}

	public Double getMaxAccela() {
		return maxAccela;
	}

	public void setMaxAccela(Double maxAccela) {
		this.maxAccela = maxAccela;
	}

	public Double getMinAccela() {
		return minAccela;
	}

	public void setMinAccela(Double minAccela) {
		this.minAccela = minAccela;
	}

	public Double getMileage() {
		return mileage;
	}

	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(Double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public Double getDrivingTime() {
		return drivingTime;
	}

	public void setDrivingTime(Double drivingTime) {
		this.drivingTime = drivingTime;
	}

	public Double getEnginWorkTime() {
		return enginWorkTime;
	}

	public void setEnginWorkTime(Double enginWorkTime) {
		this.enginWorkTime = enginWorkTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Long getOverspeedCnt() {
		return overspeedCnt;
	}

	public void setOverspeedCnt(Long overspeedCnt) {
		this.overspeedCnt = overspeedCnt;
	}

	public Double getOverspeedTime() {
		return overspeedTime;
	}

	public void setOverspeedTime(Double overspeedTime) {
		this.overspeedTime = overspeedTime;
	}

	public Long getOverspeed2Cnt() {
		return overspeed2Cnt;
	}

	public void setOverspeed2Cnt(Long overspeed2Cnt) {
		this.overspeed2Cnt = overspeed2Cnt;
	}

	public Double getOverspeed2Time() {
		return overspeed2Time;
	}

	public void setOverspeed2Time(Double overspeed2Time) {
		this.overspeed2Time = overspeed2Time;
	}

	public Double getIdleTime() {
		return idleTime;
	}

	public void setIdleTime(Double idleTime) {
		this.idleTime = idleTime;
	}

	public Double getHotTime() {
		return hotTime;
	}

	public void setHotTime(Double hotTime) {
		this.hotTime = hotTime;
	}

	public Double getAccelerateMileage() {
		return accelerateMileage;
	}

	public void setAccelerateMileage(Double accelerateMileage) {
		this.accelerateMileage = accelerateMileage;
	}

	public Double getBreakMileage() {
		return breakMileage;
	}

	public void setBreakMileage(Double breakMileage) {
		this.breakMileage = breakMileage;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getGps() {
		return gps;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Long getVerId() {
		return verId;
	}

	public void setVerId(Long verId) {
		this.verId = verId;
	}

	public Integer getHabitType() {
		return habitType;
	}

	public void setHabitType(Integer habitType) {
		this.habitType = habitType;
	}

	public static void copyBeanFields(Object from, Object to) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
    	Field[] fromFields = from.getClass().getFields();
    	Field[] toFields = to.getClass().getFields();
    	
    	for (int i = 0; i < fromFields.length; i++) {
			String fromFieldName = fromFields[i].getName();
			for (int j = 0; j < toFields.length; j++) {
				String toFieldsName = toFields[j].getName();
				if(toFieldsName.equals(fromFieldName)) {
					String getMethodName = "get" + fromFieldName.substring(0, 1).toUpperCase() + fromFieldName.substring(1);
					Method fromMethod = from.getClass().getDeclaredMethod(getMethodName);
					
					Object returnObj = fromMethod.invoke(from);
					
					if(returnObj != null) {
						String setMethodName = "set" + toFieldsName.substring(0, 1).toUpperCase() + toFieldsName.substring(1);
						Method toMethod = to.getClass().getDeclaredMethod(setMethodName, toFields[j].getType());
						
						toMethod.invoke(to, returnObj);
					}
				}
			}
		}
    }
	
//	public static void main(String[] args) {
//		ObdDriverHabit a = new ObdDriverHabit();
//		a.setAccelaCnt(123L);
//		ObdDriverHabitRedisBean b = new ObdDriverHabitRedisBean();
//		
//		try {
//			copyBeanFields(a, b);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(b.getAccelaCnt());
//	}
    
}
