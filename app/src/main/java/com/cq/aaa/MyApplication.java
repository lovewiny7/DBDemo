package com.cq.aaa;

import com.waterbase.ui.BaseApplication;
import com.waterbase.utile.Utils;

/**
 * <pre>
 *     desc   :
 *     author : winy7
 *     time   : 2019/11/05
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class MyApplication extends BaseApplication{
    @Override
    protected void initRxRetrofitApp() {
        Utils.init(getApplicationContext());
    }
}
