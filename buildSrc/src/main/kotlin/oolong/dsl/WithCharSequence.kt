package oolong.dsl

interface WithCharSequence : CharSequence {

    override val length
        get() = toString().length

    override fun get(index: Int): Char {
        return toString()[index]
    }

    override fun subSequence(startIndex: Int, endIndex: Int): CharSequence {
        return toString().subSequence(startIndex, endIndex)
    }

}