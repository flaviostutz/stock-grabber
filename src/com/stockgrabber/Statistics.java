package com.stockgrabber;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math.stat.regression.SimpleRegression;

public class Statistics {

	private int n;
	private List<Float> values = new ArrayList<Float>();
	
	public Statistics(int n) {
		this.n = n;
	}
	
	public void addValor(float value) {
		if(values.size()>=n) {
			values.remove(0);
		}
		values.add(value);
	}
	
	public float getMedia() {
		int q = values.size();
		float sum = 0;
		for(int i=0; i<q; i++) {
			sum += values.get(i);
		}
		return sum/q;
	}

	public float getRegression() {
		SimpleRegression sr = new SimpleRegression();
		int c = 0;
		for (Float value : values) {
			sr.addData(c++, value);
		}
		if(values.size()<=1) {
			return values.get(0);
		} else {
			return (float)sr.predict(n/2);
		}
	}
	
}
