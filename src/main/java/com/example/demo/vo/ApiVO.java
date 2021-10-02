package com.example.demo.vo;
import javax.xml.bind.annotation.XmlRootElement;


import lombok.Data;

@Data
@XmlRootElement(name = "Api")
public class ApiVO{
	String name;
	String status;
}
