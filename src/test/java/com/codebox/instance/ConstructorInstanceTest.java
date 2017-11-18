/**
 * JavaBean Tester (https://github.com/hazendaz/javabean-tester)
 *
 * Copyright (c) 2012 - 2017 Hazendaz.
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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Assert;
import org.junit.Test;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;

/**
 * The Class ConstructorInstanceTest.
 */
public class ConstructorInstanceTest {

    /** The constructor instance. */
    @Tested
    ConstructorInstance constructorInstance;

    /**
     * New instance instantiation exception.
     *
     * @param mockConstructor
     *            the mock constructor
     * @throws InstantiationException
     *             the instantiation exception
     * @throws IllegalAccessException
     *             the illegal access exception
     * @throws InvocationTargetException
     *             the invocation target exception
     */
    @Test(expected = AssertionError.class)
    public void newInstanceInstantiationException(@Mocked Constructor<?> mockConstructor)
            throws InstantiationException, IllegalAccessException, InvocationTargetException {
        Assert.assertNotNull(new Expectations() {
            {
                mockConstructor.newInstance();
                this.result = new InstantiationException();
            }
        });
        ConstructorInstance.newInstance(mockConstructor);
    }

    /**
     * New instance illegal access exception.
     *
     * @param mockConstructor
     *            the mock constructor
     * @throws InstantiationException
     *             the instantiation exception
     * @throws IllegalAccessException
     *             the illegal access exception
     * @throws InvocationTargetException
     *             the invocation target exception
     */
    @Test(expected = AssertionError.class)
    public void newInstanceIllegalAccessException(@Mocked Constructor<?> mockConstructor)
            throws InstantiationException, IllegalAccessException, InvocationTargetException {
        Assert.assertNotNull(new Expectations() {
            {
                mockConstructor.newInstance();
                this.result = new IllegalAccessException();
            }
        });
        ConstructorInstance.newInstance(mockConstructor);
    }

    /**
     * New instance invocation target exception.
     *
     * @param mockConstructor
     *            the mock constructor
     * @throws InstantiationException
     *             the instantiation exception
     * @throws IllegalAccessException
     *             the illegal access exception
     * @throws InvocationTargetException
     *             the invocation target exception
     */
    @Test(expected = AssertionError.class)
    public void newInstanceInvocationTargetException(@Mocked Constructor<?> mockConstructor)
            throws InstantiationException, IllegalAccessException, InvocationTargetException {
        Assert.assertNotNull(new Expectations() {
            {
                mockConstructor.newInstance();
                this.result = new InvocationTargetException(this.withInstanceOf(Exception.class));
            }
        });
        ConstructorInstance.newInstance(mockConstructor);
    }

}