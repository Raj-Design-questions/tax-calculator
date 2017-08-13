package com.hotels.tax;

import org.mockito.MockitoAnnotations;

import javax.transaction.Transactional;

@Transactional
public abstract class TestBase {

    @org.junit.Before
    public void testBaseSetup() {
        MockitoAnnotations.initMocks(this);
    }
}
