package com.fp.person.model.vo;

public class Person {
	private int pNo;
	private String pName;
	private String pJob;
	private String pBD;
	private String pNation;
	private String pFile;
	
//	배역 추가
	private String casting;
// 영화 번호 추가 
	private String movieNo;
	
	public Person() {}


	/**
	 * (관리자) 영화 상세 조회 시 사용
	 * @param pNo
	 * @param pName
	 * @param pJob
	 * @param pBD
	 * @param pNation
	 * @param pFile
	 * @param casting
	 * @param movieNo
	 * @author 수밍
	 */
	
	public Person(int pNo, String pName, String pJob, String pBD, String pNation, String pFile, String casting,
			String movieNo) {
		super();
		this.pNo = pNo;
		this.pName = pName;
		this.pJob = pJob;
		this.pBD = pBD;
		this.pNation = pNation;
		this.pFile = pFile;
		this.casting = casting;
		this.movieNo = movieNo;
	}




	public Person(int pNo, String pName, String pJob, String pBD, String pNation, String pFile) {
		super();
		this.pNo = pNo;
		this.pName = pName;
		this.pJob = pJob;
		this.pBD = pBD;
		this.pNation = pNation;
		this.pFile = pFile;
	}



	public Person(int pNo, String pName, String pJob, String pBD, String pNation, String pFile, String casting) {
		super();
		this.pNo = pNo;
		this.pName = pName;
		this.pJob = pJob;
		this.pBD = pBD;
		this.pNation = pNation;
		this.pFile = pFile;
		this.casting = casting;
	}


	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpJob() {
		return pJob;
	}

	public String getCasting() {
		return casting;
	}


	public void setCasting(String casting) {
		this.casting = casting;
	}


	public void setpJob(String pJob) {
		this.pJob = pJob;
	}

	public String getpBD() {
		return pBD;
	}

	public void setpBD(String pBD) {
		this.pBD = pBD;
	}

	public String getpNation() {
		return pNation;
	}

	public void setpNation(String pNation) {
		this.pNation = pNation;
	}

	public String getpFile() {
		return pFile;
	}

	public void setpFile(String pFile) {
		this.pFile = pFile;
	}

	

	public String getMovieNo() {
		return movieNo;
	}


	public void setMovieNo(String movieNo) {
		this.movieNo = movieNo;
	}


	@Override
	public String toString() {
		return "Person [pNo=" + pNo + ", pName=" + pName + ", pJob=" + pJob + ", pBD=" + pBD + ", pNation=" + pNation
				+ ", pFile=" + pFile + ", casting=" + casting + "]";
	}
	
}
