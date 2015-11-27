/**
 * JavaBean Tester (https://github.com/hazendaz/javabean-tester)
 *
 * Copyright (c) 2012 - 2015 Hazendaz.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of The Apache Software License,
 * Version 2.0 which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/LICENSE-2.0.txt
 *
 * Contributors:
 *     CodeBox (Rob Dawson).
 *     Hazendaz (Jeremy Landis).
 */
package com.codebox.instance;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;

/**
 * The Class ClassInstanceTest.
 */
// TODO 11/26/15 Class is not mockable
@Ignore
public class ClassInstanceTest {

    /** The class instance. */
    @Tested
    ClassInstance<Object> classInstance;

    /** The mock clazz. */
    @Mocked
    Class<Object>         mockClazz;

    /**
     * New instance instantiation exception.
     *
     * @throws InstantiationException
     *             the instantiation exception
     * @throws IllegalAccessException
     *             the illegal access exception
     */
    @Test
    public void newInstanceInstantiationException() throws InstantiationException, IllegalAccessException {
        Assert.assertNotNull(new Expectations() {
            {
                ClassInstanceTest.this.mockClazz.newInstance();
                this.result = new InstantiationException();
            }
        });
        this.classInstance.newInstance(this.mockClazz);
    }

    /**
     * New instance illegal access exception.
     *
     * @throws InstantiationException
     *             the instantiation exception
     * @throws IllegalAccessException
     *             the illegal access exception
     */
    @Test
    public void newInstanceIllegalAccessException() throws InstantiationException, IllegalAccessException {
        Assert.assertNotNull(new Expectations() {
            {
                ClassInstanceTest.this.mockClazz.newInstance();
                this.result = new IllegalAccessException();
            }
        });
        this.classInstance.newInstance(this.mockClazz);
    }

}
