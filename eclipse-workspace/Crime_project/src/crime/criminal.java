package crime;


public class criminal {

// c_number은 범죄 횟수
/*Lpart,Spart,Do_name,Si_name 은 각각 대분류, 소분류, 도이름, 시이름*/
	
private String name, lpart, spart, year, do_name, si_name ;

private int age,c_number;

public String getLpart() {
return lpart;
}
public void setLpart(String lpart) {
this.lpart = lpart;
}

public String getSpart() {
return spart;
}
public void setSpart(String spart) {
this.spart = spart;
}

public String getYear() {
return year;
}
public void setYear(String year) {
this.year = year;
}

public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}

public int getAge() {
return age;
}
public void setAge(int age) {
this.age = age;
}

public String getDo_name() {
return do_name;
}
public void setDo_name(String do_name) {
this.do_name = do_name;
}

public String getSi_name() {
return si_name;
}
public void setSi_name(String si_name) {
this.si_name = si_name;
}

public int getC_number() {
return c_number;
}
public void setC_number(int c_number) {
this.c_number = c_number;
}



}



