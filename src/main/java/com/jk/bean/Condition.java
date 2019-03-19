package com.jk.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Condition implements Serializable {
    private Integer id;

    private String minTitle;

    private String videoPath;

    private String details;

    private String title;

    private Date systime;

    //经纬度
    private String pointxs;

    private String pointys;

    private Integer map;

    private Integer number;

}