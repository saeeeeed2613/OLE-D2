package com.orange.TAMicroservice.web.model;

public class GPAGetter {

	public static float getEquvPoints(String grade) {
		
		if(grade.equalsIgnoreCase("A")) 
		{
			return getAGrade();
		}
		else if(grade.equalsIgnoreCase("B"))
		{
			return getBGrade();
		}
		else if(grade.equalsIgnoreCase("C"))
		{
			return getCGrade();
		}
		else if(grade.equalsIgnoreCase("D"))
		{
			return getDGrade();
		}
		else if(grade.equalsIgnoreCase("W"))
		{
			return getWGrade();
		}
		return 0;
	}
	private static  float getAGrade() {
		return 4.0f;
	}
	private static float getBGrade() {
		return 3.5f;
	}
	private static float getCGrade() {
		return 2.75f;
	}
	private static float getDGrade() {
		return 1.5f;
	}
	private static float getWGrade() {
		return 0f;
	}
}
