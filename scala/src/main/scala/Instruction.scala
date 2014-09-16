/**
 * Created by Gustavo on 9/15/14.
 */
abstract class Instruction {
  def name:String
  def validInstructions : String
  def validRegisters : String = """($zero)|($at)|($v0)|($a0)|($a1)|(a2)|($t0)|($t1)|($t2)|($s0)|($s1)|($s2)|($k0)|($sp)|($fp)|($ra)"""
  if(!name.toLowerCase.matches(validInstructions)) throw new MalformedInstruction
}

class MalformedInstruction extends Exception
class TooLongBranchOffset extends Exception

class RType(insName:String, arg1:String, arg2:String, arg3:String) extends Instruction {
  override def validInstructions = """(add)|(nand)"""
  override def name = insName
}

class IType(insName:String, arg1:String, arg2:String, value:Short) extends Instruction {
  override def validInstructions = """(addi)|(lw)|(sw)|(beq)"""
  if(!(-16 <= value && value <= 15)) throw new TooLongBranchOffset
  override def name = insName
}

class JType(insName:String, targetAddress:String, returnAddress:String) extends Instruction {
  override def validInstructions = """(jalr)"""
  override def name = insName
}

class SType(insName:String) extends Instruction{
  override def validInstructions = """(halt)"""
  override def name = insName
}