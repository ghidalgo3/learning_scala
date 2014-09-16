/**
 * Created by Gustavo on 9/14/14.
 */
object LC2200 {
  val MEM = new Array[Short](65536)
  private val regFile = new Array[Short](16)

  def readReg(reg : Int): Short = regFile(reg)
  //doesn't return anything
  def writeReg(reg:Int, value:Short) {
    if(reg != 0) regFile(reg) = value
  }
}
