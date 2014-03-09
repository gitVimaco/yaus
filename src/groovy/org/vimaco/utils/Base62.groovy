package org.vimaco.utils

/**
 * Created by Vimaco on 6/03/14.
 *
 * Util class to encode and decode in Base62 with a XOR CheckSum character
 *
 * Encoding takes an Integer in Base10 and encodes it in Base62 (a-zA-Z0-9) using a bijective function f() 0->'a', 1->'b',
 * ..., 25-'z', 26->'A', ..., 51-'Z', 52->'0', ..., 61->'9' adding a XOR CheckSum character.
 *
 * Decoding takes a String in Base62 and applies g() the reverse of the bijective function f() used to encode and checks the
 * CheckSum:
 * If the String has m+1 characters [C0,C1, ..., Cm-1, Cm] then [C0..Cm-1] is the code and Cm the CheckSum character
 * To decode we apply a change of base: g(C0)*62^(m-1) + g(C1)*62^(m-2) + ... + g(Cm-1)*62^0 and we validate de CheckSum
 */
class Base62 {
    static BASE62 = (('a'..'z')+('A'..'Z')+('0'..'9')).join()
    static BigInteger base = BASE62.size()
    static ERROR = -1

    /**
     * Encodes an Integer in Base62 adding a CheckSum character
     * @param number Integer to code
     * @return Coded String or null in case of Error
     */
    static encode(number) {
        // Check if we can apply the encoding, only integer inputs are accepted
        if (!(number instanceof Integer) && !(number instanceof BigInteger) && !(number instanceof Long) && !(number instanceof Short)&& !(number instanceof Byte))
            return null
        BigInteger num = number
        def code = new StringBuilder()
        // To generate XOR CheckSum we start with a 1filled binary string
        def sum = base-1
        while (num > 0) {
            int remainder = num.mod(base)
            sum ^= remainder
            code << BASE62.charAt(remainder)
            num = num.intdiv(base)
        }
        // As we start adding last character, we have to reverse the StringBuilder
        code.reverse()
        // We add the generated CheckSum
        code << BASE62.charAt(sum.mod(base))
        code.toString()
    }

    /**
     * Decodes a String in Base62 with a CheckSum character and validates the CheckSum
     * @param code String to decode
     * @return Decoded Integer or -1 in case of Error
     */
    static decode(code) {
        if (!(code instanceof String)) // input has to be a String
            return Base62.ERROR
        if (code.size() < 2) // 2 is the min code length: 1 code character + 1 checksum character
            return Base62.ERROR
        def id = 0
        def sum = base-1
        // We take the part of the code that we have to change the base and we decode it calculating the expected CheckSum
        code.substring(0, code.size() - 1).reverse().eachWithIndex { c, i ->
            id += BASE62.indexOf(c) * base.power(i)
            sum ^= BASE62.indexOf(c)
        }
        def c = BASE62.charAt(sum.mod(base))
        // We validate the CheckSum
        if (c != code[code.size()-1]) id = ERROR
        id
    }
}
