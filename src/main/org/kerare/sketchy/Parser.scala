// vim: set noexpandtab shiftwidth=4 tabstop=4 softtabstop=4

package org.kerare.sketchy

import scala.util.parsing.combinator._

class Parser extends JavaTokenParsers {
	def operator: Parser[Any] = ":="
	def value: Parser[Any] = stringLiteral
	def definition: Parser[Any] = ident <~ operator ~> value ^^ (ident, value)
	def program: Parser[Any] = rep(definition) ^^ (Map() ++ _)
}

