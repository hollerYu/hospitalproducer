package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class Specialist implements Serializable {
    private Integer id;

    private String name;

    private String position;

    private String address;

    private int look;

    private int medal;

    private String img;

    private String viewpoint;

    private String title;

    @JsonFormat(timezone = "GTM+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creatTime;

    private String details;

    private Integer status;

    //临时字段
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    private Integer rank;

}