package com.huanxin.v3.bean;

import java.util.List;

public class HXChartRecordPayload {
	private List<HXChartRecordBodies> bodies;

	public void setBodies(List<HXChartRecordBodies> bodies) {
		this.bodies = bodies;
	}

	public List<HXChartRecordBodies> getBodies() {
		return this.bodies;
	}

}