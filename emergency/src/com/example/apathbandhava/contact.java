package com.example.apathbandhava;

public class contact 
{ 
	String name;
	String  number;
	public contact()
	{
		this.name="";
		this.number="";
	}
	public contact(String name,String n)
	{
		this.name=name;
		this.number=n;
	}
	public void setname(String name)
	{
		this.name=name;
	}
	public void setnumber(String no)
	{
		this.number=no;
	}
	public String getname()
	{
		return this.name;
	}
	public String getnumber()
	{
		return this.number;
	}
	
}
