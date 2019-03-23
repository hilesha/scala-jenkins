import org.scalatest.{FunSpec, FunSuite}
class TestMain extends FunSuite{

  test("check my function call returns 1"){
    assert(1==new Returns1().call)
  }

  test("check next functtion should return 2"){
    assert(2== new Returns1().call2())
  }

}
