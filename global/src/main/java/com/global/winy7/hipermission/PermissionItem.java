package com.global.winy7.hipermission;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/10 0010.
 */

public class PermissionItem implements Serializable {
    public String PermissionName; //权限名称，为用户展示
    public String Permission; //需要的权限
    public int PermissionIconRes; //权限图片，为用户展示

    public PermissionItem(String permission, String permissionName, int permissionIconRes) {
        Permission = permission;
        PermissionName = permissionName;
        PermissionIconRes = permissionIconRes;
    }

    public PermissionItem(String permission) {
        Permission = permission;
    }
}
