package org.example;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Unit test for simple App.
 */
public class AppTest 

{   @Test
    public void t() throws SQLException {
    App app = new App();
    app.B();
}

}
