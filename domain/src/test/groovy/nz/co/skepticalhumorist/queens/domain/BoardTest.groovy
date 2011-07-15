package nz.co.skepticalhumorist.queens.domain

import org.junit.Test
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertTrue

class BoardTest {

  @Test
  void testCreate() {
    def b1 = new Board(1)
    def b2 = new Board(2)
    def b20 = new Board(20)
    assertTrue(true)
  }

  @Test
  void testSize() {
    def b1 = new Board(1)
    assertEquals(1, b1.size)
    def b4 = new Board(4)
    assertEquals(4, b4.size)
    def b20 = new Board(20)
    assertEquals(20, b20.size)
  }

  @Test
  void testPlace() {
    def b = new Board(4);
    assertEquals(-1, b.getCol(0))
    assertEquals(-1, b.getCol(1))
    assertEquals(-1, b.getCol(2))
    assertEquals(-1, b.getCol(3))
    b.place(0, 1)
    b.place(1, 3)
    b.place(2, 0)
    b.place(3, 2)
    assertEquals(1, b.getCol(0))
    assertEquals(3, b.getCol(1))
    assertEquals(0, b.getCol(2))
    assertEquals(2, b.getCol(3))
  }

  @Test
  void testUnplace() {
    def b = new Board(4)
    b.place(0, 1)
    assertFalse(b.isOk(1, 1))
    assertFalse(b.isOk(0, 1))
    assertFalse(b.isOk(2, 3))
    b.unplace(0)
    assertTrue(b.isOk(1, 1))
    assertTrue(b.isOk(0, 1))
    assertTrue(b.isOk(2, 3))
    b.place(1, 3)
    b.place(2, 0)
    b.place(3, 2)
    assertEquals(3, b.unplace(1))
    assertEquals(-1, b.getCol(1))
    assertEquals(2, b.unplace(3))
    assertEquals(-1, b.getCol(3))
  }

  @Test
  void testIsOk() {
    def b = new Board(4)
    assertTrue( b.isOk(0, 0)); assertTrue( b.isOk(0, 1)); assertTrue( b.isOk(0, 2)); assertTrue( b.isOk(0, 3));
    assertTrue( b.isOk(1, 0)); assertTrue( b.isOk(1, 1)); assertTrue( b.isOk(1, 2)); assertTrue( b.isOk(1, 3));
    assertTrue( b.isOk(2, 0)); assertTrue( b.isOk(2, 1)); assertTrue( b.isOk(2, 2)); assertTrue( b.isOk(2, 3));
    assertTrue( b.isOk(3, 0)); assertTrue( b.isOk(3, 1)); assertTrue( b.isOk(3, 2)); assertTrue( b.isOk(3, 3));
    b.place(0, 1)
    assertTrue(!b.isOk(1, 0)); assertTrue(!b.isOk(1, 1)); assertTrue(!b.isOk(1, 2)); assertTrue( b.isOk(1, 3));
    assertTrue( b.isOk(2, 0)); assertTrue(!b.isOk(2, 1)); assertTrue( b.isOk(2, 2)); assertTrue(!b.isOk(2, 3));
    assertTrue( b.isOk(3, 0)); assertTrue(!b.isOk(3, 1)); assertTrue( b.isOk(3, 2)); assertTrue( b.isOk(3, 3));
    b.place(1, 3)
    assertTrue( b.isOk(2, 0)); assertTrue(!b.isOk(2, 1)); assertTrue(!b.isOk(2, 2)); assertTrue(!b.isOk(2, 3));
    assertTrue( b.isOk(3, 0)); assertTrue(!b.isOk(3, 1)); assertTrue( b.isOk(3, 2)); assertTrue(!b.isOk(3, 3));
    b.place(2, 0)
    assertTrue(!b.isOk(3, 0)); assertTrue(!b.isOk(3, 1)); assertTrue( b.isOk(3, 2)); assertTrue(!b.isOk(3, 3));
  }

  @Test
  void testSolveFalse() {
    def b = new Board(3)
    assertFalse(b.solve())
  }

  @Test
  void testSolveTrue() {
    def b = new Board(4)
    assertTrue(b.solve())
    assertEquals(1, b.getCol(0))
    assertEquals(3, b.getCol(1))
    assertEquals(0, b.getCol(2))
    assertEquals(2, b.getCol(3))
  }

}

