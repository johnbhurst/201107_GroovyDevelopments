package nz.co.skepticalhumorist.queens.domain

import org.junit.Test

class BoardTest {

  @Test
  void testCreate() {
    assert new Board(1)  != null
    assert new Board(2)  != null
    assert new Board(20) != null
  }

  @Test
  void testSize() {
    def b1 = new Board(1)
    assert 1 == b1.size
    def b4 = new Board(4)
    assert 4 == b4.size
    def b20 = new Board(20)
    assert 20 == b20.size
  }

  @Test
  void testPlace() {
    def b = new Board(4);
    assert -1 == b.getCol(0)
    assert -1 == b.getCol(1)
    assert -1 == b.getCol(2)
    assert -1 == b.getCol(3)
    b.place(0, 1)
    b.place(1, 3)
    b.place(2, 0)
    b.place(3, 2)
    assert 1 == b.getCol(0)
    assert 3 == b.getCol(1)
    assert 0 == b.getCol(2)
    assert 2 == b.getCol(3)
  }

  @Test
  void testUnplace() {
    def b = new Board(4)
    b.place(0, 1)
    assert !b.isOk(1, 1)
    assert !b.isOk(0, 1)
    assert !b.isOk(2, 3)
    b.unplace(0)
    assert b.isOk(1, 1)
    assert b.isOk(0, 1)
    assert b.isOk(2, 3)
    b.place(1, 3)
    b.place(2, 0)
    b.place(3, 2)
    assert 3 == b.unplace(1)
    assert -1 == b.getCol(1)
    assert 2 == b.unplace(3)
    assert -1 == b.getCol(3)
  }

  @Test
  void testIsOk() {
    def b = new Board(4)
    assert  b.isOk(0, 0); assert  b.isOk(0, 1); assert  b.isOk(0, 2); assert  b.isOk(0, 3);
    assert  b.isOk(1, 0); assert  b.isOk(1, 1); assert  b.isOk(1, 2); assert  b.isOk(1, 3);
    assert  b.isOk(2, 0); assert  b.isOk(2, 1); assert  b.isOk(2, 2); assert  b.isOk(2, 3);
    assert  b.isOk(3, 0); assert  b.isOk(3, 1); assert  b.isOk(3, 2); assert  b.isOk(3, 3);
    b.place(0, 1)
    assert !b.isOk(1, 0); assert !b.isOk(1, 1); assert !b.isOk(1, 2); assert  b.isOk(1, 3);
    assert  b.isOk(2, 0); assert !b.isOk(2, 1); assert  b.isOk(2, 2); assert !b.isOk(2, 3);
    assert  b.isOk(3, 0); assert !b.isOk(3, 1); assert  b.isOk(3, 2); assert  b.isOk(3, 3);
    b.place(1, 3)
    assert  b.isOk(2, 0); assert !b.isOk(2, 1); assert !b.isOk(2, 2); assert !b.isOk(2, 3);
    assert  b.isOk(3, 0); assert !b.isOk(3, 1); assert  b.isOk(3, 2); assert !b.isOk(3, 3);
    b.place(2, 0)
    assert !b.isOk(3, 0); assert !b.isOk(3, 1); assert  b.isOk(3, 2); assert !b.isOk(3, 3);
  }

  @Test
  void testSolveFalse() {
    def b = new Board(3)
    assert !b.solve()
  }

  @Test
  void testSolveTrue() {
    def b = new Board(4)
    assert b.solve()
    assert 1 == b.getCol(0)
    assert 3 == b.getCol(1)
    assert 0 == b.getCol(2)
    assert 2 == b.getCol(3)
  }

}

