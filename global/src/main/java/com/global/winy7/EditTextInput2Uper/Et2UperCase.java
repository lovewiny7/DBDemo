package com.global.winy7.EditTextInput2Uper;

import android.text.method.ReplacementTransformationMethod;

/**
 * <pre>
 *     desc   :
 *     author : winy7
 *     time   : 2019/07/12
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class Et2UperCase  extends ReplacementTransformationMethod {
    
    @Override
    protected char[] getOriginal() {
        char[] aa = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        return aa;
    }
    
    @Override
    protected char[] getReplacement() {
        char[] cc = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        return cc;
    }

}
