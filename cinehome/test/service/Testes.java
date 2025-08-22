package service;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import static org.junit.Assert.*;

public class Testes {

    @Test
    public void testValidarSenha() {
        usuarioService usuario = new usuarioService();

        assertTrue(usuario.validarSenha("abcdef"));
        assertTrue(usuario.validarSenha("123456"));

        assertFalse(usuario.validarSenha("abc"));
        assertFalse(usuario.validarSenha(""));
        assertFalse(usuario.validarSenha(null));
    }

    @BeforeClass
    public static void setUpClass() {}

    @AfterClass
    public static void tearDownClass() {}

    @Before
    public void setUp() {}

    @After
    public void tearDown() {}
}
