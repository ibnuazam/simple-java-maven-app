package com.mycompany.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void testAppConstructor() {
        App app1 = new App();
        App app2 = new App();
        assertEquals(app1.getMessage(), app2.getMessage());
    }

    @Test
    public void testAppMessage()
    {
        App app = new App();
        assertEquals("Hello World!. Ini adalah aplikasi Java Maven sederhana untuk Submission Dicoding Belajar Implementasi CI/CD. Jenkins Pipeline telah berhasil diimplementasikan by Ibnu Azam Alfansuri.", app.getMessage());
    }
}
