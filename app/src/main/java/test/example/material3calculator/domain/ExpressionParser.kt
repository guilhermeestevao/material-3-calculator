package test.example.material3calculator.domain

class ExpressionParser(
    val expression: String
) {

    fun parse(): List<ExpressionPart> {
        val result = mutableListOf<ExpressionPart>()
        var j = 0
        while(j < expression.length) {
            val current = expression[j]
            when{
                current in operationSymbols -> result.add(ExpressionPart.Op(operationFromSymbol(current)))
                current.isDigit() -> {
                    j = parserNuber(j, result)
                    continue
                }
                current in "()" -> parseParentheses(current, result)
            }
            j++
        }
        return result
    }

    private fun parserNuber(startIndex: Int, result: MutableList<ExpressionPart>): Int {
        var i = startIndex
        val numberAsString = buildString {
            while (i < expression.length && expression[i] in ".0123456789") {
                append(expression[i])
                i++
            }
        }
        result.add(ExpressionPart.Number(numberAsString.toDouble()))
        return i
    }


    private fun parseParentheses(current: Char, result: MutableList<ExpressionPart>) {
        result.add(
            ExpressionPart.Parentheses(
                when(current) {
                    '(' -> ParenthesesType.Opening
                    ')' -> ParenthesesType.Closing
                    else -> throw IllegalArgumentException("Invalid parentheses type")
                }
            )
        )
    }

}