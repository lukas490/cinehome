
package service;

import model.filmes;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class testeFilmeNome {
    
    public testeFilmeNome() {
    }
    
    @Test
public void testValidarTitulo() {
    filmeService filme = new filmeService();

    assertTrue(filme.validarTitulo("Matrix"));
    assertTrue(filme.validarTitulo("O Senhor dos Anéis"));

    assertFalse(filme.validarTitulo(""));
    assertFalse(filme.validarTitulo("   "));
    assertFalse(filme.validarTitulo(null));
}
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
}
