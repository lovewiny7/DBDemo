package com.global.util;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.widget.EditText;

/**
 * 用来设置 EditText Hint
 * 作者：Laughing on 2018/10/24 09:41
 * 邮箱：719240226@qq.com
 */
public class HintUtil {


    /**
     * 用来设置Hint的文字大小
     *
     * @param editText
     * @param hintContent
     */
    public static void hint(EditText editText, String hintContent) {
        SpannableString ss = new SpannableString(hintContent);//定义hint的值
        AbsoluteSizeSpan ass = new AbsoluteSizeSpan(14, true);//设置字体大小 true表示单位是sp
        ss.setSpan(ass, 0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        editText.setHint(new SpannedString(ss));
    }
}
