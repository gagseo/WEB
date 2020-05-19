package com.el.model.vo;

public class Score {

	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	// 평균
	private double avg;
	// 등급
	// 평균점수
	// 90점 초과 : A
	// 80~90점 : B
	// 70~80점 : C
	// 60~70점 : D
	// 이하 : F
	private String grade;

	public Score() {

	}

	public Score(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		setSum();
		setAvg();
		setGrade();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return sum;
	}

	public void setSum() {
		this.sum = kor + eng + math;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg() {
		this.avg = (double) getSum() / 3;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade() {
		sum = kor + eng + math;
		avg = sum / 3;

		switch ((int) avg / 10) {
		case 10:
			grade = "A";
			break;
		// 90점 초과
		case 9:
			grade = "A";
			break;
		// 80~90점 : B
		case 8:
			grade = "B";
			break;
		// 70~80점 : C
		case 7:
			grade = "C";
			break;
		// 60~70점 : D
		case 6:
			grade = "D";
			break;
		// 이하 : F
		default:
			grade = "F";
			break;
		}
	}

	@Override
	public String toString() {
		return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum=" + sum + ", avg="
				+ avg + ", grade=" + grade + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(avg);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + eng;
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + kor;
		result = prime * result + math;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + sum;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (Double.doubleToLongBits(avg) != Double.doubleToLongBits(other.avg))
			return false;
		if (eng != other.eng)
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (kor != other.kor)
			return false;
		if (math != other.math)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sum != other.sum)
			return false;
		return true;
	}
	
	

}
