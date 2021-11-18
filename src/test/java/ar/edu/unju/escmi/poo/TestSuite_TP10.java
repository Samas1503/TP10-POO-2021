package ar.edu.unju.escmi.poo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.TestCase;

@RunWith(Suite.class)
@SuiteClasses({ ClienteUtilTest.class, MozoUtilTest.class, ReservaUtilTest.class, SalonUtilTest.class })
public class TestSuite_TP10 extends TestCase {

}
