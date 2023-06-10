package com.len.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeariningUtilTest {

    @Test
    void getLearingDetails() {

        Assertions.assertInstanceOf(List.class,LeariningUtil.getLearingDetails());
    }
}