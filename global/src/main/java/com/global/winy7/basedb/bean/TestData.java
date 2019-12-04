package com.global.winy7.basedb.bean;

import com.waterbase.utile.StrUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     desc   : 测试数据
 *     author : winy7
 *     time   : 2019/10/23
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class TestData {
    
    private WeiXinUserInfo user;
    private boolean flag = true;
    private List<String> imgs;
    
    public TestData() {
        imgs = new ArrayList<>();
        imgs.add("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=ad628627aacc7cd9e52d32d909032104/32fa828ba61ea8d3fcd2e9ce9e0a304e241f5803.jpg");
        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1571831805819&di=6bdd94750edfce75e0a4f06de6df4202&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F4610b912c8fcc3cef70d70409845d688d53f20f7.jpg");
        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1571831852696&di=009ba95ad4e0974bc6595118009b9a34&imgtype=0&src=http%3A%2F%2Fg.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fc2cec3fdfc03924590b2a9b58d94a4c27d1e2500.jpg");
        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1571831852696&di=58e712a02f80c0d52d555c5bcc66bf66&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fb812c8fcc3cec3fdb850efcfdc88d43f87942719.jpg");
        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1571831852696&di=9e074226988bbb8e6d1410f31e213c14&imgtype=0&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F0ff41bd5ad6eddc40189fc4133dbb6fd52663319.jpg");
        imgs.add("http://i0.hdslb.com/bfs/article/ff013733e1300f57aa7875fe7c83e9c7e3f99c20.jpg");
        imgs.add("http://b-ssl.duitang.com/uploads/item/201709/14/20170914120533_2CAMH.jpeg");
        imgs.add("http://img3.duitang.com/uploads/blog/201504/06/20150406083951_32h8d.jpeg");
        imgs.add("http://pic40.nipic.com/20140412/11412826_124950636000_2.jpg");
        imgs.add("http://b-ssl.duitang.com/uploads/item/201412/06/20141206213547_jYZf5.jpeg");
        imgs.add("http://b-ssl.duitang.com/uploads/item/201801/01/20180101192713_V3JM2.jpeg");
        imgs.add("http://b-ssl.duitang.com/uploads/item/201407/09/20140709180312_HaE8a.jpeg");
        imgs.add("http://pic22.nipic.com/20120711/1329689_115052549137_2.jpg");
        imgs.add("http://b-ssl.duitang.com/uploads/item/201603/10/20160310063404_WJ4Uw.jpeg");
        imgs.add("http://img.zcool.cn/community/017a2b564ea39d6ac7251c949b8357.jpg@1280w_1l_2o_100sh.png");
        imgs.add("http://b-ssl.duitang.com/uploads/item/201804/04/20180404205514_EEdVW.jpeg");
        imgs.add("http://img.zcool.cn/community/0110fa554bb3bf000001bf7233f197.jpg@1280w_1l_2o_100sh.jpg");
        imgs.add("http://cdn.duitang.com/uploads/item/201410/03/20141003000033_ueE4c.jpeg");
        imgs.add("http://b-ssl.duitang.com/uploads/item/201210/04/20121004230801_REwRt.jpeg");
        imgs.add("http://b-ssl.duitang.com/uploads/blog/201307/04/20130704171156_HRBQS.jpeg");
        imgs.add("http://b-ssl.duitang.com/uploads/item/201302/05/20130205000616_GBshd.jpeg");
        imgs.add("http://b-ssl.duitang.com/uploads/blog/201510/14/20151014230535_2Vrha.jpeg");
        imgs.add("http://b-ssl.duitang.com/uploads/item/201804/29/20180429134705_yk5mz.jpeg");
        imgs.add("http://b-ssl.duitang.com/uploads/item/201303/18/20130318230216_dE4Gs.jpeg");
        imgs.add("http://b-ssl.duitang.com/uploads/item/201511/30/20151130090934_siGBh.jpeg");
        imgs.add("http://b-ssl.duitang.com/uploads/item/201601/25/20160125213603_PQEBi.jpeg");
    }
    
    public WeiXinUserInfo getUser() {
        
        if (flag) {
            WeiXinUserInfo info = new WeiXinUserInfo();
            info.setWeiXInName("为了部落");
            info.setWeiXinId("cq347267801");
            info.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1572415698&di=fed33435703f755396346731b43b0a3a&imgtype=jpg&er=1&src=http%3A%2F%2Fwww.hwua.com%2Fsites%2Fwww.hwua." +
                    "com%2Ffiles%2FwKiom1ima9OQ6xz5AAAbLL3gzc8755.jpg-wh_651x-s_3335247430.jpg");
            info.setAge(27);
            info.setCountry("中国");
            info.setProvince("陕西");
            info.setCity("西安");
            info.setSignature("你爱咋地咋地");
            info.setCheckMess("我是为了部落");
            info.setSex(1);
            info.setRealName("曹琦");
            info.setIdCard("66523456411255354");
            return info;
        } else return user;
        
        
    }
    
    public void setUser(WeiXinUserInfo user) {
        this.user = user;
        flag = false;
        
    }
    
    public List<String> getImgs() {
        return imgs;
    }
    
    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }
}
