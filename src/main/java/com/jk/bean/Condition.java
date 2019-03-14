package com.jk.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Condition implements Serializable {
    private Integer id;

    private String minTitle;

    private String videoPath;

    private String details;

    private String title;

}