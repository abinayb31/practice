package com.mc10.bandaab.mc10codingassignment.Model;

import java.io.Serializable;

/**
 * Created by bandaab on 1/16/18.
 */

public class Studies implements Serializable {
    private Study[] study;

    public Study[] getStudy() {
        return study;
    }

    public void setStudy(Study[] study) {
        this.study = study;
    }
}
