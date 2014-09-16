import scala.io.Source

/**
 *
 * Created by Gustavo on 9/14/14.
 */
object Assembler extends App {

  val labelSyntax = """([a-z0-9]*:)?"""
  val instructionSyntax = """(add)|(nand)|(addi)|(lw)|(sw)|(beq)|(jalr)|(halt)"""
  val validRegisters = """($zero)|($at)|($v0)|($a0)|($a1)|(a2)|($t0)|($t1)|($t2)|($s0)|($s1)|($s2)|($k0)|($sp)|($fp)|($ra)"""
//  val
  def validateSyntax(instruction:String, address: Int):Boolean = {
    var valid = false
    val tokens = instruction.split(" ")
    if(tokens(0).matches(labelSyntax)) {
      //add to table
    } else { //first token not label
      if(tokens(0).matches(instructionSyntax)) {

      } else {
        valid =
      }
    }
    valid
  }

  if(args.length > 0) {
    val lines = Source.fromFile(args(0)).getLines()
    for(line <- lines.zipWithIndex; line._1.toLowerCase) {
      validateSyntax(line _1, line _2)
    }
  } else println("Please enter a file")
}
