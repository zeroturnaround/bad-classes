package org.zeroturnaround.badclasses.test;

import java.net.URL;

import junit.framework.TestCase;

import org.zeroturnaround.badclasses.BadClasses;

public class BadClassesTest extends TestCase {
  public void testVersion8() throws Exception {
    URL url = BadClassesTest.class.getResource("/8/SampleClass.class");
    String ver = BadClasses.determineVersion(url.openStream(), "SampleClass");
    assertEquals("1.8", ver);
  }

  public void testVersion7() throws Exception {
    URL url = BadClassesTest.class.getResource("/7/SampleClass.class");
    String ver = BadClasses.determineVersion(url.openStream(), "SampleClass");
    assertEquals("1.7", ver);
  }

  public void testVersion6() throws Exception {
    URL url = BadClassesTest.class.getResource("/6/SampleClass.class");
    String ver = BadClasses.determineVersion(url.openStream(), "SampleClass");
    assertEquals("1.6", ver);
  }

  public void testVersion5() throws Exception {
    URL url = BadClassesTest.class.getResource("/5/SampleClass.class");
    String ver = BadClasses.determineVersion(url.openStream(), "SampleClass");
    assertEquals("1.5", ver);
  }

  public void testVersion14() throws Exception {
    URL url = BadClassesTest.class.getResource("/1.4/SampleClass.class");
    String ver = BadClasses.determineVersion(url.openStream(), "SampleClass");
    assertEquals("1.4", ver);
  }

  public void testVersion13() throws Exception {
    URL url = BadClassesTest.class.getResource("/1.3/SampleClass.class");
    String ver = BadClasses.determineVersion(url.openStream(), "SampleClass");
    assertEquals("1.3", ver);
  }

  public void testVersion12() throws Exception {
    URL url = BadClassesTest.class.getResource("/1.2/SampleClass.class");
    String ver = BadClasses.determineVersion(url.openStream(), "SampleClass");
    assertEquals("1.2", ver);
  }

  public void testVersion11() throws Exception {
    URL url = BadClassesTest.class.getResource("/1.1/SampleClass.class");
    String ver = BadClasses.determineVersion(url.openStream(), "SampleClass");
    assertEquals("1.1", ver);
  }
}
